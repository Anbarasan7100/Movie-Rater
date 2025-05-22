package com.tekpyramid.MovieRater.configuration;

import com.tekpyramid.MovieRater.entity.Language;
import com.tekpyramid.MovieRater.repository.LanguageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoader {

    /* CommandLineRunner: A special Spring Boot interface that runs code after the application starts.
    * @Bean: Used to declare a Spring-managed bean.
    * @Configuration: Marks this class as a configuration class that can define beans.*/

    @Bean
    CommandLineRunner loadData(LanguageRepository languageRepository){
        return args -> {

          /*  Language tamil= languageRepository.findByName("Tamil")
                    .orElseGet(()-> languageRepository.save(Language.builder().name("Tamil").build()));

            Language malayalam= languageRepository.findByName("Malayalam")
                    .orElseGet(()-> languageRepository.save(Language.builder().name("Malayalam").build()));

            Language telugu= languageRepository.findByName("Telugu")
                    .orElseGet(()-> languageRepository.save(Language.builder().name("Telugu").build()));

            Language kannada= languageRepository.findByName("Kannada")
                    .orElseGet(()-> languageRepository.save(Language.builder().name("Kannada").build()));

            Language bengali= languageRepository.findByName("Bengali")
                    .orElseGet(()-> languageRepository.save(Language.builder().name("Bengali").build()));

            Language english= languageRepository.findByName("English")
                    .orElseGet(()-> languageRepository.save(Language.builder().name("English").build()));

            Language hindi= languageRepository.findByName("Hindi")
                    .orElseGet(()-> languageRepository.save(Language.builder().name("Hindi").build()));

            Language gujarati= languageRepository.findByName("Gujarati")
                    .orElseGet(()-> languageRepository.save(Language.builder().name("Gujarati").build()));

            Language marathi= languageRepository.findByName("Marathi")
                    .orElseGet(()-> languageRepository.save(Language.builder().name("Marathi").build()));

            Language korean= languageRepository.findByName("Korean")
                    .orElseGet(()-> languageRepository.save(Language.builder().name("Korean").build()));

            Language chinese= languageRepository.findByName("Chinese")
                    .orElseGet(()-> languageRepository.save(Language.builder().name("Chinese").build())); */

            saveIfNotExists(languageRepository, "Tamil");
            saveIfNotExists(languageRepository, "Malayalam");
            saveIfNotExists(languageRepository, "Telugu");
            saveIfNotExists(languageRepository, "Kannada");
            saveIfNotExists(languageRepository, "Bengali");
            saveIfNotExists(languageRepository, "English");
            saveIfNotExists(languageRepository, "Hindi");
            saveIfNotExists(languageRepository, "Gujarati");
            saveIfNotExists(languageRepository, "Marathi");
            saveIfNotExists(languageRepository, "Korean");
            saveIfNotExists(languageRepository, "Chinese");

        };

    }
    private void saveIfNotExists(LanguageRepository languageRepository, String name) {
        languageRepository.findByName(name)
                .orElseGet(() -> languageRepository.save(Language.builder().name(name).build()));
    }

/*@Bean
    CommandLineRunner loadData(LanguageRepository languageRepository){
        return args -> {
            List<String> defaultLanguages = List.of(
                    "Tamil", "Malayalam", "Telugu", "Kannada", "Bengali",
                    "English", "Hindi", "Gujarati", "Marathi", "Korean", "Chinese"
            );

            defaultLanguages.forEach(language -> saveIfNotExists(languageRepository, language));
        };
    }*/


}
