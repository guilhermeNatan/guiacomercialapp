package android.guiacomercial.asyncs;

import android.app.Activity;
import android.content.Intent;
import android.guiacomercial.AdicionarEmpresaActivity;
import android.guiacomercial.converters.Converter;
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
        Converter<Empresa> converter = new Converter<>();
        Intent intent = new Intent(getActivity(), AdicionarEmpresaActivity.class);
        intent.putExtra(Empresa.key, converter.converterEntidadeString(empresa) );
        getActivity().startActivity(intent);

        //        navegacaoAntiga(empresa);
    }

    private void navegacaoAntiga(Empresa empresa) {
//        Bundle bundle = new Bundle();
//        Converter<Empresa> converter = new Converter<>();
//        AdicionarEmpresaFragment fragInfo = new AdicionarEmpresaFragment();
//
//        bundle.putString(Empresa.key, converter.converterEntidadeString(empresa) );
//        fragInfo.setArguments(bundle);
//        FragmentManager manager = getActivity().getFragmentManager();
//        manager.beginTransaction().replace(R.id.content_frame,
//                fragInfo).commit();
    }
}
