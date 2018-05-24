package ShoppingMall.Service;

import java.util.List;

import ShoppingMall.entity.Car;

public interface CarService {
	
	void addCar(Integer userId, Integer id);

	List<Car> findAll(Integer id);

	void minusCount(Integer id);

	void addCount(Integer userId, Integer id);

	Car findOneCar(Integer id);

	void delAll(Integer id);

	void delCar(Integer carid);

	Car checkCar(Integer userId, Integer id);

	void addCarCount(Integer carid);


}
