package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.DBController;
import jp.co.sss.crud.service.EmployeeAllFindService;
import jp.co.sss.crud.service.EmployeeFindByEmpNameService;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 *
 * @author System Shared
 *
 */
public class MainSystem {
	/**
	 * 社員管理システムを起動
	 *
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int menuNo = 0;

		do {
			// メニューの表示
			System.out.println(ConstantMsg.MSG_EMPLYEE_MANAGEMENT_SYSTEM);
			System.out.println(ConstantMsg.MSG_MENU_DISPLAY_ALL);
			System.out.println(ConstantMsg.MSG_MENU_SEARCH_EMPLOYEE);
			System.out.println(ConstantMsg.MSG_MENU_SEARCH_DEPT_ID);
			System.out.println(ConstantMsg.MSG_MENU_REGIST_EMPLOYEE);
			System.out.println(ConstantMsg.MSG_MENU_UPDATE_EMPLOYEE);
			System.out.println(ConstantMsg.MSG_MENU_DELETEEMPLOYEE);
			System.out.println(ConstantMsg.MSG_MENU_END);
			System.out.print(ConstantMsg.MSG_MENU);

			// メニュー番号の入力
			String menuNoStr = br.readLine();
			menuNo = Integer.parseInt(menuNoStr);

			// 機能の呼出
			switch (menuNo) {
			case ConstantValue.MENU_NUMBER_ONE:
				// 全件表示機能の呼出
				EmployeeAllFindService.findAll();
				break;

			case ConstantValue.MENU_NUMBER_TWO:
				// 社員名検索
				System.out.print(ConstantMsg.MSG_INPUT_EMPLOYEE_NAME);
				String searchEmpName = br.readLine();

				// 検索機能の呼出
				EmployeeFindByEmpNameService.findByEmployeeName(searchEmpName);
				break;

			case ConstantValue.MENU_NUMBER_THREE:
				// 検索する部署IDを入力
				System.out.print(ConstantMsg.MSG_INPUT_DEPT_ID);
				String searchDeptId = br.readLine();

				// 検索機能の呼出
				DBController.findByDeptId(searchDeptId);
				break;

			case ConstantValue.MENU_NUMBER_FOUR:
				// 登録する値を入力
				System.out.print(ConstantMsg.MSG_INPUT_EMPLOYEE_NAME);
				String empName = br.readLine();
				System.out.print(ConstantMsg.MSG_INPUT_GENDER);
				String gender = br.readLine();
				System.out.print(ConstantMsg.MSG_INPUT_BIRTHDAY);
				String birthday = br.readLine();
				System.out.print(ConstantMsg.MSG_INPUT_DEPT_ID);
				String newDeptId = br.readLine();

				// 登録機能の呼出
				DBController.insert(empName, gender, birthday, newDeptId);
				break;

			case ConstantValue.MENU_NUMBER_FIVE:
				// 更新する社員IDを入力
				System.out.print(ConstantMsg.MSG_INPUT_UPDATE_EMPLOYEE_ID);

				// 更新する値を入力する
				String updateEmpId = br.readLine();
				Integer.parseInt(updateEmpId);

				// 更新機能の呼出
				DBController.update(updateEmpId);
				System.out.println(ConstantMsg.MSG_UPDATED_EMPLOYEE);

				break;

			case ConstantValue.MENU_NUMBER_SIX:
				// 削除する社員IDを入力
				System.out.print(ConstantMsg.MSG_INPUT_DELETE_EMPLOYEE_ID);

				// 削除機能の呼出
				DBController.delete();
				break;

			}
		} while (menuNo != ConstantValue.MENU_NUMBER_SEVEN);
		System.out.println(ConstantMsg.MSG_END_SYSTEM);
	}
}
