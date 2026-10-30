package fr.fabien.jpa.springbatch.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.autoconfigure.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("test")
class ConfigurationDataSourceJobRepository {

    @Bean
    @Primary
    @ConfigurationProperties("job-repository.datasource")
    DataSourceProperties dataSourcePropertiesJobRepository() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("job-repository.datasource.connection-pool")
    DataSource dataSourceJobRepository(@Qualifier("dataSourcePropertiesJobRepository") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }
}
