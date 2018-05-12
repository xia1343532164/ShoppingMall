package ShoppingMall.Dao;

import ShoppingMall.entity.User;
import ShoppingMall.entity.VipAddress;

public interface VipDao {

	void saveinfo(User user);

	void alterPassword(Integer id, String encode);

	void addAddress(VipAddress address);

}
