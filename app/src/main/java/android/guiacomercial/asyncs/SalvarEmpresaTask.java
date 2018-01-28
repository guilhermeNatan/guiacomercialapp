package android.guiacomercial.asyncs;

import android.app.ProgressDialog;
import android.guiacomercial.R;
import android.guiacomercial.converters.EmpresaConverter;
import android.guiacomercial.dao.WebClient;
import android.guiacomercial.model.Empresa;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by guilherme.natan on 22/01/2018.
 */

public class SalvarEmpresaTask extends BaseAsyncTaskView<Empresa,String, String> {

    private ProgressDialog dialog;

    public SalvarEmpresaTask(View view) {
        super(view);
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(getContext(), "Aguarde","Enviado empresa", true, true);
    }

    @Override
    protected String doInBackground(Empresa... empresas) {
        EmpresaConverter converter = new EmpresaConverter();
        WebClient wc = new WebClient();
        String resposta = wc.post(converter.converter(empresas[0]));
        return resposta;
    }

    /**
     * Executado após o doInBackground
     * @param o
     */
    @Override
    protected void onPostExecute(String o) {
        dialog.dismiss();
        final TextView nome = getView().findViewById(R.id.cmp_nome_empresa);
        final TextView descricao = getView().findViewById(R.id.cmp_descricao_empresa);
        nome.setText("");
        descricao.setText("");
        Toast.makeText(getContext(),"Empresa adicionada", Toast.LENGTH_LONG).show();
    }
}
