package android.guiacomercial.asyncs;

import android.app.Activity;
import android.guiacomercial.dao.WebClient;

/**
 * Created by guilherme.natan on 24/01/2018.
 */

public class ExcluirEmpresaTask extends BaseAsyncTask<Long,Void,String> {


    public ExcluirEmpresaTask(Activity activity) {
        super(activity);
    }


    @Override
    protected String doInBackground(Long... ints) {
        WebClient wc = new WebClient();
        return wc.delete(ints[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        BuscarEmpresasTask buscarTarefaTask =
                new BuscarEmpresasTask(getActivity());
        buscarTarefaTask.execute();
    }
}
