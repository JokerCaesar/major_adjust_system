package cn.sucec.major_adjust_system.controller;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.sucec.major_adjust_system.model.DetailwarningTable;
import cn.sucec.major_adjust_system.model.PauseTable;
import cn.sucec.major_adjust_system.service.DetailwarningTableService;
import cn.sucec.major_adjust_system.service.MajorTableService;
import cn.sucec.major_adjust_system.service.PauseTableService;

@Controller
public class MajorController {
	
	@Autowired
	private MajorTableService majorTableService;
	
	@Autowired
	private DetailwarningTableService detailwarningTableService;
	
	@Autowired
	private PauseTableService pauseTableService;

	// �ϴ��ļ����Զ��󶨵�MultipartFile��
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws Exception {

		// �ϴ��ļ���
		String filename = file.getOriginalFilename();

		InputStream inputExcel = file.getInputStream();

		majorTableService.importExcelInfo(inputExcel);

		inputExcel.close();

		System.out.println(filename);

		return "success";

	}

	@RequestMapping("/download")
	public String downloadExcel(HttpServletResponse response) throws IOException, InvocationTargetException,
			ClassNotFoundException, IllegalAccessException, IntrospectionException, ParseException {

		response.reset();
		response.setContentType("application/x-execl");
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String("Ԥ������.xlsx".getBytes(), "ISO-8859-1"));
		ServletOutputStream outputStream = response.getOutputStream();

		majorTableService.exportExcelInfo(outputStream);

		if (outputStream != null) {
			outputStream.close();
		}
		return "success";

	}
	
	@RequestMapping("/zhuanyefenxi")
	public String zhuanyefenxi() {
		int year = 2019;
		System.out.println("������רҵ����");
		// �Դ������ı�������ݷ���������Ԥ��רҵ������ϸԤ��רҵ���ݱ���
		majorTableService.zhuanYeFenXi(year);
		// ��Ԥ��רҵ���ݱ���з���������Ҫ��ͣ������רҵ
		pauseTableService.fenXiZanTingZhuanYe(year);
		return "success";
	}
	
	@RequestMapping("/chakanjinnianyujing")
	public String chakanjinnianyujing() {
		int year = 2019;
		System.out.println("�����ǲ鿴����Ԥ��רҵ");
		List<DetailwarningTable> detailwarningMajors = detailwarningTableService.getWarningMajorByYear(year);
		for (DetailwarningTable detailwarningMajor : detailwarningMajors) {
			System.out.println(detailwarningMajor);
		}
		return "success";
	}
	
	@RequestMapping("/chakanwangnianyujing")
	public String chakanwangnianyujing() {
		System.out.println("�����ǲ鿴����Ԥ��רҵ");
		List<DetailwarningTable> detailwarningMajors = detailwarningTableService.selectAll();
		for (DetailwarningTable detailwarningMajor : detailwarningMajors) {
			System.out.println(detailwarningMajor);
		}
		return "success";
	}
	
	@RequestMapping("/chaKanZanTingZhuanYe")
	public String chaKanZanTingZhuanYe() {
		System.out.println("�����ǲ鿴��ͣ����Ԥ��רҵ");
		List<PauseTable> pauseMajors = pauseTableService.selectAll();
		for (PauseTable pauseMajor : pauseMajors) {
			System.out.println(pauseMajor);
		}
		return "success";
	}
	
	@RequestMapping("/qingkongshuju")
	public String qingkongshuju() {
		System.out.println("�����������������");
		// ͨ��service����ÿһ�����ɾ��������������ϸԤ��רҵ�������ݱ�����Ķ������
		
		return "success";
	}
}
