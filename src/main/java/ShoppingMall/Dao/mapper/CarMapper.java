package ShoppingMall.Dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ShoppingMall.entity.Car;
import ShoppingMall.entity.VipAddress;

public interface CarMapper {

	void addCar(@Param(value="userId")Integer userId, @Param(value="id")Integer id);

	List<Car> findAll(Integer id);

	List<VipAddress> findAddress(Integer id);

	void minusCount(Integer id);

	void addCount(@Param(value="userId")Integer userId, @Param(value="id")Integer id);

	Car findOneCar(Integer id);

	void delAll(Integer id);

	void delCar(Integer carid);

	Car checkCar(@Param(value="userId")Integer userId, @Param(value="id")Integer id);

	void addCarCount(Integer carid);

}
