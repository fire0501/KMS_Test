package www.intumit.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import www.intumit.entity.Billboard;
import www.intumit.entity.KMSException;

public class BillboardDAO {
	//查詢單一
	private static final String SELECT_BILLBOARD_BY_ID=
		"SELECT id, title, dataStart, dataEnd, name, content " 
	  + "FROM billboard " 
	  + "WHERE id = ?";	
	public Billboard selectBillboardByID(String id) throws KMSException{
		Billboard b = new Billboard();
		try( 	Connection connection = KDBConnection.getConnection();
				PreparedStatement prst = connection.prepareStatement(SELECT_BILLBOARD_BY_ID);
				){
			prst.setString(1, id);
			try(ResultSet rs = prst.executeQuery()){
				while(rs.next()) {
					b.setId(rs.getInt("id"));
					b.setTitle(rs.getString("title"));
					b.setDateStart(LocalDate.parse(rs.getString("dataStart")));
					b.setDateEnd(LocalDate.parse(rs.getString("dataEnd")));
					b.setName(rs.getString("name"));
					b.setContent(rs.getString("content"));
				}			
			}
		} catch (SQLException e) {
			throw new KMSException("查詢失敗",e);
		}
		return b;
	}
		
	//查詢全部
	private static final String SELECT_ALL_BILLBOARD=
				"SELECT id, title, dataStart, dataEnd, name, content "
			  + "FROM billboard;";
	public List<Billboard> selectAllBillboard() throws KMSException {
		List<Billboard> list = new ArrayList<>();
		try( 	Connection connection = KDBConnection.getConnection();
				PreparedStatement prst = connection.prepareStatement(SELECT_ALL_BILLBOARD);
				ResultSet rs = prst.executeQuery()
				){
				while(rs.next()) {
					Billboard b = new Billboard();
					b.setId(rs.getInt("id"));
					b.setTitle(rs.getString("title"));
					b.setDateStart(LocalDate.parse(rs.getString("dataStart")));
					b.setDateEnd(LocalDate.parse(rs.getString("dataEnd")));
					b.setName(rs.getString("name"));
					b.setContent(rs.getString("content"));
					list.add(b);					
				}									
		} catch (SQLException e) {
			throw new KMSException("查詢全部標題",e);
		}	
		return list;
	}
	
	//新增
	private static final String INSERT_BILLBOARD = 
			"INSERT INTO billboard  "
		   +"(title, dataStart, dataEnd, name, content) "
		   + "VALUES (?,?,?,?,?);";	
	public void insert(Billboard billboard) throws KMSException {
		try(
			Connection connection = KDBConnection.getConnection();
			PreparedStatement pstm = connection.prepareStatement(INSERT_BILLBOARD);	
			){
				pstm.setString(1, billboard.getTitle());
				pstm.setString(2, String.valueOf(billboard.getDateStart()));
				pstm.setString(3, String.valueOf(billboard.getDateEnd()));
				pstm.setString(4, billboard.getName());
				pstm.setString(5, billboard.getContent());
				int rows = pstm.executeUpdate();
				System.out.println("新增佈告欄成功" + rows);
		} catch (SQLException e) {
			throw new KMSException("新增失敗" + e);
		}		
	}
	
	//修改
	private static final String UPDATE_BILLBOARD =		
			"UPDATE billboard SET  " 
			+ "title = ?, dataStart = ?, dataEnd = ?, name = ?, content = ? " 
			+ "WHERE id = ?;";
	public void update(Billboard billboard) throws KMSException {
		try(
			Connection connection = KDBConnection.getConnection();
			PreparedStatement pstm = connection.prepareStatement(UPDATE_BILLBOARD);	
			){
			pstm.setString(1, billboard.getTitle());
			pstm.setString(2, String.valueOf(billboard.getDateStart()));
			pstm.setString(3, String.valueOf(billboard.getDateEnd()));
			pstm.setString(4, billboard.getName());
			pstm.setString(5, billboard.getContent());
			pstm.setInt(6, billboard.getId());
			int rows = pstm.executeUpdate();
			System.out.println("修改成功: " + rows);			
		} catch (SQLException e) {
			throw new KMSException("修改失敗" + e);
		} 			
	}	
	
	//刪除
	private static final String DELETE_BILLBOARD ="DELETE FROM billboard WHERE id = ?;";	
	public void delete(Billboard billboard) throws KMSException{
		try(
			Connection connection = KDBConnection.getConnection();
			PreparedStatement pstm = connection.prepareStatement(DELETE_BILLBOARD);		
			){
			pstm.setInt(1, billboard.getId());
			int rows = pstm.executeUpdate();
			System.out.println("刪除成功" + rows);
		}catch (SQLException e) {
			throw new KMSException("刪除失敗" + e);
		} 				
	}
}
