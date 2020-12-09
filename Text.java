package pome;

import pome.fileout;
import pome.Student;

public class Text {
	static Student student0=new Student();
	static fileout file = new fileout();
	public static void main(String[] args) {
		
		  System.out.println("**********学生信息录入**********");
		  student0.inputInformation(); System.out.println("\n\n个人信息：");
		  System.out.println("姓名 性别 年龄 学号");
		  System.out.println(student0.name+"   "+student0.sex+"    "+student0.
		  age+"    "+student0.stuNo);
		 
		String a=file.readFile();
		String b = file.operationFile(a);
		if(file.outFile(addNewInformation(student0)))
		System.out.println("信息导入成功！");
		if(file.outFile(b))
			System.out.println("作业导入成功！");

	}
	public static String addNewInformation(Student student) {
		String information = null;
		information="个人信息：\n姓名 性别 年龄 学号\n"+student0.name+"  "+student0.sex+"  "+student0.age+"  "+student0.stuNo+"\n完成作业：\n";
		 return information;
	}
}
