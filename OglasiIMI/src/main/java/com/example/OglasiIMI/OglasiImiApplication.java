package com.example.OglasiIMI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
@SpringBootApplication
public class OglasiImiApplication {

	public static void main(String[] args) throws SQLException  {
		SpringApplication.run(OglasiImiApplication.class, args);
		Db db = new Db();

	}

}
