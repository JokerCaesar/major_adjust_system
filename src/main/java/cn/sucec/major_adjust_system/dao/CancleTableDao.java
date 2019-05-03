package cn.sucec.major_adjust_system.dao;

import org.apache.ibatis.annotations.Param;

public interface CancleTableDao extends BaseDao {
	
	public void clearDate();
	
	/**
	 * ������ݺ�רҵ����ɾ��ĳһ������
	 * @param year
	 * @param majorCode
	 */
	public void deleteByYearAndMajorCode(@Param("year") int year, @Param("majorCode") String majorCode);
	
}
