package com.arkadiusz.michalak.lecturesremover;

import com.arkadiusz.michalak.lecturesremover.exceptions.IncorrectParametersException;

public class ParametersRetriever {

    public String[] retrieveParametersFor(String[] args) throws IncorrectParametersException {

        if (args == null || args.length == 0 || args.length > 2) {
            throw new IncorrectParametersException();
        }

        final String inputFile = args[0];
        final String outputFile = retrieveOutputFile(args);

        return new String[]{inputFile, outputFile};
    }

    private String retrieveOutputFile(String[] args) {
        if (args.length == 2) {
            return args[1];
        }

        String inFile = args[0];
        int dotPosition = inFile.lastIndexOf('.');

        if (dotPosition == -1) {
            return inFile + ".out";
        } else {
            return inFile.substring(0, dotPosition)
                    + ".out"
                    + inFile.substring(dotPosition);
        }
    }
}
