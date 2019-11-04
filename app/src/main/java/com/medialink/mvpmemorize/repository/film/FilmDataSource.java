package com.medialink.mvpmemorize.repository.film;

import com.medialink.mvpmemorize.model.Film;

import java.util.List;

public interface FilmDataSource {
    void getFilm(LoadDataCallback callback);

    interface LoadDataCallback {
        void onDataLoaded(List<Film> films);

        void onNoDataLoaded();

        void onError(Throwable e);
    }
}
