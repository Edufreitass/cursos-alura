package aula13.exercicio4;

/**
 * A sintaxe do case é com : e não com {, o código não compila. Até podemos usar {, mas não sem os dois pontos.
 */
class A {

    // Erro de compilação.
    public static void main(String[] args) {
        int count = args.length;
        switch(count) {
            case 0 {
                System.out.println("nenhum");
                break;
            } case 1 {
            } case 2 {
                System.out.println("ok");
            } default {
                System.out.println("default");
            }
        }
    }
}
