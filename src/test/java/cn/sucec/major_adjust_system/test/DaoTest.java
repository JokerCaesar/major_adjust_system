package cn.sucec.major_adjust_system.test;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.sucec.major_adjust_system.dao.MajorDao;
import cn.sucec.major_adjust_system.model.Major;

public class DaoTest {
	
	@Test
	public void name() throws Exception {
		// 1.��ȡ�������ݿ����ӵĻỰ�Ĺ����࣬���������ļ�����
		InputStream inputStream = Resources.getResourceAsStream("mybatis-Config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 2.ͨ�������࣬��ȡ�����ݿ����ӵĻỰ
		SqlSession session = sqlSessionFactory.openSession();
		
		// 3.ͨ��session�������ݿ�
		MajorDao majorDao = session.getMapper(MajorDao.class);
		Map<String, Double> map = majorDao.getAllThisAdjustment();
		  for (Object o : map.keySet()) {
			   System.out.println("key=" + o + " value=" + map.get(o));
			  }
	}
	
}
