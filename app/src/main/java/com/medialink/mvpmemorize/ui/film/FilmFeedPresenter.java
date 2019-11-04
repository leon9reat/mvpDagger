package com.medialink.mvpmemorize.ui.film;

import com.medialink.mvpmemorize.model.Film;
import com.medialink.mvpmemorize.repository.film.FilmDataSource;
import com.medialink.mvpmemorize.repository.film.FilmRepository;

import java.util.List;

public class FilmFeedPresenter implements FilmFeedContract.Presenter {
    private FilmFeedContract.View view;
    private FilmRepository repository;


    public FilmFeedPresenter(FilmFeedContract.View view, FilmRepository repository) {
        this.view = view;
        this.repository = repository;
        this.view.setPresenter(this);
    }

    @Override
    public void loadData() {
        repository.getFilm(new FilmDataSource.LoadDataCallback() {
            @Override
            public void onDataLoaded(List<Film> films) {
                view.setItemToView(films);
            }

            @Override
            public void onNoDataLoaded() {
                view.setNoDataLoadToView();
            }

            @Override
            public void onError(Throwable e) {
                view.setErrorToView();
            }
        });
    }


    @Override
    public void start() {
        loadData();
    }
}
