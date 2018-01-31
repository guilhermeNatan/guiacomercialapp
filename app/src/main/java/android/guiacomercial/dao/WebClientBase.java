package android.guiacomercial.dao;

import android.guiacomercial.model.EntidadeBase;
import android.support.annotation.NonNull;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by guilherme.natan on 29/01/2018.
 */

public class WebClientBase<T extends EntidadeBase> {

    String post(String json, String servico)
    {
        try {
            URL url = new URL(servico);
            HttpURLConnection connection = getHttpURLConnection(url);
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

    String put(String json, String servico)
    {
        try {
            URL url = new URL(servico);
            HttpURLConnection connection = getHttpURLConnection(url);
            connection.setDoOutput(true);
            connection.setRequestMethod(WebClient.PUT);
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


    List<T> get(String servico, Class clazz) {
        try {
            URL url = new URL(servico);
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            HttpURLConnection connection = getHttpURLConnection(url);
            connection.setRequestMethod(WebClient.GET);
            connection.setReadTimeout(15 * 1000);
            connection.connect();
            Scanner scanner = new Scanner(connection.getInputStream());
            String resposta = new String();
            while (scanner.hasNext()) {
                resposta = resposta + scanner.next();
            }

            JavaType type = mapper.getTypeFactory().
                    constructCollectionType(ArrayList.class, clazz);
            ArrayList<T> emp = mapper.readValue(resposta, type);
            return emp;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }


    T getOne(String servico, Class clazz) {
        try {
            URL url = new URL(servico);
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            HttpURLConnection connection = getHttpURLConnection(url);
            connection.setRequestMethod(WebClient.GET);
            connection.setReadTimeout(15 * 1000);
            connection.connect();
            Scanner scanner = new Scanner(connection.getInputStream());
            String resposta = new String();
            while (scanner.hasNext()) {
                resposta = resposta + scanner.next();
            }
            return (T) mapper.readValue( resposta, clazz);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

     String delete(String servico) {
        try {
            URL url = new URL(servico);
            HttpURLConnection connection = getHttpURLConnection(url);
            connection.setDoOutput(true);
            connection.setRequestMethod(WebClient.DELETE);
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


    @NonNull
    private HttpURLConnection getHttpURLConnection(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Content-type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        return connection;
    }
}
