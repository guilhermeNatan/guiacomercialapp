package android.guiacomercial.asyncs;

import android.app.Activity;
import android.content.Intent;
import android.guiacomercial.AdicionarEmpresaActivity;
import android.guiacomercial.model.Empresa;

/**
 * Task para obter uma empresa especifica .
 * Created by guilherme.natan on 30/01/2018.
 */

public class BuscarUmaEmpresaTask extends BaseAsyncTaskActivity<Long, Void, Empresa> {

    public BuscarUmaEmpresaTask(Activity activity) {
        super(activity);
    }

    @Override
    protected Empresa doInBackground(Long... ids) {
        return getWebClient().get(ids[0]);
    }

    @Override
    protected void onPostExecute(Empresa empresa) {
        Intent intent = new Intent(getActivity(), AdicionarEmpresaActivity.class);
        intent.putExtra(Empresa.key, empresa);
        getActivity().startActivity(intent);
    }

}
