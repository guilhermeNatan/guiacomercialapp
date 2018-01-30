package android.guiacomercial.dao;

import android.guiacomercial.model.Empresa;

import java.util.List;

/**
 * Created by guilherme.natan on 29/01/2018.
 */

public class WebClienteEmpresa extends  WebClientBase<Empresa> implements WebClient<Empresa> {

    @Override
    public String post(String json) {
        return  super.post(json, Paths.EMPRESAS);
    }

    @Override
    public String put(String json, Long id) {
        return super.put(json,Paths.EMPRESAS + "/" + 8);
    }

    @Override
    public List<Empresa> get() {
        return super.get(Paths.EMPRESAS, Empresa.class);
}

    @Override
    public String delete(Long id) {
        return super.delete(Paths.EMPRESAS + "/" + id);
    }
}
