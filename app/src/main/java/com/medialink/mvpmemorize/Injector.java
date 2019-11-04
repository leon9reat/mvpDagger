package com.medialink.mvpmemorize;

import android.content.Context;

public final class Injector {
    public Injector() {
    }

    public static AppGraph obtain(Context context) {
        return App.get(context).getInjector();
    }

    static AppGraph create(App app) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(app))
                .build();
    }
}
