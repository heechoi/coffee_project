package coffee_project.service;

import java.sql.SQLException;
import java.util.List;

import coffee_project.dao.TotalDao;
import coffee_project.dto.TotalSale;

public class TotalService {
	private TotalDao totalDao;
	
	public TotalService() {
		totalDao = TotalDao.getInstance();
	}

	public List<TotalSale> priceViewByAll(){
		try {
			return totalDao.rankPriceView();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<TotalSale> marginViewByAll(){
		try {
			return totalDao.rankMarginView();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
