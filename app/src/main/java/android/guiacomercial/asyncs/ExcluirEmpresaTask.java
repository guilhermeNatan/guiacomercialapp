package android.guiacomercial.asyncs;

import android.content.Context;
import android.guiacomercial.dao.WebClient;
import android.guiacomercial.model.Empresa;
import android.widget.Toast;

import java.util.List;

/**
 * Created by guilherme.natan on 24/01/2018.
 */

public class ExcluirEmpresaTask extends BaseAsyncTask<Long,Void,String> {

    public ExcluirEmpresaTask(Context context) {
        super(context);
    }

    @Override
    protected String doInBackground(Long... ints) {
        WebClient wc = new WebClient();
        return wc.delete(ints[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(getContext(),s, Toast.LENGTH_LONG).show();
    }
}
