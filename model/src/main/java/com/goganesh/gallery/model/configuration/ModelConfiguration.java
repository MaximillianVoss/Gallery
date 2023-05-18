package com.goganesh.gallery.model.configuration;

import com.goganesh.gallery.model.repository.*;
import com.goganesh.gallery.model.service.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.goganesh.gallery.model.repository")
public class ModelConfiguration {

    @Primary
    @Bean(name = "dataSourceProp")
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "dataSource")
    public DataSource dataSource(@Qualifier("dataSourceProp") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                       @Qualifier("dataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("com.goganesh.gallery.model.domain")
                .build();
    }

    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    public ExhibitService exhibitService(ExhibitRepository exhibitRepository) {
        return new ExhibitService(exhibitRepository);
    }

    @Bean
    public AuthorService authorService(AuthorRepository authorRepository) {
        return new AuthorService(authorRepository);
    }

    @Bean
    public DictionaryService dictionaryService(DictionaryRepository dictionaryRepository) {
        return new DictionaryService(dictionaryRepository);
    }

    @Bean
    public EventService eventService(EventRepository eventRepository, EventExhibitService eventExhibitService) {
        return new EventService(eventRepository, eventExhibitService);
    }

    @Bean
    public EventExhibitService eventExhibitService(EventExhibitRepository eventExhibitRepository) {
        return new EventExhibitService(eventExhibitRepository);
    }

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }

    @Bean
    public ExhibitPlaceService exhibitPlaceService(ExhibitPlaceRepository exhibitPlaceRepository) {
        return new ExhibitPlaceService(exhibitPlaceRepository);
    }

    @Bean
    public FileStorageService fileStorageService() {
        return new FileStorageService();
    }

    @Bean
    public ExhibitFileService exhibitFileService(ExhibitFileRepository exhibitFileRepository,
                                                 FileStorageService fileStorageService,
                                                 @Value("${com.goganesh.gallery.model.file-storage-service.exhibit.document.directory}") String baseDirectory) {
        return new ExhibitFileService(exhibitFileRepository, fileStorageService, baseDirectory);
    }
}
