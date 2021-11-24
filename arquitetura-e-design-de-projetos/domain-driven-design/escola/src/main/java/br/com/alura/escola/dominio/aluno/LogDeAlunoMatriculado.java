package br.com.alura.escola.dominio.aluno;

import java.time.format.DateTimeFormatter;

public class LogDeAlunoMatriculado {

    public void reageAo(AlunoMatriculado evento) {
        String momentoFormatado = evento.momento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.println(String.format("Aluno com CPF %s matriculado em: %s", evento.getCpfDoAluno(), momentoFormatado));
    }
}
