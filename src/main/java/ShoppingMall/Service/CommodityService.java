package ShoppingMall.Service;

import java.util.List;

import ShoppingMall.entity.Commodity;

public interface CommodityService {

	List<Commodity> findAll();

	Commodity findOne(Integer id);

}
