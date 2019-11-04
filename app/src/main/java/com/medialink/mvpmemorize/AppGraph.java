package com.medialink.mvpmemorize;

import com.medialink.mvpmemorize.ui.film.FilmFeedFragment;

public interface AppGraph {
    void inject(App app);

    void inject(FilmFeedFragment filmFeedFragment);
}
