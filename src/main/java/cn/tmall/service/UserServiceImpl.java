package cn.tmall.service;

import cn.tmall.mapper.UserMapper;
import cn.tmall.pojo.User;
import cn.tmall.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserService 实现类
 *

 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public List<User> list() {
		UserExample example = new UserExample();
		return userMapper.selectByExample(example);
	}

	@Override
	public void updatePassword(int id, String password) {
		User user = get(id);
		user.setPassword(password);
		userMapper.updateByPrimaryKey(user);
	}

	@Override
	public User get(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public User get(String name, String password) {
		UserExample example = new UserExample();
		example.or().andNameEqualTo(name).andPasswordEqualTo(password);
		List<User> result = userMapper.selectByExample(example);
		if (result.isEmpty())
			return null;
		return result.get(0);
	}

	@Override
	public boolean isExist(String name) {
		UserExample example =new UserExample();
		example.or().andNameEqualTo(name);
		List<User> result= userMapper.selectByExample(example);
		if(!result.isEmpty())
			return true;
		return false;
	}

	@Override
	public void add(User user) {
		userMapper.insert(user);
	}
}
