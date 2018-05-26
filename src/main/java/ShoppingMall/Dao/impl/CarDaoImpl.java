package ShoppingMall.Dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ShoppingMall.Dao.CarDao;
import ShoppingMall.Dao.mapper.CarMapper;
import ShoppingMall.entity.Car;

@Repository
public class CarDaoImpl implements CarDao {

	@Autowired
	private CarMapper carMapper;
	
	@Override
	public void addCar(Integer userId, Integer id) {
           carMapper.addCar(userId,id);
	}

	@Override
	public List<Car> findAll(Integer id) {
		return carMapper.findAll(id);
	}

	@Override
	public void minusConut(Integer id) {
            carMapper.minusCount(id);		
	}

	@Override
	public void addCount(Integer userId, Integer id) {
             carMapper.addCount(userId,id);		
	}

	@Override
	public Car findOneCar(Integer id) {
		return carMapper.findOneCar(id);
	}

	@Override
	public void delAll(Integer id) {
           carMapper.delAll(id);		
	}

	@Override
	public void delCar(Integer carid) {
           carMapper.delCar(carid);		
	}

	@Override
	public Car checkCar(Integer userId, Integer id) {
		return carMapper.checkCar(userId,id);
	}

	@Override
	public void addCarCount(Integer carid) {
            carMapper.addCarCount(carid);		
	}

}
