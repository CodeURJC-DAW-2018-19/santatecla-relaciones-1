package es.santatecla.relaciones;

import es.santatecla.database.entities.User;
import es.santatecla.database.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner dataForTesting(UserRepository userRepository) {
        return (args) -> {
            userRepository.deleteAll();
            final User user = new User("user", "pass");
            user.addRole("user");
            userRepository.save(user);
            final User admin = new User("admin", "pass");
            admin.addRole("admin");
            userRepository.save(admin);

        };
    }

}
