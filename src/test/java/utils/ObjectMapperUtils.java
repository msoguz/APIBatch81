package utils;


import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;

public class ObjectMapperUtils {
    //new ObjectMapper().readValue(jsonInString,HashMap.class);


    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();

    }

    public static <T> T convertJsonToJava(String json, Class<T> cls){   // Burada T type demek. Json'i Javaya ceviriyoruz.
                                                                        // Data tipini bilmedigimiz icin T'yi kullaniyoruz.
        T javaresult =null;
        try {     // Burada try catch (throw) kullanmamizin sebebi, throws olsaydi baska yerde de isteyecekti. Baska yerde de
            javaresult= mapper.readValue(json,cls);      // throws istememesi icin try catch yaptik..
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return javaresult;
    }

}
