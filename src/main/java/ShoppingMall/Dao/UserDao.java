package ShoppingMall.Dao;

import ShoppingMall.entity.User;

public interface UserDao {

	User findOneByUsername(String username);

}
