package android.guiacomercial.asyncs;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

import lombok.Getter;

/**
 * Created by guilherme.natan on 24/01/2018.
 */
public abstract class BaseAsyncTask<PARAMS,PROGRESS,RESULT> extends AsyncTask<PARAMS,PROGRESS, RESULT> {
    @Getter
    private Activity activity;

    public BaseAsyncTask(Activity activity) {
        this.activity = activity;
    }

    public Context getContext() {
        return activity.getBaseContext();
    }

}
