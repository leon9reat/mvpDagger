package com.medialink.mvpmemorize;

import com.medialink.mvpmemorize.api.ApiModule;
import com.medialink.mvpmemorize.repository.RepositoryModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {
        AppModule.class,
        ApiModule.class,
        RepositoryModule.class})
@Singleton
public interface AppComponent extends AppGraph {
}
