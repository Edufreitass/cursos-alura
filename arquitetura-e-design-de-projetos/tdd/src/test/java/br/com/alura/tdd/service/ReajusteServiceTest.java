package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar() {
        System.out.println("Inicio");
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @AfterEach
    public void finalizar() {
        System.out.println("Fim");
    }

    @AfterAll
    public static void depoisDeTodos() {
        System.out.println("DEPOIS DE TODOS");
    }

    @BeforeAll
    public static void antesDeTodos() {
        System.out.println("ANTES DE TODOS");
    }

    @Test
    public void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADesejar() {
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForBom() {
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeVintePorCentoQuandoDesempenhoForOtimo() {
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}