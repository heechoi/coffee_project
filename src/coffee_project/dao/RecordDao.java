package coffee_project.dao;

import java.sql.Connection;
import java.sql.SQLException;
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
		Connection con = DBCon.getInstance().getConnection();
		
	}

	@Override
	public void deleteItem(Record item) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateItem(Record item) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Record selectItemByNo(Record item) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Record> selectItemByAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
