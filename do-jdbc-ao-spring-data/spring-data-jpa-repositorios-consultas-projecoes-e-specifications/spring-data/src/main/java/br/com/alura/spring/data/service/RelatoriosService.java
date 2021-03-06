package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioDTO;
import br.com.alura.spring.data.orm.FuncionarioProjecao;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {

    private Boolean system = true;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final FuncionarioRepository funcionarioRepository;

    public RelatoriosService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner) {
        while (system) {
            System.out.println("Qual acao de relatorio deseja executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Busca funcionario por nome");
            System.out.println("2 - Busca funcionario por nome, data de contratacao e salario maior");
            System.out.println("3 - Busca funcionario data contratacao");
            System.out.println("4 - Busca funcionario salario");
            System.out.println("5 - Busca funcionario por nome e cpf");

            int action = scanner.nextInt();

            switch (action) {
                case 1 -> buscaFuncionarioPorNome(scanner);
                case 2 -> buscaFuncionarioPorNomeSalarioMaiorDataContratacao(scanner);
                case 3 -> buscaFuncionarioPorDataContratacao(scanner);
                case 4 -> buscaFuncionarioSalario();
                case 5 -> buscaFuncionarioNomeCpf();
                default -> system = false;
            }
        }
    }

    private void buscaFuncionarioPorNome(Scanner scanner) {
        System.out.println("Qual nome deseja pesquisar?");
        String nome = scanner.next();
        List<Funcionario> funcionarios = funcionarioRepository.findByNome(nome);
        funcionarios.forEach(System.out::println);
    }

    private void buscaFuncionarioPorNomeSalarioMaiorDataContratacao(Scanner scanner) {
        System.out.println("Qual nome deseja pesquisar?");
        String nome = scanner.next();

        System.out.println("Qual data contratacao deseja pesquisar?");
        String data = scanner.next();
        LocalDate dataContratacao = LocalDate.parse(data, formatter);

        System.out.println("Qual salario deseja pesquisar?");
        Double salario = scanner.nextDouble();

        List<Funcionario> funcionarios = funcionarioRepository.findNomeSalarioMaiorDataContratacao(nome, salario, dataContratacao);
        funcionarios.forEach(System.out::println);
    }

    private void buscaFuncionarioPorDataContratacao(Scanner scanner) {
        System.out.println("Qual data contratacao deseja pesquisar?");
        String data = scanner.next();
        LocalDate dataContratacao = LocalDate.parse(data, formatter);

        List<Funcionario> funcionarios = funcionarioRepository.findDataContratacaoMaior(dataContratacao);
        funcionarios.forEach(System.out::println);
    }

    private void buscaFuncionarioSalario() {
        List<FuncionarioProjecao> funcionarioProjecaos = funcionarioRepository.findFuncionarioSalario();
        funcionarioProjecaos.forEach(f -> System.out.println("Funcionario: id: " + f.getId()
                + " | nome: " + f.getNome() + " | salario: " + f.getSalario()));
    }

    private void buscaFuncionarioNomeCpf() {
        List<FuncionarioDTO> dto = funcionarioRepository.findFuncionarioNomeCpf();
        dto.forEach(f -> System.out.println("Funcionario: nome: " + f.getNome() + " | cpf: " + f.getCpf()));
    }
}
