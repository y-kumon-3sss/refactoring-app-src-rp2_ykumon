package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeDeleteService {
	public static void delete() throws SystemErrorException {
		try {
			EmployeeDAO.delete();// 社員情報削除
		} catch (ClassNotFoundException | IOException | SQLException e) {
			//独自例外の送出
			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR, e);
		}
	}
}
