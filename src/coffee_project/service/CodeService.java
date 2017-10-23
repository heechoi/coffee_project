package coffee_project.service;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import coffee_project.dao.CodeDao;
import coffee_project.dao.SqlDao;
import coffee_project.dto.Code;

public class CodeService {
	private SqlDao<Code> codeDao;
	
	public CodeService(){
		codeDao = CodeDao.getInstance();
	}
	
	private void showMessage(String msg){
		JOptionPane.showMessageDialog(null, msg);
	}
	
	public void insertCode(Code code){
		try {
			codeDao.insertItem(code);
			showMessage("추가 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCode(Code code){
		try {
			codeDao.deleteItem(code);
			showMessage("삭제 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCode(Code code){
		try {
			codeDao.updateItem(code);
			showMessage("갱신 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Code> selectCodeByAll(){
		try {
			return codeDao.selectItemByAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
