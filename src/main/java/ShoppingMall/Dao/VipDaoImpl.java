package ShoppingMall.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ShoppingMall.Dao.mapper.VipMapper;
import ShoppingMall.entity.User;

@Repository
public class VipDaoImpl implements VipDao {
	@Autowired
	private VipMapper vipMapper;

	@Override
	public void saveinfo(User user) {
		 vipMapper.saveinfo(user);
		
	}
}
