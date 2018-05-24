package ShoppingMall.Service;

import java.util.List;

public interface OrderService {

	void createOrder(Integer userId, Integer addressId, List<Integer> proId);

	void delCar(List<Integer> proId);

}
