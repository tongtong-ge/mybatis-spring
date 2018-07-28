package tk.mybatis.web.mapper;

import java.util.List;

import tk.mybatis.web.model.User;

public interface UserMapper {
	/**
	 * 查询所有
	 * @return
	 */
	List<User> getAll();
	
	/**
	 * 插入数据
	 * @param user
	 */
	void insertUser(User user);
}
