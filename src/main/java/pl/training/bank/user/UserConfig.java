package pl.training.bank.user;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@Configuration
public class UserConfig {

    @Setter
    @Autowired
    private UserService userService;

    @PostConstruct
    public void init() {
        User user = new User("admin", "admin", "ROLE_ADMIN");
        userService.addUser(user);
    }

    @Bean
    public UserService userService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return new UserService(userRepository, passwordEncoder);
    }

}
