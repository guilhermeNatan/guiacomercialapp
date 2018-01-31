package android.guiacomercial.asyncs;

import android.app.ProgressDialog;
import android.guiacomercial.R;
import android.guiacomercial.converters.Converter;
import android.guiacomercial.model.Empresa;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Task para editar uma empresa
 * Created by guilherme.natan on 29/01/2018.
 */

public class EditarEmpresaTask extends SalvarEmpresaTask {

    public EditarEmpresaTask(View view) {
        super(view);
    }


    @Override
    protected String doInBackground(Empresa... empresas) {
        Converter converter = new Converter();
        Empresa ep = empresas[0];
        String resposta = getWebClient().put(converter.converterEntidadeString(ep), ep.getId());
        return resposta;
    }

}
