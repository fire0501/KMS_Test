package www.intumit.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import www.intumit.entity.Billboard;
import www.intumit.entity.KMSException;
import www.intumit.service.BillboardService;

public class TestBillboardServiceDelete {

	public static void main(String[] args) {
		try {
			Billboard b = new Billboard();
			b.setId(10);
			BillboardService service = new BillboardService();
			service.delete(b);
			System.out.println(b);
		}catch(KMSException e) {
			Logger.getLogger("TestBillboardInsert").log(
					Level.SEVERE, e.getMessage(), e);
		}
	}
}
