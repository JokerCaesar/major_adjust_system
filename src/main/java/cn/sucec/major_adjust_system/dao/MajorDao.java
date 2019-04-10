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
	 * ��ȡ����רҵ�ĵ��������(this_adjustment)������������
	 * ����:	key-string:majorCode רҵ����
	 * 		value-Double:thisAdjustment ��Ӧרҵ�ĵ��������
	 * @return
	 */
	@MapKey("majorCode")
	public Map<String, Double> getAllThisAdjustment();
	
	/**
	 * ��ȡ����רҵ������ת������/��רҵ���꼶�ڼ��ڲ���У�������ı���(this_transfer),����������
	 * ����:	key-string:majorCode רҵ����
	 * 		value-Double:thisTransfer ��Ӧרҵ�ĵ�������ת������/��רҵ���꼶�ڼ��ڲ���У�������ı���
	 * @return
	 */
	public Map<String, Double> getAllThistransfer();
	
	/**
	 * �������С�תרҵ��רҵ������ѧ������-����ġ���������20�˵�רҵ����������������
	 */
	public List<Major> getMajorLess20NoArt();
	
	/**
	 * �������С�תרҵ��רҵ������ѧ������-����ġ���������15�˵�����רҵ����
	 */
	public List<Major> getMajorLess15Art();
	
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
