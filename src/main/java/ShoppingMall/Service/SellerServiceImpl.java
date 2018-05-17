package ShoppingMall.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShoppingMall.Dao.SellerDao;
import ShoppingMall.entity.Commodity;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private  SellerDao sellerDao;
	
	@Override
	public void addCommodity(Commodity commodity) {
          sellerDao.addCommodity(commodity);
	}

}
