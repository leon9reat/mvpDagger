package com.medialink.mvpmemorize.repository;

import com.medialink.mvpmemorize.api.FilmService;
import com.medialink.mvpmemorize.repository.film.FilmRemoteDataSource;
import com.medialink.mvpmemorize.repository.film.FilmRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    @Provides
    @Singleton
    FilmRemoteDataSource provideFilmRemoteDataSource(FilmService filmService) {
        return new FilmRemoteDataSource(filmService);
    }

    @Provides
    @Singleton
    FilmRepository provideFilmRepository(FilmRemoteDataSource filmRemoteDataSource) {
        return new FilmRepository(filmRemoteDataSource);
    }
}
