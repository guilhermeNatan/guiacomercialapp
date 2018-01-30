package android.guiacomercial.asyncs;

import android.app.ProgressDialog;
import android.guiacomercial.R;
import android.guiacomercial.converters.EmpresaConverter;
import android.guiacomercial.model.Empresa;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Task para editar uma empresa
 * Created by guilherme.natan on 29/01/2018.
 */

public class EditarEmpresaTasck extends BaseAsyncTaskView<Empresa, Void, String> {

    private ProgressDialog dialog;
    /**
     * Cosntrutor para casos em que não há activity e sim view
     *
     * @param view
     */
    public EditarEmpresaTasck(View view) {
        super(view);
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(getContext(), "Aguarde","Enviado empresa", true, true);
    }

    @Override
    protected String doInBackground(Empresa... empresas) {
        EmpresaConverter converter = new EmpresaConverter();
        Empresa ep = empresas[0];
        String resposta = getWebClient().put(converter.converterEntidadeString(ep),ep.getId());
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
