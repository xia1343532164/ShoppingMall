package ShoppingMall.Dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ShoppingMall.Dao.OrderDao;
import ShoppingMall.Dao.mapper.OrderMapper;
import ShoppingMall.entity.Order;

@Repository
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public void createOrder(Integer userId, Integer addressId, Integer proIds,Long ordernumber) {
		 orderMapper.createOrder(userId,addressId,proIds,ordernumber);				
	}

	@Override
	public void delCar(Integer proIds) {
        orderMapper.delCar(proIds);		
	}

	@Override
	public List<Order> findOrder(Integer userid) {
		return orderMapper.findOrder(userid);
	}

	@Override
	public Order findOrderdetails(int orderid) {
		return orderMapper.findOrderdetails(orderid);
	}


}
