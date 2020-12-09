# 计192班 马成彧 2019311530<br/>
# Java最后一次实验报告<br/>
##  实验代码
```
package pome;

import java.io.*;
import java.util.Scanner;

public class fileout {
	int n;
	public String operationFile(String longer) {
		String l=null;
		String s;
	    char[] a;
		for(int i = 0;i<longer.length();i=i+7) {
			 a=new char[7];
			 try {
				 longer.getChars(i, i+7, a, 0);
		       } catch( Exception ex) {
		            System.out.println("发生错误");
		        }
			s = String.valueOf(a);
			if(l==null) {
				l=s;
				}
			else if(l!=null)
				l=l+s;
			if(((i+7)/7)%2==1) {
				l=l+",";
				}
			else if(((i+7)/7)%2==0) {
                l=l+"。\n";
			}
			
		}
		
		return l;
	}
	
	public String readFile() {
		String original = null;
		int n=-1;
		char[] a = new char[100];
		try {
			File file = new File("F:\\chang.txt");//文件所在地址
			InputStream fli = new FileInputStream(file);
			InputStreamReader in = new InputStreamReader(fli, "GBK");
		while((n=in.read(a,0,100))!=-1) {
		String s = new String(a,0,n);
		this.n=n;
		if(original!=null)
		original = original+s;
		else original=s;
		}
		
        in.close();
      	}
		catch (IOException e) {
			System.out.println("File read erroe:"+e);
		}
		return original;
	}
	public boolean outFile(String a) {
		byte [] b = a.getBytes();
		try {
			File file = new File("F:\\长恨歌.txt");//成功导入后的存储地址
			OutputStream out = new FileOutputStream(file,true);
			
            out.write(b);
            out.flush();
            out.close();
           
		}
		catch (IOException e) {
			System.out.println("File read erroe:"+e);
		}
		 return true;
		}
	
}
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

``` 
## 一、实验内容<br/>
在某课上,学生要提交实验结果，该结果存储在一个文本文件A中。<br/>
文件A包括两部分内容：<br/>
一是学生的基本信息；<br/>
二是学生处理后的作业信息，该作业的业务逻辑内容是：利用已学的字符串处理知识编程完成《长恨歌》古诗的整理对齐工作，写出功能方法，实现如下功能：<br/>
1.每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”<br/>
2.允许提供输入参数，统计古诗中某个字或词出现的次数<br/>
3.输入的文本来源于文本文件B读取，把处理好的结果写入到文本文件A<br/>
4.考虑操作中可能出现的异常，在程序中设计异常处理程序<br/>
输入：汉皇重色思倾国御宇多年求不得杨家有女初长成养在深闺人未识天生丽质难自弃一朝选在君王侧回眸一笑百媚生六宫粉黛无颜色春寒赐浴华清池温泉水滑洗凝脂侍儿扶起娇无力始是新承恩泽时云鬓花颜金步摇芙蓉帐暖度春宵春宵苦短日高起从此君王不早朝承欢侍宴无闲暇春从春游夜专夜后宫佳丽三千人三千宠爱在一身金屋妆成娇侍夜玉楼宴罢醉和春姊妹弟兄皆列士可怜光采生门户遂令天下父母心不重生男重生女骊宫高处入青云仙乐风飘处处闻缓歌慢舞凝丝竹尽日君王看不足渔阳鼙鼓动地来惊破霓裳羽衣曲九重城阙烟尘生千乘万骑西南行<未完，待续><br/>
输出：<br/>
汉皇重色思倾国，御宇多年求不得。<br/>
杨家有女初长成，养在深闺人未识。<br/>
天生丽质难自弃，一朝选在君王侧。<br/>
回眸一笑百媚生，六宫粉黛无颜色。<br/>
春寒赐浴华清池，温泉水滑洗凝脂。<br/>
侍儿扶起娇无力，始是新承恩泽时。<br/>
云鬓花颜金步摇，芙蓉帐暖度春宵。<br/>
春宵苦短日高起，从此君王不早朝。<br/>
…………<br/>
## 二、实验要求<br/>
1.设计学生类（可利用之前的）；<br/>
2.采用交互式方式实例化某学生；<br/>
3.设计程序完成上述的业务逻辑处理，并且把“古诗处理后的输出”结果存储到学生基本信息所在的文本文件A中。<br/>
## 三、实验目的<br/>
1、掌握字符串String及其方法的使用<br/>
2、掌握文件的读取/写入方法<br/>
3、掌握异常处理结构<br/>
## 四、核心代码<br/>
``` 
	try {
			File file = new File("F:\\chang.txt");//文件所在地址
			InputStream fli = new FileInputStream(file);
			InputStreamReader in = new InputStreamReader(fli, "GBK");
		while((n=in.read(a,0,100))!=-1) {
		String s = new String(a,0,n);
		this.n=n;
		if(original!=null)
		original = original+s;
		else original=s;
		}
		
        in.close();
      	}
		catch (IOException e) {
			System.out.println("File read erroe:"+e);
		}
		return original;
	}
``` 
## 五、实验结果<br/>
个人信息：<br/>
姓名 性别 年龄 学号<br/>
马成彧   女    20    2019311530<br/>
信息导入成功！<br/>
作业导入成功！<br/>
![Image text](https://github.com/MCY922/Java-4/blob/main/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20201209184717.png?raw=true)
## 六、实验感想<br/>
本次是java的最后一次实验，综合运用到了前面所学的知识也是对之前所学知识的一个巩固，但重点是去掌握一些新的东西，例如文件的读取和异常处理，在实验中新建文件的目录这里很容易出错，在程序中如果将文件的返回目录的路径写不对的话，程序不会出现报错但是在运行时会出现错误，会找不到新建的文件。通过学习java去体会面向对象编程语言与c语言区别，它们在表达式和语句上也有一定的相似之处，课程的结束不是学习的结束,对于java我还有很多需要去深入学习的地方，应该继续去探索并深入学习，并且要经常进行编程练习提高自己写代码的思路以及处理一个问题的能力。<br/>
