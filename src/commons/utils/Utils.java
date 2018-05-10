package commons.utils;

public class Utils {

    public static boolean isNulaOuVazia(String string){
        if(string == null){
            return true;
        }

        if(string.trim().isEmpty()){
            return true;
        }

        return false;
    }
}
