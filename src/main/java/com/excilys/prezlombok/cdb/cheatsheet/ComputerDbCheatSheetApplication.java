package com.excilys.prezlombok.cdb.cheatsheet;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.var;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.ClassLoader.getSystemClassLoader;

@SpringBootApplication
public class ComputerDbCheatSheetApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComputerDbCheatSheetApplication.class, args);
	}

	@Bean
	@SneakyThrows(IOException.class)
	public Properties properties() {
		var props = new Properties();

		{
			@Cleanup InputStream path = getSystemClassLoader().getResourceAsStream("application.properties");
			props.load(path);
		}

		return props;
	}
}
