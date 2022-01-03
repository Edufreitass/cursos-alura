package aula13.exercicio1;

class A {

    // Ao rodar com 5 argumentos, o código imprime mais argumentos.
    public static void main(String[] args) {
        int tamanho = args.length;
        switch(tamanho) {
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
            default:
                System.out.println("mais argumentos");
        }
    }
}
