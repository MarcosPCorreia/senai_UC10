package repo;

import db.ConexaoDB;
import model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProduto {
    private ConexaoDB conexaoDB;
    private Connection conection;

    public  UpdateProduto(){
        this.conexaoDB = new ConexaoDB();
        this.conection = this.conexaoDB.getConexao();
    }

    public Produto atualizarProduto(Produto produto){
        String sql = "UPDATE produto p INNER JOIN unidademedida un ON p.idUnidadeMedida = un.idUnidadeMedida SET p.nome = ?, p.preco = ?, p.quantidade = ?, un.unidadeMedida = ? WHERE p.nome = ? ";
        System.out.println("\nProduto parametros: ");
        System.out.println(produto.getNome());
        System.out.println(produto.getPreco());
        System.out.println(produto.getQuantidade());
        System.out.println(produto.getUnidadeMedida());
        try {
            PreparedStatement stmt = this.conection.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getPreco());
            stmt.setString(3, produto.getQuantidade());
            stmt.setString(4, produto.getUnidadeMedida());
            stmt.setString(5, produto.getNome());
            stmt.execute();
            System.out.println("\nDados alterados com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o produto: " + e.getMessage());
        }
        return produto;

    }
    
}
