package android.guiacomercial.asyncs;

import android.app.Activity;

/**
 * Task para excluir uma empresa
 * Created by guilherme.natan on 24/01/2018.
 */

public class ExcluirEmpresaTask extends BaseAsyncTaskActivity<Long,Void,String> {


    public ExcluirEmpresaTask(Activity activity) {
        super(activity);
    }


    @Override
    protected String doInBackground(Long... ints) {
        return getWebClient().delete(ints[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        BuscarEmpresasTask buscarTarefaTask =
                new BuscarEmpresasTask(getActivity());
        buscarTarefaTask.execute();
    }
}
