package pome;

import pome.fileout;
import pome.Student;

public class Text {
	static Student student0=new Student();
	static fileout file = new fileout();
	public static void main(String[] args) {
		
		  System.out.println("**********ѧ����Ϣ¼��**********");
		  student0.inputInformation(); System.out.println("\n\n������Ϣ��");
		  System.out.println("���� �Ա� ���� ѧ��");
		  System.out.println(student0.name+"   "+student0.sex+"    "+student0.
		  age+"    "+student0.stuNo);
		 
		String a=file.readFile();
		String b = file.operationFile(a);
		if(file.outFile(addNewInformation(student0)))
		System.out.println("��Ϣ����ɹ���");
		if(file.outFile(b))
			System.out.println("��ҵ����ɹ���");

	}
	public static String addNewInformation(Student student) {
		String information = null;
		information="������Ϣ��\n���� �Ա� ���� ѧ��\n"+student0.name+"  "+student0.sex+"  "+student0.age+"  "+student0.stuNo+"\n�����ҵ��\n";
		 return information;
	}
}
