package ShoppingMall.Dao;

import java.util.List;

import ShoppingMall.entity.Car;


public interface CarDao {

	void addCar(Integer userId, Integer id);

	List<Car> findAll(Integer id);

	void minusConut(Integer id);

	void addCount(Integer userId, Integer id);

	Car findOneCar(Integer id);

	void delAll(Integer id);

	void delCar(Integer carid);

	Car checkCar(Integer userId, Integer id);

	void addCarCount(Integer carid);

}
