package xyz.danicostas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import xyz.danicostas.cli.CommandLineInterface;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		CommandLineInterface cli = context.getBean("commandLineInterface", CommandLineInterface.class);
		cli.runApp();
	}

}
