package ShoppingMall.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShoppingMall.Dao.CarDao;
import ShoppingMall.entity.Car;
import ShoppingMall.entity.VipAddress;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarDao carDao;
	
	@Override
	public void addCar(Integer userId, int id) {
           carDao.addCar(userId,id);	
	}

	@Override
	public List<Car> findAll(Integer id) {
		return carDao.findAll(id);
	}

	@Override
	public void delCar(int id) {
        carDao.delCar(id);		
	}

}
