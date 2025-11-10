package jp.co.sss.crud.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantSQL;
import jp.co.sss.crud.util.ConstantValue;

/**
 * DB操作処理用のクラス
 *
 * @author System Shared
 */
public class DBController {

	/** インスタンス化を禁止 */
	private DBController() {
	}

	/**
	 * 全ての社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 */
	public static void findAll() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			//resultSetの結果Setがない場合はfalse
			if (!resultSet.isBeforeFirst()) {
				System.out.println(ConstantMsg.MSG_NOT_APPLICABLE_PERSON);
				return;
			}

			// レコードを出力
			System.out.println(ConstantMsg.MSG_RECORD_OUT);
			while (resultSet.next()) {
				System.out.print(resultSet.getString(ConstantValue.COL_EMP_ID) + ConstantMsg.DELIMITER_TAB);
				System.out.print(resultSet.getString(ConstantValue.COL_EMP_NAME) + ConstantMsg.DELIMITER_TAB);

				int gender = Integer.parseInt(resultSet.getString(ConstantValue.COL_GENDER));
				if (gender == ConstantValue.GENDER_NO_ANSWER) {
					System.out.print(ConstantValue.STRING_GENDER_NOT_ANSWER + ConstantMsg.DELIMITER_TAB);
				} else if (gender == ConstantValue.GENDER_MALE) {
					System.out.print(ConstantValue.STRING_GENDER_MALE + ConstantMsg.DELIMITER_TAB);

				} else if (gender == ConstantValue.GENDER_FEMALE) {
					System.out.print(ConstantValue.STRING_GENDER_FEMALE + ConstantMsg.DELIMITER_TAB);

				} else if (gender == ConstantValue.GENDER_OTHERS) {
					System.out.print(ConstantValue.STRING_GENDER_OTHERS + ConstantMsg.DELIMITER_TAB);

				}

				System.out.print(resultSet.getString(ConstantValue.COL_BIRTHDAY) + ConstantMsg.DELIMITER_TAB);
				System.out.println(resultSet.getString(ConstantValue.COL_DEPT_NAME));
			}

			System.out.println("");
		} finally {
			// ResultSetをクローズ
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 社員名に該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static void findByEmployeeName() throws ClassNotFoundException, SQLException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 検索ワード
		String searchWord = br.readLine();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_EMP_NAME);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setString(1, ConstantValue.SQL_WILDCARD + searchWord + ConstantValue.SQL_WILDCARD);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();
			if (!resultSet.isBeforeFirst()) {
				System.out.println(ConstantMsg.MSG_NOT_APPLICABLE_PERSON);
				return;
			}

			System.out.println(ConstantMsg.MSG_RECORD_OUT);
			while (resultSet.next()) {
				System.out.print(resultSet.getString(ConstantValue.COL_EMP_ID));
				System.out.print(ConstantMsg.DELIMITER_TAB);

				System.out.print(resultSet.getString(ConstantValue.COL_EMP_NAME));
				System.out.print(ConstantMsg.DELIMITER_TAB);

				String genderString = resultSet.getString(ConstantValue.COL_GENDER);
				int gender = Integer.parseInt(genderString);
				if (gender == ConstantValue.GENDER_NO_ANSWER) {
					System.out.print(ConstantValue.STRING_GENDER_NOT_ANSWER);
				} else if (gender == ConstantValue.GENDER_MALE) {
					System.out.print(ConstantValue.STRING_GENDER_MALE);

				} else if (gender == ConstantValue.GENDER_FEMALE) {
					System.out.print(ConstantValue.STRING_GENDER_FEMALE);

				} else if (gender == ConstantValue.GENDER_OTHERS) {
					System.out.print(ConstantValue.STRING_GENDER_OTHERS);

				}

				System.out.print(ConstantMsg.DELIMITER_TAB);
				System.out.print(resultSet.getString(ConstantValue.COL_BIRTHDAY));
				System.out.print(ConstantMsg.DELIMITER_TAB);

				System.out.println(resultSet.getString(ConstantValue.COL_DEPT_NAME));
			}

			System.out.println("");

		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 部署IDに該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static void findByDeptId(String deptId) throws ClassNotFoundException, SQLException, IOException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_DEPT_ID);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setInt(1, Integer.parseInt(deptId));

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			if (!resultSet.isBeforeFirst()) {
				System.out.println(ConstantMsg.MSG_NOT_APPLICABLE_PERSON);
				return;
			}

			System.out.println(ConstantMsg.MSG_RECORD_OUT);
			while (resultSet.next()) {
				System.out.print(resultSet.getString(ConstantValue.COL_EMP_ID));
				System.out.print(ConstantMsg.DELIMITER_TAB);

				System.out.print(resultSet.getString(ConstantValue.COL_EMP_NAME));
				System.out.print(ConstantMsg.DELIMITER_TAB);

				String genderString = resultSet.getString(ConstantValue.COL_GENDER);
				int gender = Integer.parseInt(genderString);
				if (gender == ConstantValue.GENDER_NO_ANSWER) {
					System.out.print(ConstantValue.STRING_GENDER_NOT_ANSWER);
				} else if (gender == ConstantValue.GENDER_MALE) {
					System.out.print(ConstantValue.STRING_GENDER_MALE);

				} else if (gender == ConstantValue.GENDER_FEMALE) {
					System.out.print(ConstantValue.STRING_GENDER_FEMALE);

				} else if (gender == ConstantValue.GENDER_OTHERS) {
					System.out.print(ConstantValue.STRING_GENDER_OTHERS);

				}

				System.out.print(ConstantMsg.DELIMITER_TAB);
				System.out.print(resultSet.getString(ConstantValue.COL_BIRTHDAY));
				System.out.print(ConstantMsg.DELIMITER_TAB);

				String deptIdString = resultSet.getString(ConstantValue.COL_DEPT_ID);
				int resultDeptId = Integer.parseInt(deptIdString);
				if (resultDeptId == ConstantValue.DEPT_SALES_DEPARTMENT) {
					System.out.println(ConstantValue.DEPT_STRING_SALES_DEPARTMENT);
				} else if (resultDeptId == ConstantValue.DEPT_ACCOUNTING_DEPARTMENT) {
					System.out.println(ConstantValue.DEPT_STRING_ACCOUNTING_DEPARTMENT);
				} else if (resultDeptId == ConstantValue.DEPT_GENERAL_AFFAIRS_DEPARTMENT) {
					System.out.println(ConstantValue.DEPT_STRING_GENERAL_AFFAIRS_DEPARTMENT);

				}
			}

			System.out.println("");
		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 社員情報を1件登録
	 * 
	 * @param empName 社員名
	 * @param gender 性別
	 * @param birthday 生年月日
	 * @param deptId 部署ID
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException            DB処理でエラーが発生した場合に送出
	 * @throws IOException             入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	public static void insert(String empName, String gender, String birthday, String deptId)
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_INSERT);

			// 入力値をバインド
			preparedStatement.setString(ConstantValue.PARAM_INDEX_ONE, empName);
			preparedStatement.setInt(ConstantValue.PARAM_INDEX_TWO, Integer.parseInt(gender));
			SimpleDateFormat sdf = new SimpleDateFormat(ConstantValue.DATE_FORMAT_YYYY_MM_DD);
			preparedStatement.setObject(ConstantValue.PARAM_INDEX_THREE, sdf.parse(birthday), Types.DATE);
			preparedStatement.setInt(ConstantValue.PARAM_INDEX_FOUR, Integer.parseInt(deptId));

			// SQL文を実行
			preparedStatement.executeUpdate();

			// 登録完了メッセージを出力
			System.out.println(ConstantMsg.MSG_REGISTED_EMPLOYEE);
		} finally {
			DBManager.close(preparedStatement);
			DBManager.close(connection);
		}
	}

	/**
	 * 社員情報を1件更新
	 * 
	 * @param empId 社員ID
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException            DB処理でエラーが発生した場合に送出
	 * @throws IOException             入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	public static void update(String empId)
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);

			System.out.print(ConstantMsg.MSG_INPUT_EMPLOYEE_NAME);
			String empName = br.readLine();
			// 性別を入力
			System.out.print(ConstantMsg.MSG_INPUT_GENDER);
			String gender = br.readLine();
			// 誕生日を入力
			System.out.print(ConstantMsg.MSG_INPUT_BIRTHDAY);
			String birthday = br.readLine();

			// 部署IDを入力
			System.out.print(ConstantMsg.MSG_INPUT_DEPT_ID);
			String deptId = br.readLine();

			// 入力値をバインド
			preparedStatement.setString(ConstantValue.PARAM_INDEX_ONE, empName);
			preparedStatement.setInt(ConstantValue.PARAM_INDEX_TWO, Integer.parseInt(gender));
			SimpleDateFormat sdf = new SimpleDateFormat(ConstantValue.DATE_FORMAT_YYYY_MM_DD);
			preparedStatement.setObject(ConstantValue.PARAM_INDEX_THREE, sdf.parse(birthday), Types.DATE);
			preparedStatement.setInt(ConstantValue.PARAM_INDEX_FOUR, Integer.parseInt(deptId));
			preparedStatement.setInt(ConstantValue.PARAM_INDEX_FIVE, Integer.parseInt(empId));

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();

		} finally {
			// クローズ処理
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 社員情報を1件削除
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static void delete() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			// データベースに接続
			connection = DBManager.getConnection();
			String empId = br.readLine();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_DELETE);

			// 社員IDをバインド
			preparedStatement.setInt(ConstantValue.PARAM_INDEX_ONE, Integer.parseInt(empId));

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();

			System.out.println(ConstantMsg.MSG_DELETED_EMPLOYEE);

		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			// Statementをクローズ
			try {
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// DBとの接続を切断
		}
	}
}
