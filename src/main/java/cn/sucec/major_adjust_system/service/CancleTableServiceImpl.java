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
		// 对详细预警专业表和majorTable进行数据分析，选出要进行撤销操作的专业
		// 文档第十九条有两个规则，一个是五年内累计三次列入预警名单的，第二条是连续五年未招生的专业

		// 1.五年内累计三次列入预警名单的 思路：通过detailwarningTableService里的方法查出在详细预警
		// 里次数达到三次的专业的专业代码
		List<DetailwarningTable> cancleMajors1 = detailwarningTableService.getcauseMajorCode();
		if (cancleMajors1 != null) {
			// System.out.println(cancleMajorCode);
			for (DetailwarningTable cancleMajor : cancleMajors1) {
				if (cancleMajor.getWarningYear() > year-5 ) {
					String cancleMajorName = majorTableService.getMajorName(cancleMajor.getMajorCode());
					String cancleReason1 = " 十九(一) 五年内累计三次列入预警名单";
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

		// 2.连续五年未招生的专业 思路：直接查
		List<MajorTable> cancleMajors = majorTableService.getWuNianWeiZhaoSheng();
		// System.out.println(cancleMajors);
		if (cancleMajors != null) {
			String cancleReason2 = " 十九(二) 连续五年未招生的专业";
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
