package ShoppingMall.Service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ShoppingMall.Dao.UserDao;
import ShoppingMall.entity.User;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =  userDao.findOneByUsername(username);
		if(user==null){
			throw new UsernameNotFoundException("找不到该用户的信息");
		}
		return new UserDetailsImpl(user);
	}

	public void create(User user) {
		   String encode = passwordEncoder.encode(user.getPassword());
		   System.out.println(encode);
		   user.setPassword(encode);
		   System.out.println(user);
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