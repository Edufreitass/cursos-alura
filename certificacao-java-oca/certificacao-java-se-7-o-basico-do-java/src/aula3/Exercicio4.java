package aula3;

/**
 * Para rodar um programa dentro de um jar sem ter um manifesto, devemos usar o classpath customizado.
 * Colocamos o jar no classpath e dizemos qual classe desejamos rodar: java -cp programa.jar aula3.Exercicio4
 */
public class Exercicio4 {

    /**
     * Escolha a opção adequada para rodar a classe Exercicio4.java presente no diretório aula3,
     * que foi compactado em um arquivo chamado programa.jar, sendo que não existe nenhum arquivo de manifesto:
     */
    // Resposta: java -cp programa.jar aula3.Exercicio4
    public static void main(String[] args) {
        System.out.println(args[0]);
    }
}
