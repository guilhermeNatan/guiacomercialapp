package android.guiacomercial.converters;

import android.guiacomercial.model.Empresa;

import org.json.JSONException;
import org.json.JSONStringer;

/**
 * Created by guilherme.natan on 21/01/2018.
 */
public class EmpresaConverter {

    public String converter(Empresa empresa)
    {
        JSONStringer json = new JSONStringer();

        try {
            json = json.object();
            if (empresa.getId() != null) {
                json.key("id").value(empresa.getId());
            }
            json.key("nome").value(empresa.getNome())
                    .key("nota").value(empresa.getNota())
                    .key("descricao").value(empresa.getDescricao()).endObject();

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json.toString();

    }
}
