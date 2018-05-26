package ShoppingMall.Service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ShoppingMall.Dao.UserDao;
import ShoppingMall.Service.UserService;
import ShoppingMall.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =  userDao.findOneByUsername(username);
		if(user==null){
			throw new UsernameNotFoundException(username);
		}
		return new UserDetailsImpl(user);
	}

	public void create(User user) {
           userDao.create(user);		
	}

}
class UserDetailsImpl extends org.springframework.security.core.userdetails.User{

	private static final long serialVersionUID = 1L;
	
	private User user;

	public UserDetailsImpl(User user) {
		super(user.getUsername(),user.getPassword(),
				Arrays.asList(new SimpleGrantedAuthority("ROLE_"+ user.getRole())));
		this.user = user;
	}

	public User getUser() {
		return user;
	}
}