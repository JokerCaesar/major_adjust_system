package cn.sucec.major_adjust_system.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sucec.major_adjust_system.dao.BaseDao;
import cn.sucec.major_adjust_system.dao.MajorTableDao;
import cn.sucec.major_adjust_system.dao.WarningTableDao;
import cn.sucec.major_adjust_system.model.MajorTable;
import cn.sucec.major_adjust_system.model.PwarningTable;
import cn.sucec.major_adjust_system.model.WarningTable;
import cn.sucec.major_adjust_system.tools.Change;
import cn.sucec.major_adjust_system.tools.ExcelutilMine;

@Service("majorTableService")
public class MajorTableServiceImpl extends BaseServiceImpl<MajorTable> implements MajorTableService {

	@Autowired
	private MajorTableDao majorTableDao;

	@Autowired
	private PwarningTableService pwarningTableService;

	@Autowired
	private WarningTableService warningTableService;

	@Override
	public BaseDao getBaseDao() {
		return majorTableDao;
	}

	@Autowired
	private WarningTableDao warningTableDao;

	/**
	 * ����Excel
	 */
	@Override
	public void importExcelInfo(InputStream in) {
		List<MajorTable> majorTables;
		// ����
		try {
			majorTables = ExcelutilMine.importExcel(in);
			for (MajorTable major : majorTables) {
				super.add(major);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * ���ݵ���
	 */
	@Override
	public void exportExcelInfo(ServletOutputStream outputStream) {
		// ����������ѯ���ݣ�������װ�ص�һ��list��
		List<WarningTable> list = warningTableDao.getAll();

		// ����ExcelUtil�ķ���
		try {
			ExcelutilMine.createExcelFile("רҵԤ��", list, outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getMajorName(String majorCode) {
		return majorTableDao.getMajorName(majorCode);
	}

	@Override
	public int getEyByMajorCode(String majorCode) {
		return majorTableDao.getEyByMajorCode(majorCode);
	}

	@Override
	public List<MajorTable> selectAll(Integer nowYear) {
		return majorTableDao.selectAll(nowYear);
	}

	@Override
	public List<MajorTable> getMajorLess20(Integer nowYear) {
		return majorTableDao.getMajorLess20(nowYear);
	}

	/**
	 * ����רҵ������ѡ��ԤԤ��רҵ
	 */
	@Override
	public void zhuanYeFenXi(int year) {
		// ��ȡ������Ϊ������רҵ�б�
		List<MajorTable> majors = selectAll(year);
		System.out.println("hahahahah" + majors);
		// ȷ��Ҫȡ��������רҵ
		int number = majors.size();
		int count = (int) Math.round(number * 0.05);
		
		// �����ĵ���ʮ����������������η���ԤԤ�����ݱ��У�����û��ԭ��ϲ���ɾ���ظ���
		Change.ThisAdjustment(majors, count, year);
		Change.ThisTransfer(majors, count, year);
		Change.SecondEmploymentRate(majors, count, year);
		Change.CurrentPosrgraduteRate(majors, count, year);
		Change.MajorNumberLess20(majors, year);

		List<PwarningTable> warninglist = pwarningTableService.getWarningMajor();
		// ��ԤԤ��רҵ�����е�רҵ��ӵ����׵�Ԥ��רҵ������
		Change.YuYuJingToYuYjing(warninglist);
		
		// �����ĵ���ʮ�������������򣬼�����׵�Ԥ��רҵ������
		// ���ʱ���ڼ��׵�Ԥ��רҵ�����У���ͨ��ԤԤ��רҵ������Ҳ��ֱ��ͨ���ĵ���ʮ����5��������������
		// �����漰���ظ�������Ҫ�����ŵ�֮��������ӵ���ϸ��Ԥ��רҵ������
		Change.ZuiZhongYuJingZhuanYe(majors, year, count);
		// �Ѽ���Ԥ��רҵ�е��ظ���Ԥ��רҵ����������
		List<WarningTable> chongfuWarningMajor = warningTableService.getChongFu();
		// �������ظ��ļ���Ԥ��רҵ�����ŵ���ϸ��Ԥ��רҵ������
		Change.YuJingToXiangXiYuJing(chongfuWarningMajor,year);
	}
	

	@Override
	public List<MajorTable> getMajorLess20JinNian(int year) {
		return majorTableDao.getMajorLess20JinNian(year);
	}
	

	@Override
	public List<MajorTable> getMajorLess20QuNian(int year) {
		return majorTableDao.getMajorLess20QuNian(year);
	}

	@Override
	public List<MajorTable> getWuNianWeiZhaoSheng() {
		return majorTableDao.getWuNianWeiZhaoSheng();
	}
}
