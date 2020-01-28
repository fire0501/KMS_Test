package www.intumit.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import www.intumit.entity.Billboard;
import www.intumit.entity.KMSException;
import www.intumit.service.BillboardService;

public class TestBillboardServiceInsert {

	public static void main(String[] args) {
		try {
			Billboard b = new Billboard();
			b.setTitle("台灣燈會2");
			b.setDateStart("2020-01-31");
			b.setDateEnd("2020-01-31");
			b.setName("小火");
			b.setContent("活動辦法");
			
			BillboardService service = new BillboardService();
			service.insert(b);
			System.out.println(b);
		}catch(KMSException e) {
			Logger.getLogger("TestBillboardInsert").log(
					Level.SEVERE, e.getMessage(), e);
		}
	}
}
