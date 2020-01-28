package www.intumit.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import www.intumit.entity.Billboard;
import www.intumit.entity.KMSException;
import www.intumit.service.BillboardService;

public class TestBillboardServiceUpdata {

	public static void main(String[] args) {
		try {
			Billboard b = new Billboard();
			b.setId(8);
			b.setTitle("台灣燈會7");
			b.setDateStart("2020-01-31");
			b.setDateEnd("2020-01-31");
			b.setName("小蔡");
			b.setContent("活動辦法");
			
			BillboardService service = new BillboardService();
			service.update(b);
			System.out.println(b);
		}catch(KMSException e) {
			Logger.getLogger("TestBillboardInsert").log(
					Level.SEVERE, e.getMessage(), e);
		}
	}
}
