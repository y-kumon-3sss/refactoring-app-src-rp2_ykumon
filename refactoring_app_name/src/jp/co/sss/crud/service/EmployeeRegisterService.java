package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeRegisterService {
	public static void insert(String empName, String gender, String birthday, String deptId)
			throws SystemErrorException {
		try {
			EmployeeDAO.insert(empName, gender, birthday, deptId);// 社員情報登録
		} catch (ClassNotFoundException | IOException | SQLException | ParseException e) {
			//独自例外の送出
			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR, e);
		}
	}
}
