import model.Produto;
import repo.DeleteProduto;
import repo.InsertProduto;
import repo.SelectProduto;
import repo.UpdateProduto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.mysql.cj.util.StringUtils;

public class Main {

    public static void main(String[] args) throws IOException {
        Produto produto = new Produto();
        InsertProduto insertProduto = new InsertProduto();
        DeleteProduto deleteProduto = new DeleteProduto();
        SelectProduto selectProduto = new SelectProduto();
        UpdateProduto updateProduto = new UpdateProduto();
        ArrayList<Produto> produtos = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        System.out.println("Cadastre o produto para Inserir:\n");
        System.out.println("Cadastre o nome do produto");
        String nome = br.readLine();
        produto.setNome(nome);
        System.out.println("Cadastre o preço do produto");
        String preco = br.readLine();
        produto.setPreco(preco);
        System.out.println("Cadastre  quantidade do produto");
        String quantidade = br.readLine();
        produto.setQuantidade(quantidade);
        System.out.println("Cadastre a unidade de medida do produto");
        String unidademedida = br.readLine();
        unidademedida = unidademedida.substring(0,1).toUpperCase() + unidademedida.substring(1).toLowerCase();
        produto.setUnidadeMedida(unidademedida);
        System.out.println(produto);
        System.out.println("Confima o cadastro do produto 1-Sim  2-Não:");
        String decisao = br.readLine();
        if (decisao.contentEquals("1")) {
            insertProduto.inserirProduto(produto);;
        }else if (decisao.contentEquals("2")){
            return;
        }
        // System.out.println("Escolha o produto para Alterar:");
        // System.out.println("Escolha um dos produtos para Excluir:");
        // String nomeProduto = br.readLine();
        // System.out.println("Produtos encontrados na pesquisa:\n ");
        // produtos = selectProduto.getPesquisa(nomeProduto);
        //if (produtos.size() > 1) {
            // System.out.println("Escolha um dos produtos para alterar:");

            //--------------------Excluir------------------------------------
            // System.out.println("Escolha um dos produtos para Excluir:");
            // String nomeProdutoExcluir = br.readLine();
            // System.out.println("Confirma a exclusão do produto " + nomeProdutoExcluir + "?\n");
            // System.out.println("1-Sim  2-Não");
            // String decisao = br.readLine();
            // if (decisao.contentEquals("1")) {
            //     deleteProduto.deleteProduto(nomeProdutoExcluir);
            // }else if (decisao.contentEquals("2")){
            //     return;
            // }
            //^^^^^^^^^^^^---------Excluir ------------------^^^^^^^^^^^^^^^^

            // produto = selectProduto.getProduto(respostaEscolha);
            // System.out.println("\nQual informação deseja alterar?\n");
            // System.out.println("1-Nome  2-Preço  3-Quantidade  4-Unidade de Medida");
            // String respostaInformacao = br.readLine();
            // System.out.println("A informacao atual é: " + produto.getItem(respostaInformacao));
            // System.out.println("\nDigite a nova informacao: ");
            // String novaInformacao = br.readLine();
            // produto.setItem(respostaInformacao, novaInformacao);
            // updateProduto.atualizarProduto(produto);
            // produto = selectProduto.getProduto(respostaEscolha);
            // System.out.println(produto);
        //}else{

             //--------------------Excluir------------------------------------
            // System.out.println("Escolha um dos produtos para Excluir:\n");
            // System.out.println("Confirma a exclusão do produto " + nomeProduto + "?\n");
            // System.out.println("1-Sim  2-Não");
            // String decisao = br.readLine();
            // if (decisao.contentEquals("1")) {
            //     deleteProduto.deleteProduto(nomeProduto);
            // }else if (decisao.contentEquals("2")){
            //     return;
            // }
            //^^^^^^^^^^^^---------Excluir ------------------^^^^^^^^^^^^^^^^

            // String respostaEscolha = br.readLine();
        //     System.out.println("\nQual informação deseja alterar?\n");
        //     System.out.println("1-Nome  2-Preço  3-Quantidade  4-Unidade de Medida");
        //     String respostaInformacao = br.readLine();
        //     System.out.println("A informacao atual é: " + produtos.get(0).getItem(respostaInformacao));
        //     System.out.println("\nDigite a nova informacao: ");
        //     String novaInformacao = br.readLine();
        //     produtos.get(0).setItem(respostaInformacao, novaInformacao);
        //     updateProduto.atualizarProduto(produtos.get(0));
        //     produto = selectProduto.getProduto(resposta);
        //     System.out.println(produto);
        //}

    }
}

