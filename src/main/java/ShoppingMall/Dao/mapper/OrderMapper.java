package ShoppingMall.Dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ShoppingMall.entity.Car;
import ShoppingMall.entity.Order;

public interface OrderMapper {

	 void createOrder(@Param(value="userId")Integer userId, 
			    @Param(value="addressId")Integer addressId,
		    	@Param(value="proId")Integer proIds, 
		    	@Param(value="ordernumber")Long ordernumber,
		    	@Param(value="goodscount")int goodscount);

	void delCar(@Param(value="proId")Integer proIds);

	List<Order> findOrder(Integer userid);

	Order findOrderdetails(int orderid);

	Car findCar(Integer proIds);
}
