package android.guiacomercial.dao;

import android.guiacomercial.model.Empresa;
import android.support.annotation.NonNull;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by guilherme.natan on 21/01/2018.
 */

public class WebClient {

    public String post(String json)
    {
        try {
            URL url = new URL(Paths.EMPRESAS);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setReadTimeout(15*1000);
            PrintStream printStream = new PrintStream(connection.getOutputStream());
            printStream.println(json);
            connection.connect();
            Scanner scanner = new Scanner(connection.getInputStream());
            String resposta = scanner.next();
            return  resposta;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public List<Empresa> get()
    {
        try {
            URL url = new URL(Paths.EMPRESAS);
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestMethod("GET");
            connection.setReadTimeout(15*1000);
            connection.connect();
            Scanner scanner = new Scanner(connection.getInputStream());
            String resposta = new String();
            while (scanner.hasNext())
            {
                resposta = resposta + scanner.next();
            }
            ArrayList<Empresa> emp = mapper.readValue(resposta, new TypeReference<ArrayList<Empresa>>(){});
            return emp;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    public String delete(Long  idEmpresa) {
        try {
            URL url = new URL(Paths.EMPRESAS + "/" + idEmpresa);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setRequestMethod("DELETE");
            connection.setReadTimeout(15 * 1000);
            Scanner scanner = new Scanner(connection.getInputStream());
            String resposta = new String();
            while (scanner.hasNext()) {
                resposta = resposta + scanner.next();
            }
            return resposta;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
