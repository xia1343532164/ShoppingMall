package ShoppingMall.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ShoppingMall.Dao.OrderDao;
import ShoppingMall.Service.OrderService;
import ShoppingMall.entity.Order;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao orderDao;
	

	@Override
	public void createOrder(Integer userId, Integer addressId, List<Integer> proId,Long ordernumber,int goodscount) {
      for (Integer proIds : proId) {
    	  orderDao.createOrder(userId,addressId,proIds, ordernumber,goodscount);
	}
	}

	@Override
	public void delCar(List<Integer> proId) {
           for (Integer proIds : proId) {
			orderDao.delCar(proIds);
		}		
	}

	@Override
	public List<Order> findOrder(Integer userid) {
		return orderDao.findOrder(userid);
	}

	@Override
	public Order findOrderdetails(int orderid) {
		return orderDao.findOrderdetails(orderid);
	}
}
