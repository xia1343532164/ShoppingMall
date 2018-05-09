package ShoppingMall.Service;

import ShoppingMall.entity.User;

public interface UserService {

	void create(User user);

	boolean check(String username);


}
