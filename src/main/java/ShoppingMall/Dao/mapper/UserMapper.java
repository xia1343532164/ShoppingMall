package ShoppingMall.Dao.mapper;

import org.apache.ibatis.annotations.Param;

import ShoppingMall.entity.User;

public interface UserMapper {

	User findOneByUsername(String username);

	void create(User user);

	void saveinfo(User user);

	//多个参数必须要加@Param
	void alterPassword(@Param(value = "id") Integer id, @Param(value = "encode") String encode);

}
