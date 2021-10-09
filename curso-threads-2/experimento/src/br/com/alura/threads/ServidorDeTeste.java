package br.com.alura.threads;

public class ServidorDeTeste {

    private volatile boolean estaRodando = false;

    public static void main(String[] args) throws InterruptedException {
        ServidorDeTeste servidor = new ServidorDeTeste();
        servidor.rodar();
        servidor.alterandoAtributo();
    }

    private void rodar() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("Servidor comecando, estaRodando = " + estaRodando);

                    while (!estaRodando) {
                    }

                    if (estaRodando) {
                        throw new RuntimeException("Deu erro na thread ....");
                    }

                    System.out.println("Servidor rodando, estaRodando = " + estaRodando);

                    while (estaRodando) {
                    }

                    System.out.println("Servidor terminando, estaRodando = " + estaRodando);
                } catch (Exception e) {
                    System.out.println("catch na Thread-1 " + e.getMessage());
                }
            }
        }).start();
    }

    private void alterandoAtributo() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Main alterando estaRodando = true");
        estaRodando = true;

        Thread.sleep(5000);
        System.out.println("Main alterando estaRodando = false");
        estaRodando = false;
    }
}
