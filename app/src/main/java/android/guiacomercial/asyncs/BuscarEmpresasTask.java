package android.guiacomercial.asyncs;

import android.content.Context;
import android.guiacomercial.dao.WebClient;
import android.guiacomercial.model.Empresa;
import android.widget.Toast;

import java.util.List;

import lombok.Getter;

/**
 * Created by guilherme.natan on 22/01/2018.
 */

public class BuscarEmpresasTask extends BaseAsyncTask<Void, Void, List<Empresa>>{

    @Getter
    private List<Empresa> resultado;

    public BuscarEmpresasTask(Context context) {
       super(context);
    }

    @Override
    protected List<Empresa> doInBackground(Void... voids) {
        WebClient wc = new WebClient();
        List<Empresa> empresas = wc.get();
        return empresas;
    }

    /**
     * Executado após o doInBackground
     * @param
     */
    @Override
    protected void onPostExecute(List<Empresa> empresas) {
        Toast.makeText(getContext(),"Quantidade de empresas: " +
                empresas.size(), Toast.LENGTH_LONG).show();
    }


}
