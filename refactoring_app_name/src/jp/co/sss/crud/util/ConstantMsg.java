package jp.co.sss.crud.util;

/**
 * 設定値をまとめたクラス(メッセージ関連)
 *
 * @author System Shared
 *
 */
public class ConstantMsg {

	/** インスタンス化を禁止 */
	private ConstantMsg() {
	}

	/** 社員管理システム */
	public static final String MSG_EMPLYEE_MANAGEMENT_SYSTEM = "=== 社員管理システム ===";
	/** メニュー表示_全件表示 */
	public static final String MSG_MENU_DISPLAY_ALL = "1.全件表示";
	/** メニュー表示_社員名検索 */
	public static final String MSG_MENU_SEARCH_EMPLOYEE = "2.社員名検索";
	/** メニュー表示_部署ID検索 */
	public static final String MSG_MENU_SEARCH_DEPT_ID = "3.部署ID検索";
	/** メニュー表示_新規登録 */
	public static final String MSG_MENU_REGIST_EMPLOYEE = "4.新規登録";
	/** メニュー表示_更新 */
	public static final String MSG_MENU_UPDATE_EMPLOYEE = "5.更新";
	/** メニュー表示_削除 */
	public static final String MSG_MENU_DELETEEMPLOYEE = "6.削除";
	/** メニュー表示_終了 */
	public static final String MSG_MENU_END = "7.終了";

	/** メニュー番号入力メッセージ */
	public static final String MSG_MENU = "メニュー番号を入力してください：";
	/** 社員名入力メッセージ */
	public static final String MSG_INPUT_EMPLOYEE_NAME = "社員名:";
	/** 部署ID入力メッセージ */
	public static final String MSG_INPUT_DEPT_ID = "部署ID(1:営業部、2:経理部、3:総務部)を入力してください:";
	/** 性別入力メッセージ */
	public static final String MSG_INPUT_GENDER = "性別(0:その他, 1:男性, 2:女性, 9:回答なし):";
	/** 生年月日入力メッセージ */
	public static final String MSG_INPUT_BIRTHDAY = "生年月日(西暦年/月/日):";

	/** 更新する社員ID入力メッセージ */
	public static final String MSG_INPUT_UPDATE_EMPLOYEE_ID = "更新する社員の社員IDを入力してください:";
	/** 社員情報の登録メッセージ */
	public static final String MSG_REGISTED_EMPLOYEE = "社員情報を登録しました";
	/** 社員情報の削除メッセージ */
	public static final String MSG_DELETED_EMPLOYEE = "社員情報を削除しました";
	/** 社員情報の更新メッセージ */
	public static final String MSG_UPDATED_EMPLOYEE = "社員情報を更新しました";
	/** 社員情報の更新メッセージ */
	public static final String MSG_INPUT_DELETE_EMPLOYEE_ID = "削除する社員の社員IDを入力してください：";
	/** システム終了メッセージ */
	public static final String MSG_END_SYSTEM = "システムを終了します。";

	/** 該当者なしメッセージ */
	public static final String MSG_NOT_APPLICABLE_PERSON = "該当者はいませんでした";
	/** レコードを出力用メッセージ */
	public static final String MSG_RECORD_OUT = "社員ID\\t社員名\\t性別\\t生年月日\\t部署名";
	/** 区切り文字_タブ */
	public static final String DELIMITER_TAB = "\t";

}