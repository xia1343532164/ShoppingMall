package ShoppingMall.Dao;

import java.util.List;

import ShoppingMall.entity.Commodity;

public interface CommodityDao {

	List<Commodity> findAll();

	Commodity findOne(Integer id);

}
