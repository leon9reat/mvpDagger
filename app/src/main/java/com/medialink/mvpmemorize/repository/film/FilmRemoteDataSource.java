package com.medialink.mvpmemorize.repository.film;

import com.medialink.mvpmemorize.api.FilmService;
import com.medialink.mvpmemorize.model.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmRemoteDataSource implements FilmDataSource {
    private FilmService service;

    public FilmRemoteDataSource(FilmService service) {
        this.service = service;
    }

    @Override
    public void getFilm(final LoadDataCallback callback) {
        service.getFilm().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful()) {
                    callback.onDataLoaded(response.body());
                } else {
                    callback.onNoDataLoaded();
                }
            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                callback.onError(t);
            }
        });
    }
}
