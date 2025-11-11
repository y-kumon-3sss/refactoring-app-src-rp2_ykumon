package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.MenuNoReader;
import jp.co.sss.crud.service.EmployeeAllFindService;
import jp.co.sss.crud.service.EmployeeDeleteService;
import jp.co.sss.crud.service.EmployeeFindByDeptIdService;
import jp.co.sss.crud.service.EmployeeFindByEmpNameService;
import jp.co.sss.crud.service.EmployeeRegisterService;
import jp.co.sss.crud.service.EmployeeUpdateService;
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
		// メニュー番号の入力チェッククラスのインスタンス生成
		MenuNoReader menuReader = new MenuNoReader();

		int menuNo = 0;

		do {
			try {
				// メニューの表示
				ConsoleWriter.showMenu();

				// メニュー番号の入力
				menuNo = (Integer) menuReader.input();

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
					EmployeeFindByDeptIdService.findByDeptId(searchDeptId);
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
					EmployeeRegisterService.insert(empName, gender, birthday, newDeptId);
					break;

				case ConstantValue.MENU_NUMBER_FIVE:
					// 更新する社員IDを入力
					System.out.print(ConstantMsg.MSG_INPUT_UPDATE_EMPLOYEE_ID);

					// 更新する値を入力する
					String updateEmpId = br.readLine();
					try {
						Integer.parseInt(updateEmpId);
					} catch (NumberFormatException e) {
						throw new IllegalInputException(ConstantMsg.MSG_ERROR_INPUT_NUMBER, e);
					}

					// 更新機能の呼出
					EmployeeUpdateService.update(updateEmpId);
					System.out.println(ConstantMsg.MSG_UPDATED_EMPLOYEE);

					break;

				case ConstantValue.MENU_NUMBER_SIX:
					// 削除する社員IDを入力
					System.out.print(ConstantMsg.MSG_INPUT_DELETE_EMPLOYEE_ID);

					// 削除機能の呼出
					EmployeeDeleteService.delete();
					break;

				}
			} catch (IllegalInputException e) {//不正な入力があった場合、ループに戻る 
				System.out.println(e.getMessage());
				System.out.println();
				continue;
			} catch (SystemErrorException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				break;
			}
		} while (menuNo != ConstantValue.MENU_NUMBER_SEVEN);
		System.out.println(ConstantMsg.MSG_END_SYSTEM);

	}
}
