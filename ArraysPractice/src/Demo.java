import java.util.Arrays;
import java.util.Scanner;

class Demo {

	  public static String FindIntersection(String[] strArr) {
	    
	    return "first element is"+strArr[0];
	  }

	 public static void main (String[] args) {  
		       
//		    Scanner s = new Scanner(System.in);
//		   String s9=  Demo.FindIntersection(t);
		   int x=0;
		  x+=10;
		  System.out.println(x);
		    String w="hello vani";
		    String z="hello vani";
		    if(w.equalsIgnoreCase("hello vani")){
		    	System.out.println("equal");
		    }
		    String[] s1 = {"1","3","4","7","13"};
		String[] s2={"1","2","4","13","15"};
		String[] t={"","",""};int k=0;
		 
		for(int i=0;i<s1.length;i++){
			for(int j=0;j<s2.length;j++){
				if(s1[i]==s2[j]){
					 t[k]= s1[i];
					 k++;
					
				}
			}
		}
		
		String n = new String(t.toString());
		System.out.println(n);
		String str=Arrays.toString(t);
		System.out.println(str);;
		//System.out.println("first element is"+str[0]);
		Demo.FindIntersection(t);
		//System.out.print(FindIntersection(s.nextLine())); 
		
	 }
}
