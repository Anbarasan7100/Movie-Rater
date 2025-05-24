package com.tekpyramid.MovieRater.service;

import com.tekpyramid.MovieRater.dto.*;
import com.tekpyramid.MovieRater.entity.Actor;
import com.tekpyramid.MovieRater.entity.Financial;
import com.tekpyramid.MovieRater.entity.Language;
import com.tekpyramid.MovieRater.entity.Movie;
import com.tekpyramid.MovieRater.repository.ActorRepository;
import com.tekpyramid.MovieRater.repository.FinancialRepository;
import com.tekpyramid.MovieRater.repository.LanguageRepository;
import com.tekpyramid.MovieRater.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;
    private final LanguageRepository languageRepository;
    private final FinancialRepository financialRepository;
    private final ActorRepository actorRepository;


    @Transactional
    @Override
    public String saveMovieDetail(MovieDto movieDto) {

        Optional<Movie> existingMovie = movieRepository.findByTitleAndReleaseYear(
                movieDto.getTitle(), movieDto.getReleaseYear()
        );
        if (existingMovie.isPresent()) {
            return "Movie already exists: " + existingMovie.get().getTitle();
        }

        Language language = languageRepository.findByName(movieDto.getLanguageDto().getName())
                .orElseGet(() -> languageRepository.save(Language.builder()
                        .name(movieDto.getLanguageDto().getName())
                        .build()));

        List<Actor> actors = new ArrayList<>();

        for(ActorDto actorDto : movieDto.getActorDto()){
            Actor actor = actorRepository.findByName(actorDto.getName())
                    .orElseGet(()-> {Actor newActor = Actor.builder()
                            .name(actorDto.getName())
                            .birthYear(actorDto.getBirthYear())
                            .build();
                        return actorRepository.save(newActor);
                    });
            actors.add(actor);
        }

        Movie movie =Movie.builder().title(movieDto.getTitle())
                .industry(movieDto.getIndustry())
                .releaseYear(movieDto.getReleaseYear())
                .imdbRating(movieDto.getImdbRating())
                .studio(movieDto.getStudio())
                .language(language)
                .actorList(actors)
                .build();
        Movie savedMovie=movieRepository.save(movie);

        Financial financial = Financial.builder()
                .budget(movieDto.getFinancialDto().getBudget())
                .revenue(movieDto.getFinancialDto().getRevenue())
                .unit(movieDto.getFinancialDto().getUnit())
                .currency(movieDto.getFinancialDto().getCurrency())
                .movie(savedMovie)
                .build();
        financialRepository.save(financial);

        savedMovie.setFinancial(financial);

        return "Movie Saved Successfully " + savedMovie.getTitle();
    }

    @Transactional(readOnly = true)
    @Override
    public TopMovieDto getHighestRatedMovie() {

        Movie movie = movieRepository.findTopByOrderByImdbRatingDesc();

        TopMovieDto topMovieDto= new TopMovieDto();
        topMovieDto.setTitle(movie.getTitle());
        topMovieDto.setIndustry(movie.getIndustry());
        topMovieDto.setReleaseYear(movie.getReleaseYear());
        topMovieDto.setStudio(movie.getStudio());
        topMovieDto.setImdbRating(movie.getImdbRating());

        return topMovieDto;
    }

    @Transactional (readOnly = true)
    @Override
    public List<MovieLanguageDto> getMoviesByLanguage(String languageName) {

        List<Movie> movies=movieRepository.findByLanguage_Name(languageName);
        List<MovieLanguageDto> movieLanguageDtoList = new ArrayList<>();

        for(Movie movie : movies){
            MovieLanguageDto dto = new MovieLanguageDto();
            dto.setTitle(movie.getTitle());
            dto.setIndustry(movie.getIndustry());
            dto.setReleaseYear(movie.getReleaseYear());
            dto.setImdbRating(movie.getImdbRating());
            dto.setStudio(movie.getStudio());

            LanguageDto languageDto=new LanguageDto();
            languageDto.setName(movie.getLanguage().getName());

            dto.setLanguageDto(languageDto);

            List<ActorDto> actorDtoList = new ArrayList<>();
            for(Actor actor : movie.getActorList()){
                ActorDto actorDto = new ActorDto();
                actorDto.setName(actor.getName());
                actorDto.setBirthYear(actor.getBirthYear());
                actorDtoList.add(actorDto);
            }
            dto.setActorDto(actorDtoList);

            movieLanguageDtoList.add(dto);
        }

        return movieLanguageDtoList;
    }

    @Transactional (readOnly = true)
    @Override
    public List<MovieDto> getMoviesByRatingRange(double minRating, double maxRating) {
        List<Movie> movies = movieRepository.findByImdbRatingBetween(minRating, maxRating);
        List<MovieDto> movieDtoList = new ArrayList<>();

        for(Movie movie : movies){
            MovieDto dto = new MovieDto();
            dto.setTitle(movie.getTitle());
            dto.setIndustry(movie.getIndustry());
            dto.setReleaseYear(movie.getReleaseYear());
            dto.setImdbRating(movie.getImdbRating());
            dto.setStudio(movie.getStudio());

            LanguageDto languageDto = new LanguageDto();
            languageDto.setName(movie.getLanguage().getName());

            dto.setLanguageDto(languageDto);

            List <ActorDto> actorDtoList = new ArrayList<>();

            for (Actor actor : movie.getActorList()){
                ActorDto actorDto = new ActorDto();
                actorDto.setName(actor.getName());
                actorDto.setBirthYear(actor.getBirthYear());
                actorDtoList.add(actorDto);
            }

            dto.setActorDto(actorDtoList);

            Financial financial = movie.getFinancial();
            if (financial != null) {
                FinancialDto financialDto = new FinancialDto();
                financialDto.setBudget(financial.getBudget());
                financialDto.setRevenue(financial.getRevenue());
                financialDto.setUnit(financial.getUnit());
                financialDto.setCurrency(financial.getCurrency());

                dto.setFinancialDto(financialDto);
            }

            movieDtoList.add(dto);
        }
        return movieDtoList;
    }
}
