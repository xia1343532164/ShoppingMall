package ShoppingMall.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ShoppingMall.Dao.mapper.UserMapper;
import ShoppingMall.entity.User;

@Repository
public class VipDaoImpl implements VipDao {
	@Autowired
	private UserMapper userMapper;

	@Override
	public void saveinfo(User user) {
		System.err.println(user);
		userMapper.saveinfo(user);
	}
}
