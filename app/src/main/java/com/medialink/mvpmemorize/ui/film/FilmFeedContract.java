package com.medialink.mvpmemorize.ui.film;

import com.medialink.mvpmemorize.BasePresenter;
import com.medialink.mvpmemorize.BaseView;
import com.medialink.mvpmemorize.model.Film;

import java.util.List;

public interface FilmFeedContract {
    interface Presenter extends BasePresenter {
        void loadData();
    }

    interface View extends BaseView<Presenter> {
        void setItemToView(List<Film> list);

        void setNoDataLoadToView();

        void setErrorToView();
    }

}
