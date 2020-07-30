import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Student{
	private int id;
	private String name;
	private byte[] adress;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getAdress() {
		return adress;
	}
	public void setAdress(byte[] adress) {
		this.adress = adress;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", adress="
				+ Arrays.toString(adress) + "]";
	}
	
}

public class Student1 {
	public static void main(String[] args){
		String s= "hello vani r u feeling bad";
		String s1= "dont worry";
		
		byte[] b = s.getBytes();
		Student stud = new Student();
		stud.setAdress(b);
		stud.setId(10);
		stud.setName("vani");
		
		Student stud1 = new Student();
		byte[] p= s1.getBytes();
		stud1.setAdress(p);
		stud1.setId(11);
		stud1.setName("dharani");
		List<Student> list = new ArrayList<Student>();
		list.add(stud);
		list.add(stud1);
		for(Student f :list){
			System.out.println(f.getId());
			byte[] b1=f.getAdress();
			String m= new String(b1);
			System.out.println(m);
		}
		
//		byte[] c= stud.getAdress();
//		String q= new String(c);
//		//System.out.println(stud.getAdress().Arrays.toString());
//		System.out.println(q);
//		System.out.println(list.get(0).getId());
//		System.out.println(list.get(0).getAdress());
		
		
	}

}
