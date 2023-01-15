//importação de pacote
package model;

//Classe que representa a tabela produto e seus campos do banco de dados
public class Produto {

    private String nome;
    private String preco;
    private String quantidade;
    private String unidadeMedida;
    private int idUnidadeMedia;

    //Função que retorna informação do atributo da classe baseado-se na escolha do usuario no menuInsercao da Classe Menu
    public String getItem(String numero){
        if (numero.contentEquals("1")) {
            return this.getNome();
        }
        if (numero.contentEquals("2")) {
            return this.getPreco();
        }
        if (numero.contentEquals("3")) {
            return this.getQuantidade();
        }
        if (numero.contentEquals("4")) {
            return this.getUnidadeMedida();
        } else{
            return "Número inválido!";
        }
    }

    //Função para inserir a nova informação no atributo da classe baseado-se na escolha do usuario no menuInsercao da Classe Menu
    public void setItem(String numero, String novainformacao){
        if (numero.contentEquals("1")) {
            this.setNome(novainformacao);
        }
        if (numero.contentEquals("2")) {
            this.setPreco(novainformacao);
        }
        if (numero.contentEquals("3")) {
            this.setQuantidade(novainformacao);
        }
        if (numero.contentEquals("4")) {
            this.setUnidadeMedida(novainformacao);
        }
    }

    //Função que representa a classe em String
    public String toString() {
        return "Nome: " +  this.getNome() + " Preço: " + this.getPreco() + " Quantidade: " + this.getQuantidade() + " " + this.getUnidadeMedida();
        }

    // Getters e Setters
    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return String return the preco
     */
    public String getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(String preco) {
        this.preco = preco;
    }

    /**
     * @return String return the quantidade
     */
    public String getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return String return the unidadeMedida
     */
    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    /**
     * @param unidadeMedida the unidadeMedida to set
     */
    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    /**
     * @return int return the idUnidadeMedia
     */
    public int getIdUnidadeMedia() {
        return idUnidadeMedia;
    }

    /**
     * @param idUnidadeMedia the idUnidadeMedia to set
     */
    public void setIdUnidadeMedia(int idUnidadeMedia) {
        this.idUnidadeMedia = idUnidadeMedia;
    }

}
