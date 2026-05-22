package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {


    public static final String BASE_URL;
    public static final String USER;
    public static final String PASSWORD;

    static {
        Properties props = new Properties();
        try (InputStream input =
                     ConfigProperties.class.getClassLoader().getResourceAsStream("setup.properties")) {

            if (input == null) {
                throw new RuntimeException("Arquivo setup.properties não encontrado em src/test/resources.");
            }

            props.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar o arquivo setup.properties", e);
        }

        BASE_URL = props.getProperty("base.url");
        USER = props.getProperty("base.user");
        PASSWORD = props.getProperty("base.password");

    }

//    private ConfigProperties() {
//        // evita instância
//    }


}
