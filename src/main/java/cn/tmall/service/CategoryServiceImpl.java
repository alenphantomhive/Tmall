package cn.tmall.service;

import cn.tmall.mapper.CategoryMapper;
import cn.tmall.pojo.Category;
import cn.tmall.pojo.CategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CategoryService 的实现类
 *


 */
@Service
public class CategoryServiceImpl implements cn.tmall.service.CategoryService {

	@Autowired
	CategoryMapper categoryMapper;

	public List<Category> list() {
		CategoryExample example = new CategoryExample();
		List<Category> categories = categoryMapper.selectByExample(example);
		return categories;
	}

	public Category get(Integer id) {
		return categoryMapper.selectByPrimaryKey(id);
	}

	public void update(Category category) {
		categoryMapper.updateByPrimaryKey(category);
	}


}
