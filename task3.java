import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.HashMap;
import java.util.List;

public class task3 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String jsonTests = null;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        jsonTests = stringBuilder.toString();
        System.out.print(jsonTests);
        System.out.println();
        reader.close();

        BufferedReader reader1 = new BufferedReader(new FileReader(args[1]));
        String line1 = null;
        StringBuilder stringBuilder1 = new StringBuilder();
        String jsonValues = null;
        while ((line1 = reader1.readLine()) != null) {
            stringBuilder1.append(line1);
        }
        jsonValues = stringBuilder1.toString();
        System.out.print(jsonValues);
        System.out.println();
        reader1.close();

        HashMap<Integer, String> valuemap = new HashMap<>();
        /*String jsonTests = "{\"id\": 122,\"title\": \"Security test\",\"value\": \"\",\"values\":" +
                "[{\"id\": 5321,\"title\": \"Confidentiality\",\"value\": \"\"}," +
                "{\"id\": 5322,\"title\": \"Integrity\",\"value\": \"\"}]}";

        String jsonValues = "{\"values\":[{\"id\": 122,\"value\": \"failed\"}," +
                "{\"id\": 5321,\"value\": \"passed\"}," +
                "{\"id\": 5322,\"value\": \"failed\"}]}";*/
        ObjectMapper mapper = new ObjectMapper();
        Tests tests = mapper.readValue(jsonTests, Tests.class);
        AllValues allValues = mapper.readValue(jsonValues, AllValues.class);
        //словарь
        for (Values v : allValues.values) {
            valuemap.put(v.id, v.value);
        }
        // в tests в параметр value
        for (Test t : tests.tests) {
            t.value = valuemap.get(t.id);
            //в tests в структуру values
            if (t.values !=null) {
                for (Values v : t.values) {
                    v.value = valuemap.get(v.id);
                }
            }
        }

        StringWriter writer = new StringWriter();
        // сериализация
        mapper.writeValue(writer, tests);
        //преобразовываем все записанное во StringWriter в строку
        String result = writer.toString();
        System.out.println(result);
    }
}
class Tests {
       public List<Test> tests;
}

class Test {
       public int id;
       public String title;
       public String value;
       public List<Values> values;

}
class Values {
        public int id;
        public String title;
        public String value;
}

class AllValues {
        public List<Values> values;
}
