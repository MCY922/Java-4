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