// Importação dos pacotes
package model;
import repo.DeleteProduto;
import repo.InsertProduto;
import repo.SelectProduto;
import repo.UpdateProduto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Menu {
    // Instancias das Classes
    Produto produto = new Produto();
    ArrayList<Produto> produtos = new ArrayList<>();
    SelectProduto selectProduto = new SelectProduto();
    InsertProduto insertProduto = new InsertProduto();
    DeleteProduto deleteProduto = new DeleteProduto();
    UpdateProduto updateProduto = new UpdateProduto();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    //Classes Menu Principal responsavel por interagir com as escolhas do usuario
    public void menuPrincipal() throws IOException, InterruptedException{
        
        System.out.println("----------- Escolha a função de deseja utilizar ------------------\n");
        System.out.println("1 - Cadastrar novo Produto");
        System.out.println("2 - Consultar um Produto");
        System.out.println("3 - Alterar informações de um Produto");
        System.out.println("4 - Excluir um Produto");
        System.out.println("Qualquer tecla - Fechar o Sistema");
        String escolha = br.readLine();
        menuEscolha(escolha);
    }
    
    // Menu Escolha responsavel por chamar as funções de escolhas do usuario
    public void menuEscolha(String escolha) throws IOException, InterruptedException{
        switch (escolha) {
            case "0":
            menuSecundario();
            break;
            case "1":
            menuInsercao();
            break;
            
            case "2":
            menuConsulta();
            break;
            
            case "3":
            menuAlteracao();
            break;
            
            case "4":
            menuExclusao();
            break;
            
            default:
            fecharTela();
            break;
        } 
    }

    // Função para limpar o terminal
    public void limpaTela() throws InterruptedException, IOException{
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    }

    // Fecha a tela para sair do sistema
    public void fecharTela() throws InterruptedException, IOException{
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("exit");
    }
    
    // Limpa a tela e chama o Menu Principal ao finalizar um processo completo de escolha
    public void menuSecundario() throws IOException, InterruptedException{
        limpaTela();
        System.out.println("-----------   Bem vindo ao Sistema Datamobile   ------------------\n");
        menuPrincipal();;
    }
    
    // Menu responsavel para realizar as consulta no banco de dados, tanto de um produto quanto de varios produtos
    public void menuConsulta() throws IOException, InterruptedException{
        limpaTela();
        System.out.println("Digite o nome do produto que deseja consultar: \n");
        String nomeProduto = br.readLine();
        System.out.println("Produtos encontrados na pesquisa:\n ");
        produtos = selectProduto.getPesquisa(nomeProduto);
        if (produtos.isEmpty()) {
            System.out.printf("O Produto %s não foi entrado na pesquisa\n", nomeProduto);
            System.out.println("\nDeseja realizar uma nova pesquisa?");
            System.out.println("\n2-Sim  0-Não");
            String decisao = br.readLine();
            menuEscolha(decisao);
        }
        System.out.println("\nDeseja realizar uma nova pesquisa?");
        System.out.println("\n2-Sim  0-Não");
        String decisao = br.readLine();
        menuEscolha(decisao);
    }
    
    //Menu responsavel para realizar o cadastro e a inserção do produto no banco de dados
    public void menuInsercao() throws IOException, InterruptedException{
        InsertProduto insertProduto = new InsertProduto();
        System.out.println("Cadastre o produto para Inserir:\n");
        System.out.println("Cadastre o nome do produto");
        String nome = br.readLine();
        produto.setNome(nome);
        System.out.println("Cadastre o preço do produto");
        String preco = br.readLine();
        produto.setPreco(preco);
        System.out.println("Cadastre quantidade do produto");
        String quantidade = br.readLine();
        produto.setQuantidade(quantidade);
        System.out.println("Cadastre a unidade de medida do produto");
        String unidademedida = br.readLine();
        unidademedida = unidademedida.substring(0,1).toUpperCase() + unidademedida.substring(1).toLowerCase();
        produto.setUnidadeMedida(unidademedida);
        System.out.println(produto);
        System.out.println("Confirma o cadastro do produto 1-Sim  2-Não  Qualquer tecla: SAIR DO SISTEMA:");
        String decisao = br.readLine();
        if (decisao.contentEquals("1")) {
            limpaTela();
            insertProduto.inserirProduto(produto);
        }else if (decisao.contentEquals("2")){
            menuSecundario();
        }else{
            menuEscolha("S");
        }
        System.out.println("\nDeseja cadastrar um novo produto?");
        System.out.println("1-Sim  2-Não  Qualquer tecla: SAIR DO SISTEMA:");
        String escolhaCadastrar = br.readLine();
        if (escolhaCadastrar.contentEquals("1")) {
            limpaTela();
            menuEscolha(escolhaCadastrar);
        }else if (escolhaCadastrar.contentEquals("2")){
            menuSecundario();
        }else{
            menuEscolha("S");
        }
    }

    // Menu responsavel por alterações do produto no banco de dados
    public void menuAlteracao()throws IOException, InterruptedException{
        System.out.println("Escolha o produto para Alterar:");
        String nomeProduto = br.readLine();
        System.out.println("Produtos encontrados na pesquisa:\n ");
        produtos = selectProduto.getPesquisa(nomeProduto);
        String nomeAntigo = produtos.get(0).getNome();
        if (produtos.size() > 1) {
            System.out.println("Escolha um dos produtos para alterar:");
            String respostaEscolha = br.readLine();
            limpaTela();
            produto = selectProduto.getProduto(respostaEscolha);
            System.out.println("\nQual informação deseja alterar?\n");
            System.out.println("1-Nome  2-Preço  3-Quantidade  4-Unidade de Medida");
            String respostaInformacao = br.readLine();
            System.out.println("A informacao atual é: " + produtos.get(0).getItem(respostaInformacao));
            System.out.println("\nDigite a nova informacao: ");
            String novaInformacao = br.readLine(); 
            produtos.get(0).setItem(respostaInformacao, novaInformacao);
            produto = updateProduto.atualizarProduto(produtos.get(0), nomeAntigo);
            System.out.println(produto);
            System.out.println("Deseja realizar alteração em outro produto  1-Sim  2-Não Qualquer tecla: SAIR DO SISTEMA:");
            String decisao = br.readLine();
            if (decisao.contentEquals("1")) {
                limpaTela();
                menuEscolha("3");
            }else if (decisao.contentEquals("2")){
                menuSecundario();
            }else{
                menuEscolha("S");
            }
        }else{
            System.out.println("\nQual informação deseja alterar?\n");
            System.out.println("1-Nome  2-Preço  3-Quantidade  4-Unidade de Medida");
            String respostaInformacao = br.readLine();
            System.out.printf("Informação Nome: %s \n", produtos.get(0).getNome());
            System.out.println("A informacao atual é: " + produtos.get(0).getItem(respostaInformacao));
            System.out.println("\nDigite a nova informacao: ");
            String novaInformacao = br.readLine();
            produtos.get(0).setItem(respostaInformacao, novaInformacao);
            produto = updateProduto.atualizarProduto(produtos.get(0), nomeAntigo);
            System.out.println(produto);
            System.out.println("Deseja realizar alteração em outro produto  1-Sim  2-Não Qualquer tecla: SAIR DO SISTEMA:");
            String decisao = br.readLine();
            if (decisao.contentEquals("1")) {
                limpaTela();
                menuEscolha("3");
            }else if (decisao.contentEquals("2")){
                menuSecundario();
            }else{
                menuEscolha("S");
            }
        }
    }

    // Menu responsavel por excluir os produtos no banco de dados
    public void menuExclusao()throws IOException, InterruptedException{
        System.out.println("Escolha um produto para Excluir:");
        String nomeProduto = br.readLine();
        System.out.println("Produtos encontrados na pesquisa:\n ");
        produtos = selectProduto.getPesquisa(nomeProduto);
        if (produtos.size() > 1) {
            System.out.println("\nEscolha um dos produtos para Excluir:");
            String nomeProdutoExcluir = br.readLine();
            limpaTela();
            produtos = selectProduto.getPesquisa(nomeProdutoExcluir);
            System.out.println("\nConfirma a exclusão do produto " + produtos.get(0).getNome() + "?\n");
            System.out.println("1-Sim  2-Não Qualquer tecla: SAIR DO SISTEMA:");
            String decisao = br.readLine();
            if (decisao.contentEquals("1")) {
                limpaTela();
                deleteProduto.deleteProduto(nomeProdutoExcluir);
                System.out.println("\nDeseja excluir outro produto?");
                System.out.println("\n0-Menu Principal  4-Sim  Qualquer tecla: SAIR DO SISTEMA:");
                String novaDecisao = br.readLine();
                if (novaDecisao.contentEquals("0") || novaDecisao.contentEquals("4")) {
                    limpaTela();
                    menuEscolha(novaDecisao);
                } else {
                    menuSecundario();
                }
            }else if (decisao.contentEquals("2")){
                menuSecundario();
            }else{
                menuEscolha("S");
            }
            }
        else{
            System.out.println("\nConfirma a exclusão do produto " + produtos.get(0).getNome() + "?\n");
            System.out.println("1-Sim  2-Não Qualquer tecla: SAIR DO SISTEMA:");
            String decisao = br.readLine();
        if (decisao.contentEquals("1")) {
            deleteProduto.deleteProduto(produtos.get(0).getNome());
            System.out.println("\nDeseja excluir outro produto?");
            System.out.println("\n0-Menu Principal  4-Sim  Qualquer tecla: SAIR DO SISTEMA:");
            String novaDecisao = br.readLine();
            if (novaDecisao.contentEquals("0") || novaDecisao.contentEquals("4")) {
                limpaTela();
                menuEscolha(novaDecisao);
            } else {
                menuSecundario();
            }
            String escolhaExcluir = br.readLine();
            menuEscolha(escolhaExcluir);
        }else if (decisao.contentEquals("2")){
            menuSecundario();
        }else{
            menuSecundario();
        }
    }
}
      
}
