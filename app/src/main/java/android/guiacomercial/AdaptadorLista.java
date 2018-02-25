package android.guiacomercial;

import android.app.Activity;
import android.guiacomercial.asyncs.BuscarUmaEmpresaTask;
import android.guiacomercial.asyncs.ExcluirEmpresaTask;
import android.guiacomercial.converters.Converter;
import android.guiacomercial.model.Empresa;
import android.guiacomercial.util.IntentBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Edaptador da lista de empresas.
 *
 * Created by guilherme.natan on 14/01/2018.
 */

public class AdaptadorLista extends BaseAdapter {

    private  List<Empresa> empresas;
    private final Activity activity;

    public AdaptadorLista(List<Empresa> empresas, Activity activity) {
        this.empresas = empresas;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return empresas.size();
    }

    @Override
    public Object getItem(int i) {
        return empresas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return empresas.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final View itemLista = activity.getLayoutInflater()
                .inflate(R.layout.item_empresa, viewGroup, false);
        final Empresa empresa = empresas.get(i);
        TextView texto = itemLista.findViewById(R.id.item_lista_empresa);
        texto.setText(empresa.getNome().toUpperCase());
        configurarBtnExcluir(itemLista, empresa);
        configurarBtnVisualizar(itemLista,empresa);
        configurarBtnEditar(itemLista, empresa);
        return itemLista;
    }

    private void configurarBtnEditar(final View itemLista, final Empresa empresa) {
        Button editar = itemLista.findViewById(R.id.btn_editarempresa);
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BuscarUmaEmpresaTask buscarUmaEmpresaTask = new BuscarUmaEmpresaTask(activity);
                buscarUmaEmpresaTask.execute(empresa.getId());

            }
        });
    }

    private void configurarBtnExcluir(View itemLista, final Empresa empresa) {
        Button excluir = itemLista.findViewById(R.id.btn_excluirempresa);
        excluir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ExcluirEmpresaTask excluir = new ExcluirEmpresaTask(activity);
                    excluir.execute(empresa.getId());
                }
        });
    }

    private void configurarBtnVisualizar(final View itemLista, final Empresa empresa) {
        Button visualizar = itemLista.findViewById(R.id.btn_visualizarempresa);
        visualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IntentBuilder builder = new IntentBuilder(activity, VisualizarEmpresaActivity.class);
                Converter<Empresa> converter = new Converter<>();
                builder
                        .put(Empresa.key, converter.converterEntidadeString(empresa))
                        .navergar();
            }
        });
    }


}
