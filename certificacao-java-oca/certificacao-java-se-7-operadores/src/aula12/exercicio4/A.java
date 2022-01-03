package aula12.exercicio4;

/**
 * O código não compila pois não existe palavra-chave elseif. Devemos fazer um else if para compilar.
 */
class A {

    // Não compila.
    public static void main(String[] args) {
        if(args.length==1)
            System.out.println("Um");
        elseif(args.length==2)
        System.out.println("Dois");
        elseif(args.length==3)
        System.out.println("Três");
        else
        System.out.println("Quatro");
    }
}
