package ShoppingMall.Dao;

import java.util.List;

import ShoppingMall.entity.Order;

public interface OrderDao {


	void createOrder(Integer userId, Integer addressId, Integer proIds, Long ordernumber, int goodscount);

	void delCar(Integer proIds);

	List<Order> findOrder(Integer userid);

	Order findOrderdetails(int orderid);

}
