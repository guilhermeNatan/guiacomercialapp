package android.guiacomercial.converters;

import android.guiacomercial.model.Empresa;
import android.guiacomercial.model.EntidadeBase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

/**
 * Classe usada para fazer conversão de entendades em objtos json e vice versa .
 * Created by guilherme.natan on 21/01/2018.
 */
public class Converter<T extends EntidadeBase> {


    public  String converterEntidadeString(T entidade)
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        String s = null;
        try {
            s= mapper.writeValueAsString(entidade);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    public  T converterStringEntidade(String json, Class<T> clazz)
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        try {
            return  mapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
