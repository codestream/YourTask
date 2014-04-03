package com.yourtask.app.util;

import dagger.ObjectGraph;

/**
 * Created by 1 on 04.04.2014.
 */
public final class Injector {
    public static ObjectGraph objectGraph = null;

    public static void init(final Object... modules) {

        if(objectGraph == null){
            objectGraph = ObjectGraph.create(modules);
        }
        else{
            objectGraph = objectGraph.plus(modules);
        }

        // Inject statics
        objectGraph.injectStatics();
    }

    public static void inject(final Object target){
        objectGraph.inject(target);
    }

    public static <T> T resolve(Class<T> type){
        return objectGraph.get(type);
    }
}
