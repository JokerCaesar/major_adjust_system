package cn.sucec.major_adjust_system.test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.sucec.major_adjust_system.dao.MajorTableDao;
import cn.sucec.major_adjust_system.model.MajorTable;
import cn.sucec.major_adjust_system.tools.Change;

public class DaoTest {
	
	Change change = new Change();

//	for(String key:map.keySet()) {
//        System.out.println("Key: "+key+" Value: "+map.get(key));
//    }
	
	@Test
	public void test() throws Exception {
		// 1.获取创建数据库链接的会话的工厂类，根据配置文件创建
		InputStream inputStream = Resources.getResourceAsStream("mybatis-Config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 2.通过工厂类，获取到数据库链接的会话
		SqlSession session = sqlSessionFactory.openSession();
		
		// 3.通过session操作数据库
		MajorTableDao majorTableDao = session.getMapper(MajorTableDao.class);
		List<MajorTable> majorTables = majorTableDao.selectAll(2019);
		int year = 2019;
		int count = 3;
		Change.ZuiZhongYuJingZhuanYe(majorTables, year, count);
	}
	
	@Test
	public void name() {
		int i = 67;
		int count = (int) Math.round(i*0.05);
		System.out.println(count);
	}
	
}
