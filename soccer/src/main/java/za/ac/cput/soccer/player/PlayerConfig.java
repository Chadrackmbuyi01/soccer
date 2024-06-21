package za.ac.cput.soccer.player;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PlayerConfig {

    @Bean
    CommandLineRunner commandLineRunner(PlayerRepository repository){
        return args -> {
            Player ronaldo = new Player (
                    "Ronaldo",
                    "cronaldo@gmail.com",
                    LocalDate.of (1991, Month.APRIL,6)
            );

            Player messi = new Player (
                    "messi",
                    "lmessi@gmail.com",
                    LocalDate.of (1992, Month.AUGUST,16)
            );

            repository.saveAll(
                    List.of(ronaldo, messi)
            );
        };
    }
}
