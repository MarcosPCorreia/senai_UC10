//Importação dos pacotes
import java.io.IOException;
import model.Menu;

//Classe Principal do Programa
public class Main {

    //Função Principal do Programa
    public static void main(String[] args) throws IOException, InterruptedException {
        // Carrega o Menu Principal
        System.out.println("-----------   Bem vindo ao Sistema Datamobile   ------------------\n");
        Menu menu = new Menu();
        menu.menuPrincipal();
    }
}

