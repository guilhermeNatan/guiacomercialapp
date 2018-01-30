package android.guiacomercial;

import android.guiacomercial.model.Empresa;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void teste()
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        Empresa empresa = new Empresa("ssss", "bbb");

        String s = null;
        try {
            s= mapper.writeValueAsString(empresa);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(s);

        try {
            Empresa emp = mapper.readValue(s, Empresa.class);
            System.out.println(emp);
            System.out.println(emp.getNome());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void teste2()
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        ArrayList<Empresa> array = new ArrayList<Empresa>();
        array.add(new Empresa("ssss", "bbb"));
        array.add(new Empresa("adfadfafd", "cccc"));

        String s = null;
        try {
            s= mapper.writeValueAsString(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(s);
        s = "[{\"nome\":\"capelinha\",\"id\":1,\"nota\":60,\"descricao\":\"empresa de T.I\"}, {\"nome\":\"teste\",\"id\":3,\"nota\":20,\"descricao\":\"descricao\"}]";
        try {
            List<Empresa> emp = mapper.readValue(s, ArrayList.class);
            System.out.println(emp.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}