package cn.sucec.major_adjust_system.tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.sucec.major_adjust_system.model.Major;

/**
 * �˹������ǽ�һЩList����ת�����Ҫ��Map����
 * @author WangChuo
 *
 */
public  class Change {
	
	
	/**
	 * �˷����ǻ�ȡmajorCode-thisAdjustment
	 * ���͵�map����
	 * �Ѳ��ԣ�����ʹ��
	 * @param majors
	 * @return
	 */
	public Map<String, Double> ThisAdjustment(List<Major> majors) {
		Map<String,Double> hashMap = new HashMap<>();
		for (Major major : majors) {
			hashMap.put(major.getMajorCode(), major.getThisAdjustment());
		}
		return hashMap;
	}
	
	/**
	 * �˷����ǻ�ȡmajorCode-thisTransfer
	 * ���͵�map����
	 * �Ѳ��ԣ�����ʹ��
	 * @param majors
	 * @return
	 */
	public Map<String, Double> ThisTransfer(List<Major> majors) {
		Map<String,Double> hashMap = new HashMap<>();
		for (Major major : majors) {
			hashMap.put(major.getMajorCode(), major.getThisTransfer());
		}
		return hashMap;
	}
	
	
	
	
}
