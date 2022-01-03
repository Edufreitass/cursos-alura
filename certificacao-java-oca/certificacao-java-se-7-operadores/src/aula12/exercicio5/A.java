package aula12.exercicio5;

/**
 * O código não compila pois o else não está aplicado ao if: para ser aplicado ao if,
 * ele deve vir imediatamente após seu bloco. Como o if não possui chaves, somente a primeira linha pertence a ele.
 */
class A {

    // Erro de compilação no else.
    public static void main(String[] args) {
        String nome = args[0];
        if(nome.equals("guilherme"))
            System.out.println(nome);
            System.out.println("bom");
        else
            System.out.println("melhor ainda");
            System.out.println(nome);
    }
}
