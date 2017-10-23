package coffee_project.service;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import coffee_project.dao.CodeDao;
import coffee_project.dao.RecordDao;
import coffee_project.dao.SqlDao;
import coffee_project.dto.Code;
import coffee_project.dto.Record;

public class RecordService {
	private SqlDao<Record> recordDao;
	private SqlDao<Code> codeDao;
	
	public RecordService(){
		recordDao = RecordDao.getInstance();
		this.codeDao = CodeDao.getInstance();
	}
	private void showMessage(String msg){
		JOptionPane.showMessageDialog(null, msg);
	}
	
	public void insertRecord(Record record){
		try {
			recordDao.insertItem(record);
			showMessage("추가 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteRecord(Record record){
		try {
			recordDao.deleteItem(record);
			showMessage("삭제 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateRecord(Record record){
		try {
			recordDao.updateItem(record);
			showMessage("갱신 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Record> selectRecordByAll(){
		try {
			return recordDao.selectItemByAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Code> selectCodeIdByAll(){
		try {
			 return codeDao.selectItemByAllNo();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
}
