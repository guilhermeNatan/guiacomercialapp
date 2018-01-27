package android.guiacomercial.asyncs;

import android.content.Context;
import android.guiacomercial.dao.WebClient;
import android.guiacomercial.model.Empresa;
import android.widget.Toast;

import java.util.List;

/**
 * Created by guilherme.natan on 25/01/2018.
 */

public class BuscarEExcluirEmpresaTask extends BaseAsyncTask<Integer, Long, List<Empresa>> {
    public BuscarEExcluirEmpresaTask(Context context) {
        super(context);
    }

    @Override
    protected List<Empresa> doInBackground(Integer... integers) {
        WebClient wc = new WebClient();
        List<Empresa> empresas = wc.get();
        return empresas;
    }

    @Override
    protected void onPostExecute(List<Empresa> s) {
        ExcluirEmpresaTask excluirEmpresaTask = new ExcluirEmpresaTask(getContext());
        excluirEmpresaTask.execute(s.get(0).getId());

    }
}
