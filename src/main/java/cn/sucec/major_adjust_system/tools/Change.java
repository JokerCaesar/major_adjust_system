package cn.sucec.major_adjust_system.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cn.sucec.major_adjust_system.dao.PwarningTableDao;
import cn.sucec.major_adjust_system.model.MajorTable;
import cn.sucec.major_adjust_system.model.PwarningTable;
import cn.sucec.major_adjust_system.service.BaseService;
import cn.sucec.major_adjust_system.service.BaseServiceImpl;
import cn.sucec.major_adjust_system.service.PwarningTableService;
import cn.sucec.major_adjust_system.service.PwarningTableServiceImpl;

/**
 * �˹������ǽ�һЩList����ת�����Ҫ��Map����
 * @author WangChuo
 * 
 */
@ContextConfiguration({ "classpath:spring.xml" })
public class Change {
	
	@Autowired
	static PwarningTableService pwarningTableService = new PwarningTableServiceImpl();
	
	/**
	 * �˷����Ǹ���lastAdjustment������������Ҫȡǰ����
	 * ȥ���רҵ������
	 * �Ѳ��ԣ�����ʹ��
	 * @param majorTables
	 * @return
	 */
	public static List<MajorTable> LastAdjustment(List<MajorTable> majorTables,int count,int nowYear) {
		Collections.sort(majorTables, new Comparator<MajorTable>() {
			@Override
			public int compare(MajorTable o1, MajorTable o2) {
				if (o1.getLastAdjustment() < o2.getLastAdjustment()) {
					return 1;
				}
				if (o1.getLastAdjustment() == o2.getLastAdjustment()) {
					return 0;
				}
				return -1;
			}
		});
		List<MajorTable> newList = majorTables.subList(0, count);
		List<PwarningTable> pwarningTables = new ArrayList<PwarningTable>();
		int PwarningYear = nowYear;
		String PmajorCode = null;
		String PmajorName = null;
		String PwarningReason = "";
		
		return newList;
	}
	
	/**
	 * �˷����Ǹ���thisAdjustment������������Ҫȡǰ����
	 * �����רҵ������
	 * �Ѳ��ԣ�����ʹ��
	 * @param majorTables
	 * @return
	 */
	@Autowired
	public static void ThisAdjustment(List<MajorTable> majorTables,int count,int nowYear) {
		Collections.sort(majorTables, new Comparator<MajorTable>() {
			@Override
			public int compare(MajorTable o1, MajorTable o2) {
				if (o1.getThisAdjustment() < o2.getThisAdjustment()) {
					return 1;
				}
				if (o1.getThisAdjustment() == o2.getThisAdjustment()) {
					return 0;
				}
				return -1;
			}
		});
		
		List<MajorTable> newList = majorTables.subList(0, count);
		System.out.println(newList);
		List<PwarningTable> pwarningTables = new ArrayList<>();
		int pwarningYear = nowYear;
		String pmajorCode = null;
		String pmajorName = null;
		String pwarningReason = "����רҵ������λ����������רҵ��ǰ5%";
		for (MajorTable pwarningMajor : newList) {
			pmajorCode = pwarningMajor.getMajorCode();
			pmajorName = pwarningMajor.getMajorName();
			PwarningTable pwarningMajor2 = new PwarningTable(pwarningYear, pmajorCode, pmajorName, pwarningReason);
			System.out.println("======" + pwarningMajor2);
			System.out.println("-=-=-=-" + pwarningTableService);
			pwarningTableService.addOne(pwarningMajor2);
		}
	}
	
	/**
	 * �˷����Ǹ���lastTransfer������������Ҫȡǰ����
	 * ȥ���-����ת������/��רҵ���꼶�ڼ��ڲ���У�������ı���
	 * �Ѳ��ԣ�����ʹ��
	 * @param majorTables
	 * @return
	 */
	public static List<MajorTable> LastTransfer(List<MajorTable> majorTables) {
		Collections.sort(majorTables, new Comparator<MajorTable>() {
			@Override
			public int compare(MajorTable o1, MajorTable o2) {
				if (o1.getLastTransfer() < o2.getLastTransfer()) {
					return 1;
				}
				if (o1.getLastTransfer() == o2.getLastTransfer()) {
					return 0;
				}
				return -1;
			}
		});
		return majorTables;
	}
	
	/**
	 * �˷����Ǹ���thisTransfer������������Ҫȡǰ����
	 * �����-����ת������/��רҵ���꼶�ڼ��ڲ���У�������ı���
	 * �Ѳ��ԣ�����ʹ��
	 * @param majorTables
	 * @return
	 */
	public static List<MajorTable> ThisTransfer(List<MajorTable> majorTables) {
		Collections.sort(majorTables, new Comparator<MajorTable>() {
			@Override
			public int compare(MajorTable o1, MajorTable o2) {
				if (o1.getThisTransfer() < o2.getThisTransfer()) {
					return 1;
				}
				if (o1.getThisTransfer() == o2.getThisTransfer()) {
					return 0;
				}
				return -1;
			}
		});
		return majorTables;
	}
	
	
	
	/**
	 * �˷����Ǹ���firstEmploymentRate������������Ҫȡǰ����
	 * ȥ��ĳ��ξ�ҵ��
	 * @param majorTables
	 * @return
	 */
	public static List<MajorTable> FirstEmploymentRate(List<MajorTable> majorTables) {
//		for (MajorTable majorTable : majorTables) {
//			if (majorTable.getFirstEmploymentRate().equals(null)) {
//				majorTables.remove(majorTable);
//			}
//		}
		Collections.sort(majorTables, new Comparator<MajorTable>() {
			@Override
			public int compare(MajorTable o1, MajorTable o2) {
				if (o1.getFirstEmploymentRate() > o2.getFirstEmploymentRate()) {
					return 1;
				}
				if (o1.getFirstEmploymentRate() == o2.getFirstEmploymentRate()) {
					return 0;
				}
				return -1;
			}
		});
		return majorTables;
	}
	
	/**
	 * �˷����Ǹ���secondEmploymentRate������������Ҫȡǰ����
	 * ����ĳ��ξ�ҵ��
	 * �Ѳ��ԣ�����ʹ��
	 * @param majorTables
	 * @return
	 */
	public static List<MajorTable> SecondEmploymentRate(List<MajorTable> majorTables) {
		Collections.sort(majorTables, new Comparator<MajorTable>() {
			@Override
			public int compare(MajorTable o1, MajorTable o2) {
				if (o1.getSecondEmploymentRate() > o2.getSecondEmploymentRate()) {
					return 1;
				}
				if (o1.getSecondEmploymentRate() == o2.getSecondEmploymentRate()) {
					return 0;
				}
				return -1;
			}
		});
		return majorTables;
	}
	
	/**
	 * �˷����Ǹ���currentPosrgraduteRate������������Ҫȡǰ����
	 * Ӧ���ҵ��������
	 * �Ѳ��ԣ�����ʹ��
	 * @param majorTables
	 * @return
	 */
	public static List<MajorTable> CurrentPosrgraduteRate(List<MajorTable> majorTables) {
		Collections.sort(majorTables, new Comparator<MajorTable>() {
			@Override
			public int compare(MajorTable o1, MajorTable o2) {
				if (o1.getCurrentPosrgraduteRate() > o2.getCurrentPosrgraduteRate()) {
					return 1;
				}
				if (o1.getCurrentPosrgraduteRate() == o2.getCurrentPosrgraduteRate()) {
					return 0;
				}
				return -1;
			}
		});
		return majorTables;
	}
	
}
