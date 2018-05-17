package ShoppingMall.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ShoppingMall.Dao.mapper.CommodityMapper;
import ShoppingMall.entity.Commodity;

@Repository
public class CommodityDaoImpl implements CommodityDao {

	@Autowired
	private CommodityMapper commodityMapper;
	
	@Override
	public List<Commodity> findAll() {
		return commodityMapper.findAll();
	}

}
