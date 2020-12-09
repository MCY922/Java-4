package pome;

public class Wrong extends Exception{
	
	String inform;
	public String Wrong(String input) {
		inform = "请输入“"+input+"”不正确，请重新输入！";
		return inform;
	}
	
	public String Wrong(int input) {
		inform = "请输入“"+input+"”不正确，请重新输入！";
		return inform;
	}
}