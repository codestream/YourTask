package com.yourtask.app.module;

import com.yourtask.app.model.NavigationDrawer;
import com.yourtask.app.ui.profile.ProfileActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(injects = {ProfileActivity.class}, library = true, complete = false)
public class NavigationDrawerModule {

    @Provides @Singleton
    public NavigationDrawer provideDrawerShadow(){
        return new NavigationDrawer();
    }
}
