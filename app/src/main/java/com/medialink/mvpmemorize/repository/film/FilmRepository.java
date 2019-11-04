package com.medialink.mvpmemorize.repository.film;

import com.medialink.mvpmemorize.model.Film;

import java.util.List;

public class FilmRepository implements FilmDataSource {

    private FilmDataSource remoteDataSource;

    public FilmRepository(FilmDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public void getFilm(LoadDataCallback callback) {
        remoteDataSource.getFilm(new LoadDataCallback() {
            @Override
            public void onDataLoaded(List<Film> films) {
                callback.onDataLoaded(films);
            }

            @Override
            public void onNoDataLoaded() {
                callback.onNoDataLoaded();
            }

            @Override
            public void onError(Throwable e) {
                callback.onError(e);
            }
        });
    }
}
