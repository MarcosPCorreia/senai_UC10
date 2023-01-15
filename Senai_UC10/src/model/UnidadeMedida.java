//Importação de pacotes
package model;

//Classe que representa a tabela unidademedida e seus campos do banco de dados
public class UnidadeMedida {
    private int idUnidadeMedida;
    private String unidadeMedida;


    // Getters e Setters
    /**
     * @return int return the idUnidadeMedida
     */
    public int getIdUnidadeMedida() {
        return idUnidadeMedida;
    }

    /**
     * @param idUnidadeMedida the idUnidadeMedida to set
     */
    public void setIdUnidadeMedida(int idUnidadeMedida) {
        this.idUnidadeMedida = idUnidadeMedida;
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

}
