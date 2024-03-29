package br.com.springboot.restcourse.converter;

public class NumericConverter {

    public static Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");

        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    public static boolean isNumeric(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*.?[0-9]+");

    }

    public static boolean isZero(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");

//        if(isNumeric(number) return Double.parseDouble(number));

        return number.matches("[^1-9]+");
    }

    public static boolean isNegative(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");

        return number.matches("^(\\-(\\d*))$");
    }


}
