package main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.sql.*;

public class DbFunctions {
    public static String APP_NAME = "yegnapharma";

    static Connection conn = null;
//    static public String createEmployee = """
//
//            CREATE TABLE Employee (
//              User_ID int PRIMARY KEY,
//              Employee_Role varchar(20),
//              First_Name VARCHAR(50) NOT NULL,
//              Last_Name VARCHAR(50) NOT NULL,
//              Phone_Number int,
//              Date_Of_Birth DATE,
//              Salary DECIMAL(8, 2),
//              Company_ID int,
//              FOREIGN KEY (Company_ID) REFERENCES Company(Company_ID),
//              Is_Fired bool,
//              Password varchar(20)
//            );
//             """;
//
//    static public String createDrugs = """
//            CREATE TABLE Drugs (
//              Drug_Code INT PRIMARY KEY,
//              Drug_Name VARCHAR(50) NOT NULL,
//              Drug_Type VARCHAR(50) NOT NULL,
//              Manufacturer VARCHAR(50) NOT NULL,
//              Quantity INT ,
//              Price DECIMAL(8, 2),
//              Drug_Dose VARCHAR(50),
//              Drug_Production_Date DATE,
//              Is_Deleted varchar(10),
//              Minimum_Quantity int
//            );
//            """;
//    static public String createCompany = """
//            CREATE TABLE Company (
//              Company_ID INT PRIMARY KEY,
//              Company_Name VARCHAR(50) NOT NULL,
//              Address VARCHAR(100) NOT NULL,
//              Phone_Number VARCHAR(20),
//              Email_Address VARCHAR(50)
//            );
//            """;
//    static public String createEmployeeDrugs = """
//
//            CREATE TABLE Employee_Drugs (
//              Employee_ID INT,
//              Drug_Code INT,
//              Order_ID INT,
//              Action_Performed varchar(10),
//              quantity int,
//              PRIMARY KEY (Order_ID),
//              FOREIGN KEY (Employee_ID) REFERENCES Employee(User_ID),
//              FOREIGN KEY (Drug_Code) REFERENCES Drugs(Drug_Code),
//              Is_Deleted varchar(10),
//              Order_Date Date
//            );
//            """;
//    static public String createExpiry = """
//
//             CREATE TABLE Expiry (
//              Product_Code INT PRIMARY KEY,
//              Expiration_Date DATE,
//              FOREIGN KEY (Product_Code) REFERENCES Drugs(Drug_Code)
//            );
//            """;
//    private final String defaultEmp = """
//            INSERT OR IGNORE INTO Employee (User_ID, Employee_Role, First_Name, Last_Name, Phone_Number, Date_Of_Birth, Salary, Company_ID, Is_Fired, Password)\s
//            VALUES (1, 'Manager', 'John', 'Doe', 1234567890, '1980-01-01', 50000.00, 1, false, 'default');
//
//            """;
static public String createEmployee = """
CREATE TABLE IF NOT EXISTS Employee (
    User_ID INTEGER PRIMARY KEY ,
    Employee_Role VARCHAR(20),
    First_Name VARCHAR(50) NOT NULL,
    Last_Name VARCHAR(50) NOT NULL,
    Phone_Number VARCHAR(15),  -- Changed to VARCHAR to accommodate different phone number formats
    Date_Of_Birth DATE,
    Salary DECIMAL(10, 2),
    Company_ID INTEGER,
    Is_Fired INTEGER,  -- Use INTEGER to represent boolean values
    Password VARCHAR(50), -- Increased size to allow longer passwords
    FOREIGN KEY (Company_ID) REFERENCES Company(Company_ID)
);
""";

    static public String createDrugs = """
CREATE TABLE IF NOT EXISTS Drugs (
    Drug_Code INTEGER PRIMARY KEY,
    Drug_Name VARCHAR(50) NOT NULL,
    Drug_Type VARCHAR(50) NOT NULL,
    Manufacturer VARCHAR(50) NOT NULL,
    Quantity INTEGER,
    Price DECIMAL(10, 2),
    Drug_Dose VARCHAR(50),
    Drug_Production_Date DATE,
    Is_Deleted INTEGER,  -- Use INTEGER to represent boolean values
    Minimum_Quantity INTEGER
);
""";

    static public String createCompany = """
CREATE TABLE IF NOT EXISTS Company (
    Company_ID INTEGER PRIMARY KEY,
    Company_Name VARCHAR(50) NOT NULL,
    Address VARCHAR(100) NOT NULL,
    Phone_Number VARCHAR(20),
    Email_Address VARCHAR(50)
);
""";

    static public String createEmployeeDrugs = """
CREATE TABLE IF NOT EXISTS Employee_Drugs (
    Employee_ID INTEGER,
    Drug_Code INTEGER,
    Order_ID INTEGER PRIMARY KEY,
    Action_Performed VARCHAR(20),
    Quantity INTEGER,
    Is_Deleted INTEGER,  -- Use INTEGER to represent boolean values
    Order_Date DATE,
    FOREIGN KEY (Employee_ID) REFERENCES Employee(User_ID),
    FOREIGN KEY (Drug_Code) REFERENCES Drugs(Drug_Code)
);
""";

    static public String createExpiry = """
CREATE TABLE IF NOT EXISTS Expiry (
    Product_Code INTEGER PRIMARY KEY,
    Expiration_Date DATE,
    FOREIGN KEY (Product_Code) REFERENCES Drugs(Drug_Code)
);
""";

    private final String defaultEmp = """
    INSERT OR IGNORE INTO Employee (User_ID, Employee_Role, First_Name, Last_Name, Phone_Number, Date_Of_Birth, Salary, Company_ID, Is_Fired, Password)
    VALUES (1, 'Owner', 'John', 'Doe', '1234567890', '1980-01-01', 50000.00, 1, 0, 'default');  -- Use 0 to represent false
    
    """;

    private final String defaultCompany = """
    INSERT OR IGNORE INTO Company (Company_ID, Company_Name, Address, Phone_Number, Email_Address)
    VALUES (1, 'Default Pharma', '123 Default St, Default City', '123-456-7890', 'contact@defaultpharma.com');
    """;


    public static ResultSet getData(String query) {
        try{
            Statement statement = conn.createStatement();
            System.out.println("in getData method, DbFunctions");
            System.out.println(statement);
            return statement.executeQuery(query);
        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }
    public static void executeUpdate(String query) {
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    public static Object[][] extractData(ResultSet data, int recordsPerPage){
        Object[][] records = new Object[recordsPerPage][];
        try{
            int numberOfAttributes = data.getMetaData().getColumnCount();
            for(int row = 0; row<recordsPerPage&&data.next(); row++){
                records[row] = new Object[numberOfAttributes];
                for(int column=0; column<numberOfAttributes; column++){
                    records[row][column] = data.getString(column + 1);
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return records;
    }
    public DbFunctions(String dbname, String user, String pass) {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/" + dbname, user, pass);

            getData(createCompany);
            getData(createEmployee);
            getData(createDrugs);
            getData(createEmployeeDrugs);
            getData(createExpiry);
            if (conn != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public DbFunctions() {
        System.out.println("In dbfunctions constructor");
        try{
            Class.forName("org.sqlite.JDBC");
            String url = get_url();
            conn = DriverManager.getConnection(url);
            conn.createStatement().execute("PRAGMA foreign_keys = ON;");
            Statement stmt = conn.createStatement();

            stmt.execute("PRAGMA foreign_keys = ON");
            // Check if enabled
            ResultSet rs = stmt.executeQuery("PRAGMA foreign_keys");
            while (rs.next()) {
                System.out.println("Foreign Keys Enabled: " + rs.getInt(1));
            }
            System.out.println("Connection to SQLite has been established.");
            System.out.println("creating company");
            executeUpdate(createCompany);
            System.out.println("creating employee");
            executeUpdate(createEmployee);
            System.out.println("creating drug");
            executeUpdate(createDrugs);
            System.out.println("creating emp-drug");
            executeUpdate(createEmployeeDrugs);
            System.out.println("creating expiry");
            executeUpdate(createExpiry);
            System.out.println("creating default comp");
            executeUpdate(defaultCompany);
            System.out.println("creating default emp");
            executeUpdate(defaultEmp);


        }catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static String get_url(){
        String dbDirectoryPath = getDataFolderPath();
        String dbFilePath = dbDirectoryPath + File.separator + "data.db";
        String url = "jdbc:sqlite:" + dbFilePath;
        return url;
    }
    public static String getDataFolderPath() {
        String appDataPath = System.getenv("APPDATA");
        if (appDataPath == null) {
            throw new RuntimeException("APPDATA environment variable is not set.");
        }
        String dbDirectoryPath = appDataPath + File.separator + APP_NAME;
        File dbDirectory = new File(dbDirectoryPath);
        if (!dbDirectory.exists()) {
            dbDirectory.mkdirs(); // Create the directory if it doesn't exist
        }
        return dbDirectoryPath;
    }

    public Connection getConn() {
        return conn;
    }

    public void createTable(Connection conn, String table_name){
        Statement statement;
        try{
//            String query="create table"+table_name+""

        }catch(Exception e){
            System.out.println("Table created");
        }
    }

    public static Object[] updateTable(JTable table, String query, int recordsPerPage){
        ResultSet data;
        Object[][] records;
        Object[] columns;
        try{
            data = DbFunctions.getData(query);
            columns = new Object[data.getMetaData().getColumnCount()];
            for(int i = 0; i<data.getMetaData().getColumnCount(); i++){
                columns[i] = data.getMetaData().getColumnName(i+1);
            }
            records = DbFunctions.extractData(data, recordsPerPage);
            table.setModel(new DefaultTableModel(records, columns));
            return columns;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public void createTablesInCase(){
        String query = """
                
                """;
    }


    public static void insertData(String query){
        try{
            Statement statement = conn.createStatement();
            System.out.println(statement);
            statement.executeQuery(query);
        }catch (SQLException e){
            System.out.println(e);
        }
        return;
    }

}
