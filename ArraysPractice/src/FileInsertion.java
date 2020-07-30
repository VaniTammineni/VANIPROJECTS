
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FileInsertion {

	public static void main(String[] args) throws ClassNotFoundException {
		String url = "jdbc:oracle:thin:@10.167.80.193:1521:oracle";
		String username = "SASHI";
		String password = "sashi123";
		String path = "C:\\Users\\Vani\\Pictures\\Screenshots\\Screenshot (4).png";
        FileInputStream inputStream = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "insert into SASHI.fileInsert(customer_id,customer_name,file_content) values(?,?,?)";
			File file = new File(path);
			System.out.println(file.length());
			System.out.println(file.getAbsolutePath());
			/*
			 * byte[] inbytes = Files.readAllBytes(Paths.get(path)); 
			 * InputStream stream=new ByteArrayInputStream(inbytes); stream.read(inbytes);
			 * System.out.println("avail   able bytes:"+stream.available());
			 * 
			 * ps.setBinaryStream(3, stream, file.length());
			 */
			// FileReader fr=new FileReader(file);
			// ps.setCharacterStream(3, fr,(long) file.length());
			inputStream = new FileInputStream(file);
			  byte[] fileData=new byte[(int) file.length()]; 

	//	InputStream stream=new ByteArrayInputStream(fileData);
			
			  
			  
			  //DataInputStream stream=new DataInputStream(new FileInputStream(file)); 
			 // stream.readFully(fileData);
			  
			//  stream.close();
			 
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setString(2, "aaa");
			ps.setBinaryStream(3,inputStream,(long)file.length());
			//ps.setBlob(3, fis);
			 //ps.setBytes(3, fileData);
			int res = ps.executeUpdate();
		//	ps.executeUpdate();
			if (res > 0) {
				System.out.println("inserted");
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
