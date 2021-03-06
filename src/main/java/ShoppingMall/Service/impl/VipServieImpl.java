package ShoppingMall.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ShoppingMall.Dao.VipDao;
import ShoppingMall.Service.VipService;
import ShoppingMall.entity.User;
import ShoppingMall.entity.VipAddress;

@Service
@Transactional
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
		System.out.println(user+"111111");
		 vipDao.saveinfo(user);		
	}
	@Override
	public void alterPassword(Integer id, String password) {
		String encode = passwordEncoder.encode(password);
		vipDao.alterPassword(id,encode);
	}

	@Override
	public void addAddress(VipAddress address) {
		vipDao.addAddress(address);		
	}

	@Override
	public List<VipAddress> findAll(Integer id) {
		return vipDao.findAll(id);
	}

	@Override
	public void delete(Integer id) {
          vipDao.delete(id);		
	}

	@Override
	public void alterAddress(VipAddress vipAddress) {
           vipDao.alterAddress(vipAddress);		
	}

	@Override
	public VipAddress findIdOneAddres(Integer id) {
		return vipDao.findIdOneAddres(id);
	}

}
