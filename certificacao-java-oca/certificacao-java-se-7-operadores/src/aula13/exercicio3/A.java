package aula13.exercicio3;

/**
 * A String "42" é uma String uma vez que ela está entre aspas. Portanto, o código imprime Guilherme.
 */
class A {

    // Compila e imprime Guilherme.
    public static void main(String[] args) {
        switch("Guilherme") {
            case "Guilherme":
                System.out.println("Guilherme");
                break;
            case "42":
                System.out.println("42");
            default:
                System.out.println("Outro nome");
        }
    }
}
