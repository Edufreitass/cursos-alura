package br.com.alura.servidor;

import java.io.PrintStream;
import java.util.concurrent.*;

public class JuntaResultadosFutureWebServiceEFutureBanco implements Callable<Void> {

    private Future<String> futureWebService;
    private Future<String> futureBanco;
    private PrintStream saidaCliente;

    public JuntaResultadosFutureWebServiceEFutureBanco(Future<String> futureWebService, Future<String> futureBanco, PrintStream saidaCliente) {
        this.futureWebService = futureWebService;
        this.futureBanco = futureBanco;
        this.saidaCliente = saidaCliente;
    }

    @Override
    public Void call() {
        System.out.println("Aguardando resultados do Future WebService e Banco");

        try {
            String numeroMagico = this.futureWebService.get(20, TimeUnit.SECONDS);
            String numeroMagico2 = this.futureBanco.get(20, TimeUnit.SECONDS);
            this.saidaCliente.println("Resultado comando c2 : " + numeroMagico + ", " + numeroMagico2);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            System.out.println("Timeout cancelando execucao do comando c2");
            this.saidaCliente.println("Timeout na execucao do comando c2");
            this.futureWebService.cancel(true);
            this.futureBanco.cancel(true);
        }

        System.out.println("Finalizou JuntaResultadosFutureWebServiceEFutureBanco");
        return null;
    }
}
