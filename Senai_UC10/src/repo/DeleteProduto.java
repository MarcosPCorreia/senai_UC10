package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.ConexaoDB;
import model.Produto;

public class DeleteProduto {
    private ConexaoDB conexaoDB;
    private Connection conection;

    public DeleteProduto(){
        this.conexaoDB = new ConexaoDB();
        this.conection = this.conexaoDB.getConexao();
    }

    public Produto deleteProduto(String produto){
        String sql = "DELETE FROM produto WHERE nome = ?";
        try {
            PreparedStatement stmt = this.conection.prepareStatement(sql);
            stmt.setString(1, produto);
            stmt.execute();
            System.out.println("\nDados excluídos com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao excluir o produto: " + e.getMessage());
        }
        return null;
    }

    
}
