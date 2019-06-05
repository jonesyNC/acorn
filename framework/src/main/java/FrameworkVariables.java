/**
 * FrameworkVariables is static class for framework wide global variables.
 */
public final class FrameworkVariables {

    //These are set in LoadFrameworkProperties
    public static String username;
    public static String password;
    public static String loginEndpoint;


    //Don't allow class to be instantiated by marking constructor as private.
    private FrameworkVariables () {
    }

}
