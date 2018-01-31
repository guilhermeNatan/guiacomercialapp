package android.guiacomercial.asyncs;

import android.app.Activity;
import android.app.FragmentManager;
import android.guiacomercial.AdicionarEmpresaFragment;
import android.guiacomercial.R;
import android.guiacomercial.converters.Converter;
import android.guiacomercial.model.Empresa;
import android.os.Bundle;

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
        Bundle bundle = new Bundle();
        Converter<Empresa> converter = new Converter<>();
        AdicionarEmpresaFragment fragInfo = new AdicionarEmpresaFragment();

        bundle.putString(Empresa.key, converter.converterEntidadeString(empresa) );
        fragInfo.setArguments(bundle);
        FragmentManager manager = getActivity().getFragmentManager();
        manager.beginTransaction().replace(R.id.content_frame,
                fragInfo).commit();
    }
}
