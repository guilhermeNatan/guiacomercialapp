package android.guiacomercial.asyncs;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;

import lombok.Getter;

/**
 * BaseAsynck para fragments
 * Created by guilherme.natan on 27/01/2018.
 */

public abstract  class BaseAsyncTaskView <PARAMS,PROGRESS,RESULT> extends AsyncTask<PARAMS,PROGRESS, RESULT> {

    @Getter
    private View view;

    /**
     * Cosntrutor para casos em que não há activity e sim view
     * @param view
     */
    public BaseAsyncTaskView(View view) {
        this.view = view;
    }

    public Context getContext() {
        return view.getContext();
    }

}
