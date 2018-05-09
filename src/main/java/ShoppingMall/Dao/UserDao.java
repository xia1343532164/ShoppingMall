package ShoppingMall.Dao;

import ShoppingMall.entity.User;

public interface UserDao {

	User findOneByUsername(String username);

	void create(User user);

	boolean check(String username);

}
