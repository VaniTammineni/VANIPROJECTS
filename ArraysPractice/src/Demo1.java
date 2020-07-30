import java.util.ArrayList;


public class Demo1 {

	public static void main(String[] args) {
		String s="hel1oo3ff";
		System.out.println(s.charAt(0));
		for(int i=0;i<s.length();i++){
			s.charAt(i);
			if(s.charAt(i)=='1' || s.charAt(i)=='3'){
				System.out.println(s.charAt(i));
			}
		}
		ArrayList al = new ArrayList();
		al.add(10);
		al.add(20);
		al.add(30);
		
		if(al.size()!=0){
			int i=0;
			System.out.println("element is"+al.get(0));
			i++;
		}
	}

}
