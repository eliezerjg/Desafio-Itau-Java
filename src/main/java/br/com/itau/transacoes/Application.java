package br.com.itau.transacoes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Value("${br.com.itau.transacoes.timezone}")
    private String timeZone;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        TimeZone.setDefault(TimeZone.getTimeZone(this.timeZone));
        System.out.println("Fuso horário configurado para: " + this.timeZone);
    }
}
