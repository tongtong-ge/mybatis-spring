package tk.mybatis.web.service;

import java.util.List;

import tk.mybatis.web.model.SysDict;
import tk.mybatis.web.model.User;

public interface UserService {
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
