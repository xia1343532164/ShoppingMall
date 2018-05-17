package ShoppingMall.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ShoppingMall.Dao.mapper.SellerMapper;
import ShoppingMall.entity.Commodity;

@Repository
public class SellerDaoImpl implements SellerDao {
	
	@Autowired
	private SellerMapper sellerMapper;

	@Override
	public void addCommodity(Commodity commodity) {
		sellerMapper.addCommodity(commodity);
	}
}
