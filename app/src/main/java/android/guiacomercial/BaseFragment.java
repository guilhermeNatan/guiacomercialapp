package android.guiacomercial;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lombok.Getter;

/**
 * Created by guilherme.natan on 27/01/2018.
 */

public abstract  class BaseFragment extends Fragment {

    @Getter
    private View myView;
    @Getter
    private Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(getLayoutParaInflar(),container,false);
        context = myView.getContext();
        executar();
        return myView;
    }

    protected abstract void executar();


    public abstract  int getLayoutParaInflar();
}
