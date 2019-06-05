import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadFrameworkProperties {
    //init Log4j2 logger
    private static Logger log = LogManager.getLogger();

    private Properties prop = null;

    public LoadFrameworkProperties() {
        InputStream is;
        try {
            this.prop = new Properties();
            is = this.getClass().getResourceAsStream("acorn.properties");
            prop.load(is);
        } catch (FileNotFoundException e) {
            log.error("The acorn.properties file was not found.  Did you create one?", e);
        } catch (IOException e) {
            log.error("There was an io exception getting the properties file.", e);
        }
    }

    public String getPropertyValue(String key){
        return this.prop.getProperty(key);
    }

    public Properties getProps() {
        return prop;
    }


    public static void main(String a[]){
        LoadFrameworkProperties lfp = new LoadFrameworkProperties();

        FrameworkVariables.username = lfp.getPropertyValue("username");
        FrameworkVariables.password = lfp.getPropertyValue("passwword");
        FrameworkVariables.loginEndpoint = lfp.getPropertyValue("loginEndpoint");

        log.info("The username is: " + FrameworkVariables.username);
        log.info("The password is: " + FrameworkVariables.password);
        log.info("The loginEndpoint is: " + FrameworkVariables.loginEndpoint);

    }

}
