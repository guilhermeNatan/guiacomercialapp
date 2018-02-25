package android.guiacomercial.util;

import android.app.Activity;
import android.content.Intent;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by guilherme.natan on 25/02/2018.
 */


public class IntentBuilder {

    @Getter
    @Setter
    private  Class destino;
    @Getter
    @Setter
    private Activity  origem;

    private  Intent intent;



    public IntentBuilder(Activity origem, Class destino) {
        this.destino = destino;
        this.origem = origem;
        intent = new Intent(origem.getBaseContext(), destino);
    }

    public IntentBuilder put(String chave, Integer valor){
        intent.putExtra(chave, valor);
        return this;
    }

    public IntentBuilder put(String chave, Double valor){
        intent.putExtra(chave, valor);
        return this;
    }

    public IntentBuilder put(String chave, Serializable valor){
        intent.putExtra(chave, valor);
        return this;
    }
    public IntentBuilder put(String chave, String valor){
        intent.putExtra(chave, valor);
        return this;
    }
    public Intent build()
    {

        return  intent;
    }

    public void navergar()
    {
        origem.startActivity(build());
    }

    public static void navegar(Activity origem, Class destino){
        origem.startActivity(new Intent(origem.getBaseContext(), destino));
    }

}
