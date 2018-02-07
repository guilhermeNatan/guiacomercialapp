package android.guiacomercial.asyncs;

import android.app.Activity;
import android.content.Context;
import android.guiacomercial.dao.WebClienteEmpresa;
import android.os.AsyncTask;
import android.view.View;

import lombok.Getter;
import lombok.Setter;

/**
 * BaseAsynck para fragments
 * Created by guilherme.natan on 27/01/2018.
 */

public abstract  class BaseAsyncTaskView <PARAMS,PROGRESS,RESULT> extends AsyncTask<PARAMS,PROGRESS, RESULT> {

    @Getter
    private  Activity act;
    @Getter
    private View view;
    @Getter
    private WebClienteEmpresa webClient;

    @Getter
    @Setter
    private Context context;

    /**
     * Cosntrutor para casos em que não há activity e sim view
     * @param view
     */
    public BaseAsyncTaskView(Activity act, View view, Context context) {
        this.view = view;
        this.act = act;
        webClient = new WebClienteEmpresa();
        this.context = context;
    }


}
