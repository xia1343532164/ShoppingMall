package ShoppingMall.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShoppingMall.Dao.VipDao;
import ShoppingMall.entity.User;

@Service
public class VipServieImpl implements VipService {

	private VipDao vipDao;
	
	@Autowired
	public VipServieImpl(VipDao vipDao) {
		this.vipDao = vipDao;
	}

	@Override
	public void saveinfo(User user) {
		 vipDao.saveinfo(user);		
	}

}
