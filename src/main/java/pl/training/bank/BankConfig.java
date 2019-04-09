package pl.training.bank;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@PropertySource("classpath:jdbc.properties")
@EnableAspectJAutoProxy
@EnableTransactionManagement
@Configuration
public class BankConfig {

    @Bean
    public DataSource dataSource(Environment environment) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername(environment.getProperty("database.username"));
        dataSource.setPassword(environment.getProperty("database.password"));
        dataSource.setJdbcUrl(environment.getProperty("database.url"));
        dataSource.setDriverClassName(environment.getProperty("database.driver"));
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
