package com.medialink.mvpmemorize.api;

import com.medialink.mvpmemorize.model.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FilmService {
    String BASE_URL = "https://ghibliapi.herokuapp.com/";

    @GET("films")
    Call<List<Film>> getFilm();
}
