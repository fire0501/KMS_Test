package www.intumit.test;

import java.util.List;

import www.intumit.entity.Billboard;
import www.intumit.entity.KMSException;
import www.intumit.service.BillboardService;

public class TestBillboardServiceSelcet {

	public static void main(String[] args) {
		BillboardService service = new BillboardService();
		try {
			List<Billboard> list = service.selectAllBillboard();
			System.out.println(list);
		} catch (KMSException e) {
			e.printStackTrace();
		}

	}

}
