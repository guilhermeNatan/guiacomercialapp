package android.guiacomercial;

import android.guiacomercial.asyncs.BuscarEmpresasTask;

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
