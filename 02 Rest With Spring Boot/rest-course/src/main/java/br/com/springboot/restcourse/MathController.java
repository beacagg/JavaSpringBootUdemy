package br.com.springboot.restcourse;

import br.com.springboot.restcourse.exception.UnsuportedMathOpExcept;
import org.springframework.web.bind.annotation.*;

// sub mult div media raiz quadrada

@RestController
public class MathController {

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {

            //throw new Exception();
            throw new UnsuportedMathOpExcept("Please set a numeric value.");
        }

        Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);

        return sum;
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathOpExcept("Please set a numeric value.");
        }

        Double sub = convertToDouble(numberOne) - convertToDouble(numberTwo);

        return sub;
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mult(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathOpExcept("Please set a numeric value.");
        }

        Double mult = (convertToDouble(numberOne) * convertToDouble(numberTwo));

        return mult;
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo) ) {
            throw new UnsuportedMathOpExcept("Please set a numeric value.");
        }

        if(isZero(numberOne) && isZero(numberTwo) || !isZero(numberOne) && isZero(numberTwo)) {

            throw new UnsuportedMathOpExcept("Error. Division by zero.");
        }

        Double div = (convertToDouble(numberOne) / convertToDouble(numberTwo));

        return div;
    }

    @RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double media(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo) ) {
            throw new UnsuportedMathOpExcept("Please set a numeric value.");
        }

        Double media = (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;

        return media;
    }

    @RequestMapping(value = "/square/{numberOne}", method = RequestMethod.GET)
    public Double square(@PathVariable("numberOne") String numberOne) throws Exception{

        if(!isNumeric(numberOne) ) {
            throw new UnsuportedMathOpExcept("Please set a numeric value.");
        }

        if(isNegative(numberOne)) {
            throw new UnsuportedMathOpExcept("NaN. Negative numbers do not have square roots.");
        }
        Double square = (Double) Math.sqrt(convertToDouble(numberOne));

        return square;
    }



   /*---------------- UTILS ------------------------*/
    private Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");

        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*.?[0-9]+");

    }

    private boolean isZero(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");

//        if(isNumeric(number) return Double.parseDouble(number));

        return number.matches("[^1-9]+");
    }

    private boolean isNegative(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");

        return number.matches("^(\\-(\\d*))$");
    }

}
