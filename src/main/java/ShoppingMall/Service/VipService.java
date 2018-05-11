package ShoppingMall.Service;

import ShoppingMall.entity.User;

public interface VipService {

	void saveinfo(User user);

	void alterPassword(Integer id, String password);

}
