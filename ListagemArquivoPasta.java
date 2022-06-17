import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class ListagemArquivoPasta {

    public static void main(String[] args) throws IOException, FileNotFoundException {

        ArrayList<String> arquivos = new ArrayList(); // Criando um array para guardar os nomes dos arquivos
        File diretorio = new File("C:\\Users\\luiz.machado\\Desktop\\Nova pasta"); // realiza a busca do que tem dentro da pasta rede

        boolean arquivosIguais = true;

        for(File file:diretorio.listFiles()) {
            if(file.getName().contains(".html")) { // verificando se o arquivo é da extensão txt
                arquivos.add(file.getAbsolutePath()); // se sim, adiciona ele ao array de arquivos
            }
        }

        BufferedReader leitor1 = new BufferedReader(new FileReader(arquivos.get(0)));
        BufferedReader leitor2 = new BufferedReader(new FileReader(arquivos.get(1)));

        String linha1 = leitor1.readLine();
        String linha2 = leitor2.readLine();
        int numeroLinha = 1;

        while (linha1 != null && linha2 != null) {

            if(! linha1.equalsIgnoreCase(linha2)) {
                System.out.println("Diferença encontrada na linha " + numeroLinha + ": \n");
                System.out.println("Arquivo 1: " + linha1);
                System.out.println("Arquivo 2: " + linha2);
                System.out.println("--------------------------\n");
                arquivosIguais = false;
            }

            linha1 = leitor1.readLine();
            linha2 = leitor2.readLine();

            numeroLinha++;
        }

        if (arquivosIguais) {
            System.out.println("\nArquivos iguais");
        } else {
            System.out.println("\nArquivos diferentes");
        }
    }
}