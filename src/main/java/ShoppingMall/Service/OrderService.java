package ShoppingMall.Service;

import java.util.List;

import ShoppingMall.entity.Order;

public interface OrderService {

	void createOrder(Integer userId, Integer addressId, List<Integer> proId, Long ordernumber);

	void delCar(List<Integer> proId);

	List<Order> findOrder(Integer id);

	Order findOrderdetails(int orderid);


}
