package cn.sucec.major_adjust_system.service;

import cn.sucec.major_adjust_system.model.CancleTable;

public interface CancleTableService extends BaseService<CancleTable> {
	
	// ��Ԥ��רҵ���majorTaxble����з���������Ҫ����רҵ������רҵ
	public void fenXiCheXiaoZhuanYe(int year);
	
	public void clearDate();
	
	public void deleteByYearAndMajorCode(int year, String majorCode);
}
