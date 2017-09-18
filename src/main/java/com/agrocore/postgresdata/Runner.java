package com.agrocore.postgresdata;

import com.agrocore.postgresdata.model.Driver;
import com.agrocore.postgresdata.repository.DriverRepository;
import com.bedatadriven.jackson.datatype.jts.JtsModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.WKTReader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Runner {
	public static void main(String[] args) {
		SpringApplication.run(Runner.class, args);
	}
}
