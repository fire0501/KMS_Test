package www.intumit.entity;

import java.time.LocalDate;

public class Billboard {	
	private int id; 		//Pkey	
	private String title;  	//標題	
	private LocalDate dateStart ; //發佈日期
	private LocalDate dateEnd ;   //截止日期
	private String name;	//發佈者	
	private String content;	//內容
	
	public Billboard() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getDateStart() {
		return dateStart;
	}
	public void setDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}
	public void setDateStart(String dataStr) {
		LocalDate date = LocalDate.parse(dataStr);
		this.setDateStart(date);
	}		
	public LocalDate getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(LocalDate dateEnd) {
		this.dateEnd = dateEnd;
	}
	public void setDateEnd(String dateEnd) {
		LocalDate date = LocalDate.parse(dateEnd);
		this.setDateEnd(date);
	}				
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Billboard other = (Billboard) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "id" + id 
			+ "\n 標題 " + title 
			+ "\n 發佈日期 " + dateStart 
			+ "\n 截止日期 " + dateEnd
			+ "\n 發佈者 " + name 
			+ "\n 內文 " + content;
	}	
}
