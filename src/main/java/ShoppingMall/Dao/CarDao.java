package ShoppingMall.Dao;

import java.util.List;

import ShoppingMall.entity.Car;


public interface CarDao {

	void addCar(Integer userId, int id);

	List<Car> findAll(Integer id);

	void delCar(int id);
}
