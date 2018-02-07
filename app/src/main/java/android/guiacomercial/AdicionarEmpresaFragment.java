package android.guiacomercial;

import android.guiacomercial.asyncs.EditarEmpresaTask;
import android.guiacomercial.asyncs.SalvarEmpresaTask;
import android.guiacomercial.converters.Converter;
import android.guiacomercial.model.Empresa;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Tela para cadastro das empresas
 * Created by guilherme.natan on 27/01/2018.
 */

public class AdicionarEmpresaFragment extends BaseFragment {

    private Long idEmpresa;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (this.getArguments() != null) {
            this.idEmpresa = this.getArguments().getLong("idEmpresa");
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void executar() {
        carregarParaAlterar();
        salvarEmpresa();
    }

    private void carregarParaAlterar() {
        if(this.getArguments()!=null && this.getArguments().getString(Empresa.key)!=null)
        {
            Converter<Empresa> converter = new Converter<>();
            Empresa empresa = converter.converterStringEntidade(
                    this.getArguments().getString(Empresa.key), Empresa.class);
            final TextView nome = getMyView().findViewById(R.id.cmp_nome_empresa);
            final TextView descricao = getMyView().findViewById(R.id.cmp_descricao_empresa);
            nome.setText(empresa.getNome());
            descricao.setText(empresa.getDescricao());
            idEmpresa = empresa.getId();
    }
    }

    @Override
    public int getLayoutParaInflar() {
        return R.layout.salvar_empresa;
    }

    private void salvarEmpresa() {
        final TextView nome = getMyView().findViewById(R.id.cmp_nome_empresa);
        nome.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        final TextView descricao = getMyView().findViewById(R.id.cmp_descricao_empresa);
        final Button salvar = (Button) getMyView().findViewById(R.id.btn_salvarEmpresa);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Empresa empresa = new Empresa(nome.getText().toString(),
                        descricao.getText().toString());
//                if (idEmpresa != null) {
//                    empresa.setId(idEmpresa);
//                    EditarEmpresaTask editarEmp = new EditarEmpresaTask(getMyView());
//                    editarEmp.execute(empresa);
//                } else {
//                    SalvarEmpresaTask salvarEmpresaTask = new SalvarEmpresaTask(getMyView());
//                    salvarEmpresaTask.execute(empresa);
//                }
            }
        });

    }


}
