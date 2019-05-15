package cn.sucec.major_adjust_system.service;

import java.util.List;

import cn.sucec.major_adjust_system.model.DetailwarningTable;

public interface DetailwarningTableService extends BaseService<DetailwarningTable> {

	/**
	 * 根据年份查询预警专业
	 * @param year
	 * @return
	 */
	public List<DetailwarningTable> getWarningMajorByYear(int year);

	public List<DetailwarningTable> getWarningMajorByMajorCode(String majoeCode);
	
	/**
	 * 把五年内累计三次列入预警名单的专业选出来
	 * @return
	 */
	public List<DetailwarningTable> getcauseMajorCode();
	
	/**
	 * 通过年份和专业代码删除某一条预警专业
	 * @param year
	 * @param majorCode
	 */
	public void deleteByYearAndMajorCode(int year, String majorCode);
	
	public List<DetailwarningTable> getAll();


}
