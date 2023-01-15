//Importação dos pacotes
package repo;
import db.ConexaoDB;
import model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;

// Classe para realizar Alterações dos produtos no banco de Dados
public class UpdateProduto {
    private ConexaoDB conexaoDB;
    private Connection conection;

    // Construtor
    public  UpdateProduto(){
        this.conexaoDB = new ConexaoDB();
        this.conection = this.conexaoDB.getConexao();
    }

    // Função para realizar atualizações de um produto no banco de Dados
    public Produto atualizarProduto(Produto produto, String nomeProduto){
        String sql = "UPDATE produto p INNER JOIN unidademedida un ON p.idUnidadeMedida = un.idUnidadeMedida SET p.nome = ?, p.preco = ?, p.quantidade = ?, un.unidadeMedida = ? WHERE p.nome = ?";
        try {
            PreparedStatement stmt = this.conection.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getPreco());
            stmt.setString(3, produto.getQuantidade());
            stmt.setString(4, produto.getUnidadeMedida());
            stmt.setString(5, nomeProduto);
            stmt.execute();
            System.out.println("\nDados alterados com sucesso!\n");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o produto: " + e.getMessage());
        }
        return produto;
    }
}
