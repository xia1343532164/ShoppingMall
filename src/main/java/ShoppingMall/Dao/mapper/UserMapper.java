package ShoppingMall.Dao.mapper;

import ShoppingMall.entity.User;

public interface UserMapper {

	User findOneByUsername(String username);

	void create(User user);

}
