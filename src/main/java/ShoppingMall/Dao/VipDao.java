package ShoppingMall.Dao;

import java.util.List;

import ShoppingMall.entity.User;
import ShoppingMall.entity.VipAddress;

public interface VipDao {

	void saveinfo(User user);

	void alterPassword(Integer id, String encode);

	void addAddress(VipAddress address);

	List<VipAddress> findAll(Integer id);

	void delete(Integer id);

	void alterAddress(VipAddress vipAddress);

	VipAddress findIdOneAddres(Integer id);

}
