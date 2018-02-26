package android.guiacomercial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


/**
 * Created by guilherme.natan on 17/02/2018.
 */

public class  VisualizarEmpresaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_empresa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_layout);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

//        instanciarElementos();
    }

    public void instanciarElementos()
    {
//        Converter<Empresa> converter = new Converter<>();
//        Empresa empresa = converter.converterStringEntidade(getIntent().getExtras()
//                .getString(Empresa.key), Empresa.class);
//        TextView nome = findViewById(R.id.txt_visualizar_nomeempresa);
//        TextView nota = findViewById(R.id.txt_visualizar_notaempresa);
//        TextView descricao = findViewById(R.id.txt_descricaoempresa);
//        nome.setText(empresa.getNome());
//        nota.setText("Nota: "+empresa.getNota().toString());
//        descricao.setText(empresa.getDescricao());
    }
}
