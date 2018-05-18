package ShoppingMall.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ShoppingMall.Dao.CommodityDao;
import ShoppingMall.entity.Commodity;

@Service
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityDao commodityDao;
	
	@Override
	public List<Commodity> findAll() {
		return commodityDao.findAll();
	}

	@Override
	public Commodity findOne(Integer id) {
		return commodityDao.findOne(id);
	}
}
