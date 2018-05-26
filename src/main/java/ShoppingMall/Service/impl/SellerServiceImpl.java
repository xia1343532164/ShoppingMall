package ShoppingMall.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ShoppingMall.Dao.SellerDao;
import ShoppingMall.Service.SellerService;
import ShoppingMall.entity.Commodity;

@Service
@Transactional
public class SellerServiceImpl implements SellerService {

	@Autowired
	private  SellerDao sellerDao;
	
	@Override
	public void addCommodity(Commodity commodity) {
          sellerDao.addCommodity(commodity);
	}

}
