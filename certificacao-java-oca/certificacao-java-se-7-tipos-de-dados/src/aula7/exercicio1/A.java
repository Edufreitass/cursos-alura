package aula7.exercicio1;

/**
 * Não compila, pois length() é um método de String, diferente dos arrays em que length é um atributo.
 */
class A{

    // Não compila.
    public static void main(String [] args){
        String s = "aba";
        for(int i = 0; i < 9; i++) {
            s = s +"aba";
        }
        System.out.println(s.length);
    }
}
