package com.tekpyramid.MovieRater.repository;

import com.tekpyramid.MovieRater.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LanguageRepository extends JpaRepository<Language,Integer> {
    Optional<Language> findByName(String languageName);
}
