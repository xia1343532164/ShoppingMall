package ShoppingMall.Dao.mapper;

import java.util.List;

import ShoppingMall.entity.VipAddress;

public interface AddressMapper {

	void addAddress(VipAddress address);

	List<VipAddress> findAll(Integer id);

	void delete(Integer id);

	void alterAddress(VipAddress vipAddress);

	VipAddress findIdOneAddres(Integer id);
}
