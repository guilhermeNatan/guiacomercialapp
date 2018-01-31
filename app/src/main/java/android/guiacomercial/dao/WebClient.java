package android.guiacomercial.dao;

import android.guiacomercial.model.EntidadeBase;

import java.util.List;

/**
 * Created by guilherme.natan on 29/01/2018.
 */

public interface WebClient<T extends EntidadeBase> {
    String GET = "GET";
    String DELETE = "DELETE";
    String PUT = "PUT";

    String post(String json);

    String put(String json, Long id);

    List<T> get();

    String delete(Long id);

    T get(Long id);
}
