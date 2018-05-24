package ShoppingMall.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ShoppingMall.Dao.mapper.OrderMapper;

@Repository
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	private OrderMapper orderMapper;


	@Override
	public void createOrder(Integer userId, Integer addressId, Integer proIds) {
		 orderMapper.createOrder(userId,addressId,proIds);				
	}


	@Override
	public void delCar(Integer proIds) {
        orderMapper.delCar(proIds);		
	}

}
