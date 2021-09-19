package br.com.alura;

public class TestaBuscaAlunosNoCurso {

    /**
     * Conceitos sobre MAP
     *
     * Se repetimos uma chave, a chave repetida é sobrescrita pela nova?
     * R: Se uma chave for repetida, a antiga permanece, porém, o valor é sobrescrito
     * pelo novo valor contido na chave passada, sendo o antigo valor "esquecido" pelo Map.
     *
     * A interface Map mapeia valores para chaves, ou seja, através da chave conseguimos acessar o valor?
     * R: Ela funciona da seguinte maneira, mapeia valores para chaves, e através da chave conseguimos acessar
     * o valor correspondente. Por isso ela não pode ser repetida, ao contrário do valor, que podem existir iguais.
     */
    public static void main(String[] args) {
        Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");

        javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
        javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
        javaColecoes.adiciona(new Aula("Modelando com coleções", 24));

        Aluno a1 = new Aluno("Rodrigo Turini", 34672);
        Aluno a2 = new Aluno("Guilherme Silveira", 5617);
        Aluno a3 = new Aluno("Mauricio Aniche", 17645);
        Aluno a4 = new Aluno("Paulo Silveira", 5617);

        javaColecoes.matricula(a1);
        javaColecoes.matricula(a2);
        javaColecoes.matricula(a3);
        javaColecoes.matricula(a4);

        System.out.println(javaColecoes.getAlunos());
        System.out.println("Quem é o aluno com matricula 5617?");
        Aluno aluno = javaColecoes.buscaMatriculado(5617);
        System.out.println("aluno: " + aluno);
    }
}
