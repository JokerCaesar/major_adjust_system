package cn.sucec.major_adjust_system.controller;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.sucec.major_adjust_system.model.PwarningTable;
import cn.sucec.major_adjust_system.service.MajorTableService;
import cn.sucec.major_adjust_system.service.PwarningTableService;

@Controller
public class MajorController {
	
	@Autowired
	private MajorTableService majorTableService;
	
	private PwarningTableService pwarningTableService;

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
	
	@RequestMapping("/yujing")
	public String yujing() {
		int year = 2019;
		int count = 3;
		System.out.println("������רҵ����");
		//majorTableService.zhuanYeFenXi(year);
		PwarningTable pwarningTable = new PwarningTable(2019, "050303", "���ѧ", "����רҵ������λ����������רҵ��ǰ5%");
		System.out.println(pwarningTableService);
		pwarningTableService.add(pwarningTable);
		//pwarningTableService.addOne(pwarningTable2);
		return "success";
	}
}
