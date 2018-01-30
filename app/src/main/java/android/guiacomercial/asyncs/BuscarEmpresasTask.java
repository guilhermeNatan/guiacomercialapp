package android.guiacomercial.asyncs;

import android.app.Activity;
import android.guiacomercial.AdaptadorLista;
import android.guiacomercial.R;
import android.guiacomercial.model.Empresa;
import android.widget.ListView;

import java.util.List;

/**
 * Busca e lista todas as empresas da base de dados.
 * Created by guilherme.natan on 22/01/2018.
 */
public class BuscarEmpresasTask extends BaseAsyncTask<Void, Void, List<Empresa>>{


    public BuscarEmpresasTask(Activity activity) {
        super(activity);
    }

    @Override
    protected List<Empresa> doInBackground(Void... voids) {
        List<Empresa> empresas = getWebClient().get();
        return empresas;
    }

    /**
     * Executado após o doInBackground
     * @param
     */
    @Override
    protected void onPostExecute(List<Empresa> empresas) {
        ListView listaCartelas = getActivity().findViewById(R.id.lista_empresas);
        final AdaptadorLista adaptador = new AdaptadorLista(empresas, getActivity());
        listaCartelas.setAdapter(adaptador);
    }


}
