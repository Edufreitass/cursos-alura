package br.com.alura;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExemploCursos {

    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

        cursos.sort(Comparator.comparing(Curso::getAlunos));
//        cursos.forEach(c -> System.out.println(c.getNome()));

//        cursos.stream()
//                .filter(c -> c.getAlunos() >= 100)
//                .forEach(c -> System.out.println(c.getNome()));

//        cursos.stream()
//                .filter(c -> c.getAlunos() >= 100)
//                .map(Curso::getAlunos)
//                .forEach(System.out::println);

//        int sum = cursos.stream()
//                .filter(c -> c.getAlunos() >= 100)
//                .mapToInt(Curso::getAlunos)
//                .sum();

//        OptionalDouble media = cursos.stream()
//                .filter(c -> c.getAlunos() >= 100)
//                .mapToInt(Curso::getAlunos)
//                .average();

//        System.out.println(sum);

//        cursos.stream()
//                .filter(c -> c.getAlunos() >= 100)
//                .findAny()
//                .ifPresent(c -> System.out.println(c.getNome()));

//        cursos = cursos.stream()
//                .filter(c -> c.getAlunos() >= 100)
//                .collect(Collectors.toList());
//
//        cursos.stream()
//                .forEach(c -> System.out.println(c.getNome()));

//        Map<String, Integer> map = cursos.stream()
//                .filter(c -> c.getAlunos() >= 100)
//                .collect(Collectors.toMap(
//                        c -> c.getNome(),
//                        c -> c.getAlunos()
//                ));
//
//        System.out.println(map);

//        cursos.stream()
//                .filter(c -> c.getAlunos() >= 100)
//                .collect(Collectors.toMap(
//                        c -> c.getNome(),
//                        c -> c.getAlunos()
//                )).forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));

        cursos.parallelStream()
                .filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toMap(
                        c -> c.getNome(),
                        c -> c.getAlunos()
                )).forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
    }
}
