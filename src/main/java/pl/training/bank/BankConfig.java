package pl.training.bank;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@PropertySource("classpath:jdbc.properties")
@EnableAspectJAutoProxy
@Configuration
public class BankConfig {

    @Bean
    public DataSource dataSource(Environment environment) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername(environment.getProperty("database.username"));
        dataSource.setPassword(environment.getProperty("datasource.password"));
        dataSource.setJdbcUrl(environment.getProperty("datasource.url"));
        dataSource.setDriverClassName(environment.getProperty("database.driver"));
        return dataSource;
    }


}
