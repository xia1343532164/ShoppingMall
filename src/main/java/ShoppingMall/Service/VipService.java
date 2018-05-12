package ShoppingMall.Service;

import ShoppingMall.entity.User;
import ShoppingMall.entity.VipAddress;

public interface VipService {

	void saveinfo(User user);

	void alterPassword(Integer id, String password);

	void addAddress(VipAddress address);

}
