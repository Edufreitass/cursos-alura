package aula4.exercicio8.b;

import a.A;
static import a.A.*;

/**
 * import static é o uso adequado, e não static import, erro na linha "static import a.A.*;".
 */
class B{

    // B não compila: erro na linha "static import a.A.*;".
    void m() {
        A a = new A();
        a.executa(VALOR);
    }
}
