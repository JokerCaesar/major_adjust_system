/*package cn.sucec.major_adjust_system.controller;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.sucec.major_adjust_system.model.Major;
import cn.sucec.major_adjust_system.model.WaringTable;
import cn.sucec.major_adjust_system.service.MajorService;
import net.sf.jsqlparser.parser.ParseException;

@Controller
public class Test2 {

	@Autowired
	MajorService majorService;
	
	 �ϴ��ļ���upload
	 �鿴����Ԥ��רҵ��thisYear
	 �鿴����Ԥ��רҵ��lastYear
	 ��ͣ����רҵ��stopMajor
	 ����רҵ��cancleMajor
	 �����ļ���download
	 ������ݣ�deleteAll
	����רҵ�����ѯԤ��ԭ��queryReasons
	 �˳���¼��logout
	
	 URLǰ׺��/major_adjust_system/
	
	

	// �ϴ��ļ�
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public void  upload(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws Exception {

		InputStream inputExcel = file.getInputStream();

		majorService.importExcelInfo(inputExcel);

		inputExcel.close();

	}

	//�����ļ���download
	@RequestMapping("/download")
	public void downloadExcel(HttpServletResponse response) throws IOException, InvocationTargetException,
			ClassNotFoundException, IllegalAccessException, IntrospectionException, ParseException {

		response.reset();
		response.setContentType("application/x-execl");
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String("Ԥ������.xlsx".getBytes(), "ISO-8859-1"));
		ServletOutputStream outputStream = response.getOutputStream();

		majorService.exportExcelInfo(outputStream);

		if (outputStream != null) {
			outputStream.close();
		}

	}
	
	// �鿴����Ԥ��רҵ��thisYear
	@RequestMapping("/thisYear")
	@ResponseBody
	public String queryThisYearWaringMajor() {
		
		Calendar cale = null;  
        cale = Calendar.getInstance();  
        int year = cale.get(Calendar.YEAR);

//������ݲ�ѯԤ��רҵ
		List<majorTable> warningTable=majorService.querythisYear(year);
       
       //Ԥ��רҵ���ݿ�����Ҫ����Ķ���
       List<WaringTable> waringTables=new ArrayList<WaringTable>();

       //ΪԤ��רҵ���Ը�ֵ
       for (Major majorTable : warningTable) {
    	   
    	   WaringTable waringTable=new WaringTable();
    	   waringTable.setMajor_code(majorTable.getMajorCode());
    	   waringTable.setMajor_name(majorTable.getMajorName());
    	   waringTable.setWaring_year(year);
    	   //Ϊԭ�����Ը�ֵ
    	   waringTable.setWaring_reason(waring_reason);
    	   //��Ԥ��רҵ����list��
    	   waringTables.add(waringTable);
    	   
	}
      //������Ԥ��רҵ�ŵ����ݿ���
      //majorService.saveStopMajor(List<WaringTable> waringTables);
      		
		return null;  
	}
	
	
	//�鿴����Ԥ��רҵ��lastYear
	@RequestMapping("/lastYear")
	@ResponseBody
	public String queryLastYearWaringMajor() {
		
		//��ѯ����Ԥ��רҵ����������List<WarningTable>��WarningTable����ֻ���ĸ����ԣ���ݣ����룬���� ��ԭ��
		//List<WarningTable> lasTables=majorService.getLastWaringMajor();
		
		
		return null;
		
	}
	

//	 ��ͣ����רҵ��stopMajor
	@RequestMapping("/stopMajor")
	@ResponseBody
	public String queryStopMajor() {
		
		//��ѯ��ͣ����רҵ������List<StopMajor>�� StopMajor����ֻ���ĸ����ԣ���ݣ����룬���� ��ԭ��
		//List<stopMajor> lastTables=majorService.getStopMajor();
		
		
		//Ԥ��רҵ���ݿ�����Ҫ����Ķ���
	       List<WaringTable> waringTables=new ArrayList<WaringTable>();

	       //ΪԤ��רҵ���Ը�ֵ
	       for (Major majorTable : warningTable) {
	    	   
	    	   WaringTable waringTable=new WaringTable();
	    	   
	    	   stopMajor.setMajor_code(majorTable.getMajorCode());
	    	   stopMajor.setMajor_name(majorTable.getMajorName());
	    	   stopMajor.setWaring_year(year);
	    	   //Ϊԭ�����Ը�ֵ
	    	   stopMajor.setWaring_reason(waring_reason);
	    	   //��Ԥ��רҵ����list��
	    	   waringTables.add(waringTable);
	    	   
		}		//����ͣ����רҵ�ŵ����ݿ���
		//majorService.saveStopMajor(lastTables);
		
		return null;
		
	}
	
//	 ����רҵ��cancleMajor
	@RequestMapping("/cancleMajor")
	@ResponseBody
	public String queryCancleMajor() {
		
		//��ѯ��ͣ����רҵ������List<StopMajor>�� StopMajor����ֻ���ĸ����ԣ���ݣ����룬���� ��ԭ��
		//List<cancleMajor> cancleMajors =majorService.CancleMajor();
		
		//������רҵ�ŵ����ݿ���
		//majorService.saveCancleMajor(cancleMajors)
		return null;
	}
		
	
//	 ������ݣ�deleteAll
	@RequestMapping("/deleteAll")
	@ResponseBody
	public void  deleteAll() {
		
		//���WaringTable
		//majorService.deleteAll();
	}
	
//��¼
	@RequestMapping("/login")
	@ResponseBody
	public void  login(String user,String password) {}
		
//	 �˳���¼��logout
	@RequestMapping("/login")
	@ResponseBody
	public void  logout(String user,String password) {}
		
	
}
*/