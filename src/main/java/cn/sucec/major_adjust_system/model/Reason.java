package cn.sucec.major_adjust_system.model;

/**
  *   ��¼���ļ��еı���ΪԤ����ԭ��
 * @author WangChuo
 *
 */
public class Reason {
	
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
		return "Reason [id=" + id + ", content=" + content + "]";
	}
	
	public Reason() {
		super();
	}
	
	public Reason(Integer id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	
}
