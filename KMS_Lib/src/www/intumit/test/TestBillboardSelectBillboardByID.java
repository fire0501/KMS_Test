package www.intumit.test;

import java.util.List;

import www.intumit.entity.Billboard;
import www.intumit.entity.KMSException;
import www.intumit.service.BillboardService;

public class TestBillboardSelectBillboardByID {
	public static void main(String[] args) {
		BillboardService service = new BillboardService();
		try {	
			System.out.println(service.selectBillboardByID("5"));
		} catch (KMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
