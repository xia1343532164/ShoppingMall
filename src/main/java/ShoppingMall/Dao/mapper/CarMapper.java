package ShoppingMall.Dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ShoppingMall.entity.Car;
import ShoppingMall.entity.VipAddress;

public interface CarMapper {

	void addCar(@Param(value="userId")Integer userId, @Param(value="id")int id);

	List<Car> findAll(Integer id);

	void delCar(int id);

	List<VipAddress> findAddress(Integer id);
}
