package coffee_project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coffee_project.dto.Record;
import coffee_project.jdbc.DBCon;

public class RecordDao implements SqlDao<Record> {
	private static final RecordDao Instance = new RecordDao();
	
	public static RecordDao getInstance() {
		return Instance;
	}
		
	private RecordDao() {}

	@Override
	public void insertItem(Record item) throws SQLException {
		String sql = "insert into record values(?,?,?,?,?)";
		
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);){
			pstmt.setString(1, item.getPdNo());
			pstmt.setString(2, item.getPdName());
			pstmt.setInt(3, item.getPrice());
			pstmt.setInt(4, item.getAmount());
			pstmt.setInt(5, item.getMargin());
			
			pstmt.executeUpdate();
		}
	}

	@Override
	public void deleteItem(Record item) throws SQLException {
		String sql = "delete from record where pdno=?";
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);){
			pstmt.setString(1, item.getPdNo());
			pstmt.executeUpdate();
		}
	}

	@Override
	public void updateItem(Record item) throws SQLException {
		String sql = "update record set pdno=?,pdname=?,price=?,amount=?,margin=? where pdno=?";
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);){
			pstmt.setString(1, item.getPdNo());
			pstmt.setString(2, item.getPdName());
			pstmt.setInt(3, item.getPrice());
			pstmt.setInt(4, item.getAmount());
			pstmt.setInt(5, item.getMargin());
			pstmt.setString(6, item.getPdNo());
			
			pstmt.executeUpdate();
		}
	}

	@Override
	public Record selectItemByNo(Record item) throws SQLException {
		String sql ="select pdno, pdname, price,amount,margin from record where pdno=?";
		Record record = null;
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);){
			pstmt.setString(1, item.getPdNo());
			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					record = getRecord(rs);
				}
			}
		}
		return record;
	}

	private Record getRecord(ResultSet rs) throws SQLException {
		String  pdNo = rs.getString(1);
		String pdName =rs.getString(2);
		int price =rs.getInt(3);
		int amount =rs.getInt(4);
		int margin = rs.getInt(5);

		return new Record(pdNo, pdName, price, amount, margin);
	}

	@Override
	public List<Record> selectItemByAll() throws SQLException {
		List<Record> lists = new ArrayList<>();
		String sql = "select pdno, pdname, price, amount, margin from record";
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();){
			
			while(rs.next()){
				lists.add(getRecord(rs));
			}
		}
		return lists;
	}

}
