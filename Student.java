package pome;

import java.util.Scanner;

public class Student {
	String name;
	String sex;
	int age;
	String stuNo;
public void inputInformation() {
	Scanner reader = new Scanner(System.in);
	a:for(;;) {
		try {
			System.out.println("����������");
	        name=reader.nextLine();
	        System.out.println("¼��ɹ�~");
	        break a;
		}
		catch(Exception e) {
			System.out.println("������� ��"+name+"�� ��ʽ����ȷ�����������룡");
		}
	}
	b:for(;;) {
	try{
	System.out.println("�������Ա����ģ�");
	sex=reader.nextLine();
	sexWrong(sex);
	break b;
	}
	catch(Wrong e) {
		System.out.println(e.wrong(sex));
	}
	}
	c:for(;;) {
		try{
			System.out.println("���������䣨15-75�꣩");
			age=reader.nextInt();
		    ageWrong(age);
		    break c;
		}
		catch(Wrong e) {
			System.out.println(e.wrong(age));
		}
		}
	d:for(;;) {
		try {
			Scanner reader0 = new Scanner(System.in);
			System.out.println("������ѧ��");
			stuNo=reader0.nextLine();
	        System.out.println("¼��ɹ�~");
	        break d;
		}
		catch(Exception e) {
			System.out.println("������ġ�"+stuNo+"����ʽ����ȷ�����������룡");
		}
	}
	
}
public void sexWrong(String sex) throws Wrong{
	String x="��";
	String y="Ů";
	if (sex.equals(x)||sex.equals(y)){
		System.out.println("¼��ɹ�~");
		}
	else throw new Wrong();
}
public void ageWrong(int age) throws Wrong{
	int x=15;
	int y=75;
	if (age>=x&&age<=y){
		System.out.println("¼��ɹ�~");
		}
	else throw new Wrong();
}

}