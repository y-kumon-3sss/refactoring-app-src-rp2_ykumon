package jp.co.sss.crud.io;

import jp.co.sss.crud.util.ConstantMsg;

public class MenuNoReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		// TODO 自動生成されたメソッド・スタブ
		return ConstantMsg.MSG_ERROR_INPUT_CHECK_MENU_NUMBER;
	}

	@Override
	public boolean isValid(String inputString) {
		// 1-7 までの数値
		return inputString.matches("^[1-7１-７]$");
	}

	@Override
	public boolean isParseInt() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

}
