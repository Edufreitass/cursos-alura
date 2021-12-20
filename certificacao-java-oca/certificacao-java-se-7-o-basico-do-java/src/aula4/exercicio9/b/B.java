package aula4.exercicio9.b;

import aula4.exercicio9.A;

import static aula4.exercicio9.A.VALOR;

/**
 * B não compila pois tenta acessar uma classe do pacote padrão (sem nome).
 * Classes do pacote padrão só podem ser acessadas por outros tipos do pacote padrão. Não compila.
 */
class B{

    // Não compila
    void m() {
        A a = new A();
        a.executa(VALOR);
    }
}
