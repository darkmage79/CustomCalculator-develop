package erm.customcalculator.classes;

/**
 * Created by Logan on 1/31/2016.
 */
public class Utils {
    public static boolean isValidString(String str){
        return str!=null&&str.length()>0;
    }
    public static Double tryCastDouble(String dbl, Double dblIfFail){
        try{
            return Double.parseDouble(dbl);
        } catch (Exception e){
            return dblIfFail;
        }
    }
}
