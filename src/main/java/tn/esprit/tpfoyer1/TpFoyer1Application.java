package tn.esprit.tpfoyer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TpFoyer1Application {

    public static void main(String[] args) {
        SpringApplication.run(TpFoyer1Application.class, args);
    }

}
