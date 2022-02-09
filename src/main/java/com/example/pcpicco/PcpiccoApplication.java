package com.example.pcpicco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class PcpiccoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PcpiccoApplication.class, args);
    }

}
