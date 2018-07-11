import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCConnection {
	
	public static void main(String args[]){

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url="jdbc:mysql://localhost/atdibasic";
			String username="root";
			String password="";

/*			Connection con=(Connection) DriverManager.getConnection(url,username,password);
			System.out.println("Connection: = "+con);
			Statement stmt=con.createStatement(); 
			ResultSet rs = stmt.executeQuery("Select * from actions");
			while(rs.next()){
				System.out.println(rs.getString("actionName"));
			}
			*/
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static final String CONNECTION = "jdbc:mysql://localhost/testdb";
    
    public static String getById(int id) throws SQLException {
        String query = "SELECT * FROM Foo WHERE Id = ?";
        Connection connection = DriverManager.getConnection(CONNECTION);
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        resultSet.next();
        
        String result = resultSet.getString(0);
        
        resultSet.close();
        preparedStatement.close();
        connection.close();
        
        return result;
    }

}
