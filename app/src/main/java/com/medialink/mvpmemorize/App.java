package com.medialink.mvpmemorize;

import android.app.Application;
import android.content.Context;

public final class App extends Application {
    private AppGraph appGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        appGraph = Injector.create(this);
        appGraph.inject(this);
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    AppGraph getInjector() {
        return appGraph;
    }
}
