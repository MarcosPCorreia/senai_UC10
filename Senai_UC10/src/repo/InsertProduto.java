package repo;

import db.ConexaoDB;
import model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertProduto {
    private ConexaoDB conexaoDB;
    private Connection conection;

    public InsertProduto(){
        this.conexaoDB = new ConexaoDB();
        this.conection = this.conexaoDB.getConexao();
    }
    
    public void inserirProduto(Produto produto) {
        String sql ="INSERT INTO produto (nome, preco, quantidade, idUnidadeMedida) VALUES(?, ?, ?, (SELECT idUnidadeMedida  FROM unidademedida WHERE unidademedida = ?))";
        try {
            PreparedStatement stmt = this.conection.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getPreco());
            stmt.setString(3, produto.getQuantidade());
            stmt.setString(4, produto.getUnidadeMedida());
            stmt.execute();
            System.out.println("\nDados cadastrados com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
        }
    }
}
