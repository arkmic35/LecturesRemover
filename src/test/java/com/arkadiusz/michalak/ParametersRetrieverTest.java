package com.arkadiusz.michalak;

import com.arkadiusz.michalak.lecturesremover.ParametersRetriever;
import com.arkadiusz.michalak.lecturesremover.exceptions.IncorrectParametersException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParametersRetrieverTest {


    @Test
    void emptyArgs_throwException() {

        Assertions.assertThrows(IncorrectParametersException.class, () ->
                new ParametersRetriever().retrieveParametersFor(null));
    }

    @Test
    void zeroArgs_throwException() {

        Assertions.assertThrows(IncorrectParametersException.class, () -> new ParametersRetriever().retrieveParametersFor(new String[]{}));
    }

    @Test
    void threeArgs_throwException() {

        Assertions.assertThrows(IncorrectParametersException.class, () -> new ParametersRetriever().retrieveParametersFor(new String[]{"A", "B", "C"}));
    }

    @Test
    void onlyInputFileWithoutExtProvided_addPostfixToMakeOutputFile() {

        final String in = "input";
        final String expectOut = "input.out";
        final String[] result = new ParametersRetriever().retrieveParametersFor(new String[]{in});

        Assertions.assertArrayEquals(new String[]{in, expectOut}, result);
    }

    @Test
    void onlyInputFileWithExtProvided_addInfixToMakeOutputFile() {

        final String in = "input.data.txt";
        final String expectOut = "input.data.out.txt";
        final String[] result = new ParametersRetriever().retrieveParametersFor(new String[]{in});

        Assertions.assertArrayEquals(new String[]{in, expectOut}, result);
    }

    @Test
    void twoCorrectParamsProvided_returnThem() {
        final String in = "input.txt";
        final String out = "output.txt";
        final String[] result = new ParametersRetriever().retrieveParametersFor(new String[]{in, out});

        Assertions.assertArrayEquals(new String[]{in, out}, result);
    }
}