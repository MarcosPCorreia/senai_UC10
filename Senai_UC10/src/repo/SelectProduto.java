package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.ConexaoDB;
import model.Produto;

public class SelectProduto {
    private ConexaoDB conexaoDB;
    private Connection conection;

    public SelectProduto(){
        this.conexaoDB = new ConexaoDB();
        this.conection = this.conexaoDB.getConexao();
    }
    
    public Produto getProduto(String nomeProduto) {
        try {
            String sql ="SELECT p.nome, p.preco, p.quantidade, un.unidadeMedida FROM produto AS p INNER JOIN unidademedida AS un WHERE nome = ? AND un.idUnidadeMedida = p.idUnidadeMedida";
            PreparedStatement stmt = this.conection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.setString(1, nomeProduto);
            ResultSet resultado = stmt.executeQuery();
            Produto produto = new Produto();
            resultado.first();
            // System.out.println("Nome: " +resultado.getString(1)+" Preço: "+resultado.getString(2)+" Quantidade: "+resultado.getString(3)+" "+resultado.getString(4));
            produto.setNome(nomeProduto);
            produto.setPreco(resultado.getString(2));
            produto.setQuantidade(resultado.getString(3));
            produto.setUnidadeMedida(resultado.getString(4));
            return produto; 
        } catch (Exception e) {
            System.out.println("Erro ao consultar o produto: " + e.getMessage());
        }
        return null; 
    }

    public ArrayList<Produto> getPesquisa(String string){
        String sql = "SELECT p.nome, p.preco, p.quantidade, un.unidadeMedida FROM produto AS p INNER JOIN unidademedida AS un WHERE nome LIKE '%"+ string +"%' AND un.idUnidadeMedida = p.idUnidadeMedida";
        try {
            Statement stmt = this.conection.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);
            ArrayList<Produto> produtos = new ArrayList<>();
            while(resultado.next()){
                Produto produto = new Produto();
                produto.setNome(resultado.getString(1));
                produto.setPreco(resultado.getString(2));
                produto.setQuantidade(resultado.getString(3));
                produto.setUnidadeMedida(resultado.getString(4));
                produtos.add(produto);
                System.out.println("Nome: " +resultado.getString(1)+" Preço: "+resultado.getString(2)+" Quantidade: "+resultado.getString(3)+" "+resultado.getString(4));
                System.out.println("------------------------------------------------------------");
            }
            // System.out.println("Ultimo produto: " + produtos.get((produtos.size()-1)));
            return produtos; 
        } catch (Exception e) {
            System.out.println("Erro ao consultar o produto: " + e.getMessage());
        }
        return null;
    }
}
