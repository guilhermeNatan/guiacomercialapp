package android.guiacomercial;

import android.app.Fragment;
import android.guiacomercial.asyncs.BuscarEmpresasTask;
import android.guiacomercial.model.Empresa;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

/**
 * Created by guilherme.natan on 27/01/2018.
 */

public class ListarEmpresasFragment extends BaseFragment {

    @Override
    protected void executar() {
        montarListaDempresa();
    }

    private void montarListaDempresa()
    {
        BuscarEmpresasTask buscarTarefaTask =
                new BuscarEmpresasTask(getActivity());
        buscarTarefaTask.execute();
    }

    @Override
    public int getLayoutParaInflar() {
        return R.layout.listar_empresas;
    }

}
