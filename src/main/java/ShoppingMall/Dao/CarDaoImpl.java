package ShoppingMall.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ShoppingMall.Dao.mapper.CarMapper;
import ShoppingMall.entity.Car;
import ShoppingMall.entity.VipAddress;

@Repository
public class CarDaoImpl implements CarDao {

	@Autowired
	private CarMapper carMapper;
	
	@Override
	public void addCar(Integer userId, int id) {
           carMapper.addCar(userId,id);
	}

	@Override
	public List<Car> findAll(Integer id) {
		return carMapper.findAll(id);
	}

	@Override
	public void delCar(int id) {
             carMapper.delCar(id);		
	}
}
