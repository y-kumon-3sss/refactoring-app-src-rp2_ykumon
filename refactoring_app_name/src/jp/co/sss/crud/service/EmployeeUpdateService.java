package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeUpdateService {
	public static void update(String empId) throws SystemErrorException {
		try {
			EmployeeDAO.update(empId);// 社員情報更新
		} catch (ClassNotFoundException | IOException | SQLException | ParseException e) {
			//独自例外の送出
			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR, e);
		}
	}
}
