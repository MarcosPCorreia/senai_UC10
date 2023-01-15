//Importação dos pacotes
package db;
import java.sql.*;

// Classe responsavel pela conexão com banco de dados
public class ConexaoDB {

    // Construtor
    public ConexaoDB(){}

    // Informações do driver de conexão, endereço banco de dados, porta, database
    static final String DATABASE_URL = "jdbc:mysql://localhost:3307/coma_bem";

    // Função que retorna a conexão
    public Connection getConexao() {
        try{
            // Estabelece a conexao com o banco de dados
            Connection connection = DriverManager.getConnection(DATABASE_URL, "root", "yg65wxez@Root");
            return connection;
        }catch (SQLException se){
            se.printStackTrace();
        }
        return null;
    }
    
}
