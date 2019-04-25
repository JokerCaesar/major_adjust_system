package cn.sucec.major_adjust_system.model;

/**
  *   ��¼���ļ��еı���ΪԤ����ԭ��
 * @author WangChuo
 *
 */
public class ReasonTable {
	
	private Integer id; //���
	private String content; //����
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "ReasonTable [id=" + id + ", content=" + content + "]";
	}
	
	public ReasonTable() {
		super();
	}
	
	public ReasonTable(Integer id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	
}
