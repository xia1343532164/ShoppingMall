package ShoppingMall.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ShoppingMall.Dao.VipDao;
import ShoppingMall.entity.User;

@Service
public class VipServieImpl implements VipService {

	private VipDao vipDao;
	
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public VipServieImpl(VipDao vipDao, PasswordEncoder passwordEncoder) {
		this.vipDao = vipDao;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void saveinfo(User user) {
		 vipDao.saveinfo(user);		
	}
	@Override
	public void alterPassword(Integer id, String password) {
		String encode = passwordEncoder.encode(password);
		vipDao.alterPassword(id,encode);
	}

}
