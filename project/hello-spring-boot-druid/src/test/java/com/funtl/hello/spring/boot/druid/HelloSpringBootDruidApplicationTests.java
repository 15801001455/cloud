package com.funtl.hello.spring.boot.druid;

import com.funtl.hello.spring.boot.druid.dao.CityMapper;
import com.funtl.hello.spring.boot.druid.entity.City;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloSpringBootDruidApplication.class)
@Transactional
@Rollback
class HelloSpringBootDruidApplicationTests {

	/**
	 * 注入数据查询接口
	 */
	@Autowired
	private CityMapper cityMapper;

	/**
	 * 测试查询集合
	 */
	@Test
	public void testSelect() {
		List<City> cities = cityMapper.selectAll();
		for (City city : cities) {
			System.out.println(city.getName());
		}
	}

	/**
	 * 测试分页查询
	 */
	@Test
	public void testPage() {
		// PageHelper 使用非常简单，只需要设置页码和每页显示笔数即可
		PageHelper.startPage(0, 2);

		// 设置分页查询条件
		Example example = new Example(City.class);
		PageInfo<City> pageInfo = new PageInfo<>(cityMapper.selectByExample(example));

		// 获取查询结果
		List<City> tbUsers = pageInfo.getList();
		for (City tbUser : tbUsers) {
			System.out.println(tbUser.getName());
		}
	}

}
