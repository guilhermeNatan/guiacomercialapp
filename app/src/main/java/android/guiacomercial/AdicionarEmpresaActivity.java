package android.guiacomercial;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.guiacomercial.asyncs.EditarEmpresaTask;
import android.guiacomercial.asyncs.SalvarEmpresaTask;
import android.guiacomercial.converters.Converter;
import android.guiacomercial.model.Empresa;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdicionarEmpresaActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Long idEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_empresa);

        mTextMessage = (TextView) findViewById(R.id.message);
        salvarEmpresa();

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorAccent)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(0);
    }


    private void salvarEmpresa() {
        final TextView nome = findViewById(R.id.cmp_nome_empresa);
        nome.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        final TextView descricao = findViewById(R.id.cmp_descricao_empresa);

        final Button salvar = (Button) findViewById(R.id.btn_salvarEmpresa);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Empresa empresa = new Empresa(nome.getText().toString(),
                        descricao.getText().toString());
                if (idEmpresa != null) {
                    empresa.setId(idEmpresa);
                    EditarEmpresaTask editarEmp = new EditarEmpresaTask(AdicionarEmpresaActivity.this, view, getBaseContext());
                    editarEmp.execute(empresa);
                } else {
                    SalvarEmpresaTask salvarEmpresaTask = new SalvarEmpresaTask(AdicionarEmpresaActivity.this, view, view.getContext());
                    salvarEmpresaTask.execute(empresa);
                }
            }
        });

    }



//    private void carregarParaAlterar() {
//        if(this.getArguments()!=null && this.getArguments().getString(Empresa.key)!=null)
//        {
//            Converter<Empresa> converter = new Converter<>();
//            Empresa empresa = converter.converterStringEntidade(
//                    this.getArguments().getString(Empresa.key), Empresa.class);
//            final TextView nome = getMyView().findViewById(R.id.cmp_nome_empresa);
//            final TextView descricao = getMyView().findViewById(R.id.cmp_descricao_empresa);
//            nome.setText(empresa.getNome());
//            descricao.setText(empresa.getDescricao());
//            idEmpresa = empresa.getId();
//        }
//    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }

        return false;
    }


}
