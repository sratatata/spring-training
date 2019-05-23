package pl.training.bank.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@Configuration
public class UserConfig {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void init() {
        User user = new User("admin", "123");
        user.setRole("ROLE_ADMIN");
        userService.addUser(user);
    }

    @Bean
    public UserService userService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return new UserService(userRepository, passwordEncoder);
    }

}
