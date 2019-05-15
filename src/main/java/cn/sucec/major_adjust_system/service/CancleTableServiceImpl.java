package cn.sucec.major_adjust_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sucec.major_adjust_system.dao.BaseDao;
import cn.sucec.major_adjust_system.dao.CancleTableDao;
import cn.sucec.major_adjust_system.model.CancleTable;
import cn.sucec.major_adjust_system.model.DetailwarningTable;
import cn.sucec.major_adjust_system.model.MajorTable;

@Service("cancleTableService")
public class CancleTableServiceImpl extends BaseServiceImpl<CancleTable> implements CancleTableService {

	@Autowired
	private CancleTableDao cancleTableDao;

	@Autowired
	private DetailwarningTableService detailwarningTableService;

	@Autowired
	private MajorTableService majorTableService;

	@Override
	public BaseDao getBaseDao() {
		return cancleTableDao;
	}

	@Override
	public void fenXiCheXiaoZhuanYe(int year) {
		// ����ϸԤ��רҵ���majorTable�������ݷ�����ѡ��Ҫ���г���������רҵ
		// �ĵ���ʮ��������������һ�����������ۼ���������Ԥ�������ģ��ڶ�������������δ������רҵ

		// 1.�������ۼ���������Ԥ�������� ˼·��ͨ��detailwarningTableService��ķ����������ϸԤ��
		// ������ﵽ���ε�רҵ��רҵ����
		List<DetailwarningTable> cancleMajors1 = detailwarningTableService.getcauseMajorCode();
		if (cancleMajors1 != null) {
			// System.out.println(cancleMajorCode);
			for (DetailwarningTable cancleMajor : cancleMajors1) {
				if (cancleMajor.getWarningYear() > year-5 ) {
					String cancleMajorName = majorTableService.getMajorName(cancleMajor.getMajorCode());
					String cancleReason1 = " ʮ��(һ) �������ۼ���������Ԥ������";
					CancleTable cancleMajor2 = new CancleTable(year, cancleMajor.getMajorCode(), cancleMajorName, cancleReason1);
					add(cancleMajor2);
				}
				else {
					return;
				}
			}
		} else {
			return;
		}

		// 2.��������δ������רҵ ˼·��ֱ�Ӳ�
		List<MajorTable> cancleMajors = majorTableService.getWuNianWeiZhaoSheng();
		// System.out.println(cancleMajors);
		if (cancleMajors != null) {
			String cancleReason2 = " ʮ��(��) ��������δ������רҵ";
			for (MajorTable cancleMajor1 : cancleMajors) {
				CancleTable cancleTable2 = new CancleTable(year, cancleMajor1.getMajorCode(),
						cancleMajor1.getMajorName(), cancleReason2);
				add(cancleTable2);
			}
		}else {
			return;
		}

	}

	@Override
	public void clearDate() {
		cancleTableDao.clearDate();
	}

	@Override
	public void deleteByYearAndMajorCode(int year, String majorCode) {
		cancleTableDao.deleteByYearAndMajorCode(year, majorCode);
	}

}
