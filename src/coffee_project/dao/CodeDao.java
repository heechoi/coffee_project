package coffee_project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coffee_project.dto.Code;
import coffee_project.jdbc.DBCon;

public class CodeDao implements SqlDao<Code> {
	private static final CodeDao instance = new CodeDao();
	
	
	public static CodeDao getInstance() {
		return instance;
	}
	
	private CodeDao() {}

	@Override
	public void insertItem(Code item) throws SQLException {
		String sql = "insert into code values(?,?)";
		Connection con = DBCon.getInstance().getConnection();
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, item.getCodeId());
			pstmt.setString(2, item.getCodeName());
			
			pstmt.executeUpdate();
		}
		
	}

	@Override
	public void deleteItem(Code item) throws SQLException {
		String sql = "delete from code where codeid=?";
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);){
			pstmt.setString(1, item.getCodeId());
			
			pstmt.executeUpdate();
		}
	}

	@Override
	public void updateItem(Code item) throws SQLException {
		String sql = "update code set codeid=?,codename=? where codeid=?";
		try(PreparedStatement pstmt= DBCon.getInstance().getConnection().prepareStatement(sql);){
			pstmt.setString(1, item.getCodeId());
			pstmt.setString(2, item.getCodeName());
			pstmt.setString(3, item.getCodeId());
			
			pstmt.executeUpdate();
		}
	}

	@Override
	public Code selectItemByNo(Code item) throws SQLException {
		String sql = "select codeid,codename from code where codeid=?";
		Code code=null;
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql)){
				pstmt.setString(1, item.getCodeId());
				try(ResultSet rs=pstmt.executeQuery();){
					if(rs.next()){
						code = getCode(rs);
					}
				}
		}
		return code;
	}

	private Code getCode(ResultSet rs) throws SQLException {
		String codeId = rs.getString(1);
		String codeName = rs.getString(2);
		return new Code(codeId, codeName);
	}

	@Override
	public List<Code> selectItemByAll() throws SQLException {
		List<Code> lists = new ArrayList<>();
		String sql = "select codeid, codename from code";
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();){
			while(rs.next()){
				lists.add(getCode(rs));
			}
		}
		return lists;
	}

}
