package coffee_project.dao;

import java.sql.SQLException;
import java.util.List;

import coffee_project.dto.Code;

public interface SqlDao<T> {
	
	void insertItem(T item)throws SQLException;
	void deleteItem(T item)throws SQLException;
	void updateItem(T item)throws SQLException;
	T selectItemByNo(T item)throws SQLException;
	List<T> selectItemByAll()throws SQLException;
	List<Code> selectItemByAllNo()throws SQLException;
}
