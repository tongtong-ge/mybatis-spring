package tk.mybatis.web.service;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseServiceTest {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	public void setSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	/**
	 * 通过SqlSessionFactory工厂对象获取一个SqlSession
	 * <br>使用后必须将SqlSession关闭，否则会造成因为连接没有关闭导致数据库连接数过多
	 * <br>造成系统崩溃
	 * @return SqlSession
	 */
	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
}
