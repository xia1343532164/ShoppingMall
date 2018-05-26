package ShoppingMall.Dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ShoppingMall.Dao.CommodityDao;
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

	@Override
	public Commodity findOne(Integer id) {
		return commodityMapper.findOne(id);
	}

}
