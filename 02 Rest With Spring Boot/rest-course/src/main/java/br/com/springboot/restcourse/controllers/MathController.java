package br.com.springboot.restcourse.controllers;

import br.com.springboot.restcourse.converter.NumericConverter;
import br.com.springboot.restcourse.exception.UnsuportedMathOpExcept;
import br.com.springboot.restcourse.math.SimpleMathOps;
import org.springframework.web.bind.annotation.*;


@RestController
public class MathController {

    private SimpleMathOps math = new SimpleMathOps();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!NumericConverter.isNumeric(numberOne) || !NumericConverter.isNumeric(numberTwo)) {
            throw new UnsuportedMathOpExcept("Please set a numeric value.");
        }

        return math.sum(NumericConverter.convertToDouble(numberOne), NumericConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!NumericConverter.isNumeric(numberOne) || !NumericConverter.isNumeric(numberTwo)) {
            throw new UnsuportedMathOpExcept("Please set a numeric value.");
        }

        return math.sub(NumericConverter.convertToDouble(numberOne), NumericConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mult(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!NumericConverter.isNumeric(numberOne) || !NumericConverter.isNumeric(numberTwo)) {
            throw new UnsuportedMathOpExcept("Please set a numeric value.");
        }

        return math.mult(NumericConverter.convertToDouble(numberOne), NumericConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!NumericConverter.isNumeric(numberOne) || !NumericConverter.isNumeric(numberTwo)) {
            throw new UnsuportedMathOpExcept("Please set a numeric value.");
        }

        if (NumericConverter.isZero(numberOne) && NumericConverter.isZero(numberTwo)
                || !NumericConverter.isZero(numberOne) && NumericConverter.isZero(numberTwo)) {

            throw new UnsuportedMathOpExcept("Error. Division by zero.");
        }

        return math.div(NumericConverter.convertToDouble(numberOne), NumericConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double media(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!NumericConverter.isNumeric(numberOne) || !NumericConverter.isNumeric(numberTwo)) {
            throw new UnsuportedMathOpExcept("Please set a numeric value.");
        }
        return math.media(NumericConverter.convertToDouble(numberOne), NumericConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/square/{numberOne}", method = RequestMethod.GET)
    public Double square(@PathVariable("numberOne") String numberOne) throws Exception {

        if (!NumericConverter.isNumeric(numberOne)) {
            throw new UnsuportedMathOpExcept("Please set a numeric value.");
        }

        if (NumericConverter.isNegative(numberOne)) {
            throw new UnsuportedMathOpExcept("NaN. Negative numbers do not have square roots.");
        }
        return math.square(NumericConverter.convertToDouble(numberOne));
    }


}
