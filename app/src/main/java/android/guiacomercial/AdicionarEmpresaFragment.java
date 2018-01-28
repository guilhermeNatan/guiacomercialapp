package android.guiacomercial;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.guiacomercial.asyncs.SalvarEmpresaTask;
import android.guiacomercial.model.Empresa;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by guilherme.natan on 27/01/2018.
 */

public class AdicionarEmpresaFragment extends BaseFragment {


    @Override
    protected void executar() {
        salvarEmpresa();
    }

    @Override
    public int getLayoutParaInflar() {
        return R.layout.salvar_empresa;
    }

    private void salvarEmpresa()
    {
        final TextView nome = getMyView().findViewById(R.id.cmp_nome_empresa);
        final TextView descricao = getMyView().findViewById(R.id.cmp_descricao_empresa);
        Button salvar =  (Button) getMyView().findViewById(R.id.btn_salvarEmpresa);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Empresa empresa = new Empresa(nome.getText().toString(),
                        descricao.getText().toString());
                SalvarEmpresaTask salvarEmpresaTask = new SalvarEmpresaTask(getMyView());
                salvarEmpresaTask.execute(empresa);
            }
        });

    }

}
