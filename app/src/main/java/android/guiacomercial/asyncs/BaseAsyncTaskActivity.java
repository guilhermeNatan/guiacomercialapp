package android.guiacomercial.asyncs;

import android.app.Activity;
import android.content.Context;
import android.guiacomercial.dao.WebClienteEmpresa;
import android.os.AsyncTask;

import lombok.Getter;

/**
 * Created by guilherme.natan on 24/01/2018.
 */
public abstract class BaseAsyncTaskActivity<PARAMS,PROGRESS,RESULT> extends AsyncTask<PARAMS,PROGRESS, RESULT> {
    @Getter
    private Activity activity;
    @Getter
    private WebClienteEmpresa webClient;

    public BaseAsyncTaskActivity(Activity activity) {
        this.activity = activity;
        webClient = new WebClienteEmpresa();
    }

    public Context getContext() {
        return activity.getBaseContext();
    }

}
