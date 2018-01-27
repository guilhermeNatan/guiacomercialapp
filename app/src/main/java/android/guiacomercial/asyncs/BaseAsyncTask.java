package android.guiacomercial.asyncs;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.util.concurrent.ExecutionException;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by guilherme.natan on 24/01/2018.
 */
@Getter
@Setter
public abstract class BaseAsyncTask<PARAMS,PROGRESS,RESULT> extends AsyncTask<PARAMS,PROGRESS, RESULT> {
    private Context context;
    private ProgressDialog dialog;


    public BaseAsyncTask(Context context) {
        this.context = context;
    }

}
