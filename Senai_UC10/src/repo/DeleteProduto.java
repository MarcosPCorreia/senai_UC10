// importação dos pacotes
package repo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import db.ConexaoDB;
import model.Produto;

// Classe para realizar Exclusão de produtos no banco de Dados
public class DeleteProduto {
    private ConexaoDB conexaoDB;
    private Connection conection;

    // Construtor
    public DeleteProduto(){
        this.conexaoDB = new ConexaoDB();
        this.conection = this.conexaoDB.getConexao();
    }

    // Função para realizar Exclusão de um produto no banco de Dados
    public Produto deleteProduto(String nomeProduto){
        String sql = "DELETE FROM produto WHERE nome = ?";
        try {
            PreparedStatement stmt = this.conection.prepareStatement(sql);
            stmt.setString(1, nomeProduto);
            stmt.execute();
            System.out.println("\nDados excluídos com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao excluir o produto: " + e.getMessage());
        }
        return null;
    }
}
