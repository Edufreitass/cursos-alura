package aula7.exercicio5;

/**
 * Repare que o if testa se o carro é diferente do trem:
 * if ((trem && !carro) || (!trem && carro)) {
 *    //bloco if
 * }
 * <p>
 * Se o carro é false, o trem precisa ser true e vice-versa.
 * Em outras palavras, essa código NAO entra no bloco if se carro e trem forem iguais .
 * <p>
 * Essa regra pode ser apresentada mais curta através do XOR (disjunção exclusiva):
 * <p>
 * Carro|Trem | XOR
 * ----------------------
 * true|true|false
 * true |false|true
 * false|true |true
 * false|false|false
 * <p>
 * if (trem ^ carro) {
 *      //bloco if
 * }
 */
public class A {

    // A expressão a seguir pode ser reduzida, como podemos fazer?
    // R: Trocando para usar um operador ^
    public static void main(String[] args) {
        boolean trem = false;
        boolean carro = false;
        if ((trem && !carro) || (!trem && carro)) {
            // ....
        }
    }
}
