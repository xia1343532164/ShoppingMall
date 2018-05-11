package ShoppingMall.Dao;

import ShoppingMall.entity.User;

public interface VipDao {

	void saveinfo(User user);

	void alterPassword(Integer id, String encode);

}
