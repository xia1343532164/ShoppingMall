package ShoppingMall.Dao.mapper;

import org.apache.ibatis.annotations.Param;

public interface OrderMapper {

	 void createOrder(@Param(value="userId")Integer userId, 
			    @Param(value="addressId")Integer addressId,
		    	@Param(value="proId")Integer proIds);

	void delCar(@Param(value="proId")Integer proIds);
}
