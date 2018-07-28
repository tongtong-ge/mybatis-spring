package tk.mybatis.web.service;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import tk.mybatis.web.model.SysDict;

public class DictServiceTest extends BaseServiceTest {
	
	@Test
	public void testFindById() {
		SqlSession sqlSession = getSqlSession();
		try {
			DictService dictService = sqlSession.getMapper(DictService.class);
			SysDict sysDict = new SysDict();
			sysDict = dictService.findById(9L);
			
			Assert.assertNotNull(sysDict);
		} finally {
			sqlSession.close();
		}
	}
}
