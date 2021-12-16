package br.com.alura.spring.data;

import br.com.alura.spring.data.service.CargoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    private final CargoService cargoService;
    private Boolean system = true;

    public SpringDataApplication(CargoService cargoService) {
        this.cargoService = cargoService;
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        while (system) {
            System.out.println("Qual acao voce deseja executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Cargo");

            int action = scanner.nextInt();
            if (action == 1) {
                cargoService.inicial(scanner);
            } else {
                system = false;
            }
        }

        scanner.close();
    }
}
