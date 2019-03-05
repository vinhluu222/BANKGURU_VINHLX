package pageUIs;

public class NewAccountPageUI {
	public static final String CUSTOMERID_TEXTBOX = "//input[@name='cusid']";
	public static final String ACCOUNT_TYPE_DROPDOWN = "//select[@name='selaccount']";
	public static final String INITIAL_DEPOSTI = "//input[@name='inideposit']";
	public static final String SUBMIT_BTN = "//input[@name='button2']";
	public static final String RESET_BTN = "//input[@name='reset']";
	public static final String REGISTERED_MSG = "//p[contains(text(), 'Account Generated Successfully!!!')]";
	public static final String CURRENT_AMOUNT_VALUE = "//td[contains(text(), 'Current Amount')]/following-sibling::td";
	public static final String ACCOUNT_NO_TEXTBOX = "//td[contains(text(), 'Account ID')]/following-sibling::td";
	public static final String initialDepositValue = "50000";
}
