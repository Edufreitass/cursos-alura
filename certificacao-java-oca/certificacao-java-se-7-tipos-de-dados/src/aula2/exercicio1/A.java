package aula2.exercicio1;

/**
 * Imprime 47, pois a atribuição é por cópia do valor.
 */
class A {

    // Imprime 47.
    public static void main(String[] args) {
        int x = 15;
        int y = x;
        y++;
        x++;
        int z = y;
        z--;
        System.out.println(x + y + z);
    }
}
