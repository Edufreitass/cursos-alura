package aula4.exercicio7.b;

import static a.A.*;

/**
 * Não importamos a classe A, somente seus membros,
 * erro de compilação ao tentar referenciá-la na linha "A a = new A();".
 */
class B{

    // B não compila: erro na linha "A a = new A();".
    void m() {
        A a = new A();
        a.executa(VALOR);
    }
}
