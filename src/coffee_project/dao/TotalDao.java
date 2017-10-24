package coffee_project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coffee_project.dto.TotalSale;
import coffee_project.jdbc.DBCon;

public class TotalDao {
	
	private static final TotalDao instance = new TotalDao();
	
	public static TotalDao getInstance() {
		return instance;
	}

	private TotalDao() {}

	private TotalSale getTotalSale(ResultSet rs) throws SQLException {
		int rankNo = rs.getInt(1);
		String pdNo = rs.getString(2);
		String pdName = rs.getString(3);
		int price = rs.getInt(4);
		int amount = rs.getInt(5);
		int supplyPrice = rs.getInt(6);
		int surtax = rs.getInt(7);
		int salePrice = rs.getInt(8);
		int margin = rs.getInt(9);
		int marginRate = rs.getInt(10);
		
		return new TotalSale(rankNo, pdNo, pdName, supplyPrice, amount, supplyPrice, surtax, salePrice, margin, marginRate);
	}
	
	public List<TotalSale> rankPriceView() throws SQLException{
		List<TotalSale> lists = new ArrayList<>();
		String sql = "select rank, pdno, pdname, price, amount, supplyprice, surtax, saleprice, margin, mgrate  from rankPrice";
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();){
			while(rs.next()){
				lists.add(getTotalSale(rs));
			}
		}
		return lists;
	}

	public List<TotalSale> rankMarginView() throws SQLException{
		List<TotalSale> lists = new ArrayList<>();
		String sql = "select * from rankMargin";
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();){
			while(rs.next()){
				lists.add(getTotalSale(rs));
			}
		}
		return lists;
	}
}
