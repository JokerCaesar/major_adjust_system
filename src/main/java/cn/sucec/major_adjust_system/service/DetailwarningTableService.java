package cn.sucec.major_adjust_system.service;

import java.util.List;

import cn.sucec.major_adjust_system.model.DetailwarningTable;

public interface DetailwarningTableService extends BaseService<DetailwarningTable> {

	/**
	 * ������ݲ�ѯԤ��רҵ
	 * @param year
	 * @return
	 */
	public List<DetailwarningTable> getWarningMajorByYear(int year);

	public List<DetailwarningTable> getWarningMajorByMajorCode(String majoeCode);
	
	/**
	 * ���������ۼ���������Ԥ��������רҵѡ����
	 * @return
	 */
	public List<DetailwarningTable> getcauseMajorCode();
	
	/**
	 * ͨ����ݺ�רҵ����ɾ��ĳһ��Ԥ��רҵ
	 * @param year
	 * @param majorCode
	 */
	public void deleteByYearAndMajorCode(int year, String majorCode);
	
	public List<DetailwarningTable> getAll();


}
