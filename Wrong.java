package pome;

public class Wrong extends Exception{
	
	String inform;
	public String Wrong(String input) {
		inform = "�����롰"+input+"������ȷ�����������룡";
		return inform;
	}
	
	public String Wrong(int input) {
		inform = "�����롰"+input+"������ȷ�����������룡";
		return inform;
	}
}