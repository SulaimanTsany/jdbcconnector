import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnector {

    private Connection connection;
    private String databaseName ;
    private String username = "root";
    private String password = "13";
    private String driver = "com.mysql.jdbc.Driver";
    private String url;
        
    public MySQLConnector (String databaseName) throws ClassNotFoundException{
        this.databaseName = databaseName;
        setUrl();
        makeConnection();
    }
    
    public MySQLConnector (String url, String databaseName, String username, String password) throws ClassNotFoundException{
        this.url = url;
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;
        makeConnection();
    }

    public MySQLConnector (String databaseName, String username, String password) throws ClassNotFoundException{
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;
        setUrl();
        makeConnection();
    }

    public void setDatabaseName (String databaseName) {
        this.databaseName = databaseName;
    }
    public void setUsername (String username) {
        this.username = username;
    }
    public void setPassword (String password) {
        this.password = password;
    }
    public void setDriver (String driver) {
        this.driver = driver;
    }
    public void setUrl (String url) {
        this.url = url;
    }
    public Connection getConnection () {
        return connection;
    }
    public String getDatabasename() {
    	return databaseName;
    }
    public void setUrl() {
    	url = "jdbc:mysql://localhost:3306/"+ databaseName;
    }

    public void makeConnection () throws ClassNotFoundException {
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void closeConnection() throws SQLException {
    	connection.close();
    }
    /*
    public static void main (String[] args) throws ClassNotFoundException {
        MySqlConnector mySqlConnector = new MySqlConnector("rpl");
        mySqlConnector.makeConnection();
        Connection newCon = mySqlConnector.getConnection();
    }
    */
}
