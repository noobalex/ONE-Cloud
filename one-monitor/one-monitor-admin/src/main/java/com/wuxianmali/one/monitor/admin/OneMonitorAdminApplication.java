package com.wuxianmali.one.monitor.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class OneMonitorAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneMonitorAdminApplication.class, args);
	}

}
