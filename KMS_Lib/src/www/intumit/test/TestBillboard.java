package www.intumit.test;

import java.time.LocalDate;

import www.intumit.entity.Billboard;

public class TestBillboard {

	public static void main(String[] args) {
		Billboard b = new Billboard();
		b.setId(1);
		b.setTitle("該出什麼活動");
		b.setDateStart(LocalDate.of(2020, 1, 24));
		b.setDateEnd(LocalDate.of(2020, 1, 31));
		b.setName("Fire");
		b.setContent("我也不知道哈哈哈");
		
		System.out.println(b.getId());
		System.out.println(b.getTitle());
		System.out.println(b.getDateStart());
		System.out.println(b.getDateEnd());
		System.out.println(b.getName());
		System.out.println(b.getContent());
	}

}
