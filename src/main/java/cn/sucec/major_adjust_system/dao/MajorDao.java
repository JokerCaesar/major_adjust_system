package cn.sucec.major_adjust_system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import cn.sucec.major_adjust_system.model.Major;

/**
 * ��Ϊ�����Ŀ����ҪдBasedao,������һЩ�����ϾͲ���дͨ�õ��ˣ�����ֱ����mapper.xml��sql�����ȷ������
 * @author WangChuo
 *
 */
public interface MajorDao {
	
	/**
	 * ����רҵ�����ѯרҵ����
	 * �Ѳ��ԣ�����ʹ��
	 */
	public String getMajorName(@Param("majorCode") String majorCode);
	
	/**
	 * ����רҵ����(major_code)���������(enrollment_year)
	 * �Ѳ��ԣ�����ʹ��
	 * @param majorCode
	 * @return
	 */
	public int getEyByMajorCode(@Param("majorCode") String majorCode);
	
	/**
	 * ��ȡ���в�������רҵ�ģ��������������켰���ϱ�ҵ����רҵ�ģ����������
	 * ��ȡ���в�������רҵ�ģ��������������켰���ϱ�ҵ����רҵ�ģ�����this_transfer
	 * �� nowYear-5>(���ݿ���е��������enrollment_year)
	 * �����������֮�󣬻�Ҫͨ��������õ�Map(String,Double) majorCode-thisAdjustment�����ĸ�ʽ
	 * ��ȡ���в�������רҵ�ģ��������������켰���ϱ�ҵ����רҵ�ģ�����this_transfer
	 * ��������õļ��϶���һ����List���ϣ�������һ��������ֻ��ת���ķ�����ͬ���� 
	 * @param:nowYear :��ǰ�����
	 * @return
	 * �Ѳ��ԣ�����ʹ��
	 */
	public List<Major> getAllThisAdjustmentAndThisTransfer(@Param("nowYear") Integer nowYear);
	
	
	/**
	 * �������С�תרҵ��רҵ������ѧ������-����ġ���������20�˵�רҵ����������������
	 * �������������켰���ϱ�ҵ����רҵ�ģ����������<20�˵�major����
	 * �� nowYear-5>(���ݿ���е��������enrollment_year)
	 */
	public List<Major> getMajorLess20NoArt(@Param("nowYear") Integer nowYear);
	
	/**
	 * �������С�תרҵ��רҵ������ѧ������-����ġ���������15�˵�����רҵ����
	 */
	public List<Major> getMajorLess15Art(@Param("nowYear") Integer nowYear);
	
	/**
	 * ��ȡ����"�����ҵ���ĳ��ξ�ҵ��"���ų�����רҵû�о�ҵ�ʣ�����������
	 * ����:	key-string:majorCode רҵ����
	 * 		value-Double:firstEmploymentRate ��Ӧרҵ�ĵ����ҵ���ĳ��ξ�ҵ��
	 * @return
	 */
	public Map<String, Double> getAllSecondEmployment();
	
	/**
	 * ��ȡ���е���Ӧ���ҵ���Ŀ�����
	 * ����:	key-string:majorCode רҵ����
	 * 		value-Double:currentPosrgraduteRate ��Ӧרҵ��Ӧ���ҵ��������
	 */
	public Map<String, Double> getAllCurrentPosrgraduteRate();
	
	
	
}
