package android.guiacomercial;

import android.app.Fragment;
import android.guiacomercial.converters.Converter;
import android.guiacomercial.model.Empresa;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Fragment para visuazliar ma empresa
 * Created by guilherme.natan on 31/01/2018.
 */

public class VisualizarEmpresaFragment extends BaseFragment {

    @Override
    protected void executar() {
        atribuirValores();
    }

    private void atribuirValores() {
        Converter<Empresa> converter = new Converter<>();
        Empresa empresa = converter.converterStringEntidade(
                this.getArguments().getString(Empresa.key), Empresa.class);
        TextView nome = getMyView().findViewById(R.id.txt_visualizar_nomeempresa);
        TextView nota = getMyView().findViewById(R.id.txt_visualizar_notaempresa);
        TextView descricao = getMyView().findViewById(R.id.txt_descricaoempresa);
        nome.setText(empresa.getNome());
        nota.setText("Nota: "+empresa.getNota().toString());
        descricao.setText(empresa.getDescricao());
    }

    @Override
    public int getLayoutParaInflar() {
        return R.layout.visualizar_empresa;
    }
}
