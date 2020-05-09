package com.mtnfog.philter;

import com.mtnfog.philter.opennlp.OpenNlpNer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class App {

    @Bean
    public OpenNlpNer openNlpNer() throws IOException {
        return new OpenNlpNer();
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}