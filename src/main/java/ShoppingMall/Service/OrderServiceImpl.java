package ShoppingMall.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ShoppingMall.Dao.OrderDao;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao orderDao;

	@Override
	public void createOrder(Integer userId, Integer addressId, List<Integer> proId) {
      for (Integer proIds : proId) {
    	  orderDao.createOrder(userId,addressId,proIds);
	}
	}

	@Override
	public void delCar(List<Integer> proId) {
           for (Integer proIds : proId) {
			orderDao.delCar(proIds);
		}		
	}

}
