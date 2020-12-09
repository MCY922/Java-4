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
			System.out.println("请输入姓名");
	        name=reader.nextLine();
	        System.out.println("录入成功~");
	        break a;
		}
		catch(Exception e) {
			System.out.println("您输入的 “"+name+"” 格式不正确，请重新输入！");
		}
	}
	b:for(;;) {
	try{
	System.out.println("请输入性别（中文）");
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
			System.out.println("请输入年龄（15-75岁）");
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
			System.out.println("请输入学号");
			stuNo=reader0.nextLine();
	        System.out.println("录入成功~");
	        break d;
		}
		catch(Exception e) {
			System.out.println("您输入的“"+stuNo+"”格式不正确，请重新输入！");
		}
	}
	
}
public void sexWrong(String sex) throws Wrong{
	String x="男";
	String y="女";
	if (sex.equals(x)||sex.equals(y)){
		System.out.println("录入成功~");
		}
	else throw new Wrong();
}
public void ageWrong(int age) throws Wrong{
	int x=15;
	int y=75;
	if (age>=x&&age<=y){
		System.out.println("录入成功~");
		}
	else throw new Wrong();
}

}