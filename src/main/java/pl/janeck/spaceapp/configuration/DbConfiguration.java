package pl.janeck.spaceapp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * ... comment class...
 *
 * @author JKN janeck@protonmail.com
 * @since 29 December 2020 @ 21:16
 */

@Configuration
public class DbConfiguration {

    private final DataSource dataSource;


    @Autowired
    public DbConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void initial() {
        String sql = "CREATE TABLE IF NOT EXISTS space_facts(id int auto_increment, date varchar(255), copyright varchar(255), explanation text, title varchar(255), url varchar(255), PRIMARY KEY (id))";
        getJdbcTemplate().update(sql);
    }

}
