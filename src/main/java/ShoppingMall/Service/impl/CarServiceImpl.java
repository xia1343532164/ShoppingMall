package ShoppingMall.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ShoppingMall.Dao.CarDao;
import ShoppingMall.Service.CarService;
import ShoppingMall.entity.Car;

@Service
@Transactional
public class CarServiceImpl implements CarService {

	@Autowired
	private CarDao carDao;
	
	@Override
	public void addCar(Integer userId, Integer id) {
           carDao.addCar(userId,id);	
	}

	@Override
	public List<Car> findAll(Integer id) {
		return carDao.findAll(id);
	}

	@Override
	public void minusCount(Integer id) {
         carDao.minusConut(id);		
	}

	@Override
	public void addCount(Integer userId, Integer id) {
            carDao.addCount( userId,  id);		
	}

	@Override
	public Car findOneCar(Integer id) {
		return carDao.findOneCar(id);
	}

	@Override
	public void delAll(Integer id) {
          carDao.delAll(id);		
	}

	@Override
	public void delCar(Integer carid) {
        carDao.delCar(carid);		
	}

	@Override
	public Car checkCar(Integer userId, Integer id) {
		return carDao.checkCar(userId,id);
	}

	@Override
	public void addCarCount(Integer carid) {
            carDao.addCarCount(carid);		
	}


}
