package ShoppingMall.Dao;

import java.util.List;

import ShoppingMall.entity.Car;
import ShoppingMall.entity.VipAddress;


public interface CarDao {

	void addCar(Integer userId, int id);

	List<Car> findAll(Integer id);

	void delCar(int id);

}
