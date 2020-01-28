package www.intumit.service;

import java.util.List;

import www.intumit.entity.Billboard;
import www.intumit.entity.KMSException;

public class BillboardService {
	
	private BillboardDAO dao = new BillboardDAO();
	
	public Billboard selectBillboardByID(String id) throws KMSException{
		return dao.selectBillboardByID(id);
	}
	
	public List<Billboard> selectAllBillboard() throws KMSException{
		return dao.selectAllBillboard();		
	}
	
	public void insert(Billboard billboard) throws KMSException {
		if(billboard == null) {
			throw new java.lang.IllegalArgumentException(
					"新增公告時Billboard不得為null");
		}
		dao.insert(billboard);
	}
	
	public void update(Billboard billboard) throws KMSException {
		if(billboard == null) {		
			throw new java.lang.IllegalArgumentException(
				"修改公告時Billboard不得為null");
		}
		dao.update(billboard);
	}
	
	public void delete(Billboard billboard) throws KMSException{
		if(billboard == null) {		
			throw new java.lang.IllegalArgumentException(
				"刪除公告時Billboard不得為null");
		}
		dao.delete(billboard);
	}
}
