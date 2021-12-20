package aula4.exercicio5.a;

/**
 * O arquivo B compila pois é uma classe normal. O arquivo C não compila pois tenta acessar B, que está em outro pacote,
 * mas lembre-se que devemos acessar os pacotes diretamente, não existe subpacote. O mesmo vale para A.
 * Portanto, nem A nem C compilam.
 */
// Erro de compilação nos arquivos A e C.
public class C {
    aula4.exercicio5.b.B variavel;
}
