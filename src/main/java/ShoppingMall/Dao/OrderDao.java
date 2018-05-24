package ShoppingMall.Dao;

public interface OrderDao {


	void createOrder(Integer userId, Integer addressId, Integer proIds);

	void delCar(Integer proIds);

}
