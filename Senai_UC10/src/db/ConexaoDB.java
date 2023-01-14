package db;
import java.sql.*;

public class ConexaoDB {

    public ConexaoDB(){}

    static final String DATABASE_URL = "jdbc:mysql://localhost:3307/coma_bem";

    public Connection getConexao() {
        try{
            // Estabelece a conexao com o banco
            Connection connection = DriverManager.getConnection(DATABASE_URL, "root", "yg65wxez@Root");
            return connection;
        }catch (SQLException se){
            se.printStackTrace();
        }
        return null;
    }
    
}
