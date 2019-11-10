package com.arkadiusz.michalak.lecturesremover;

import com.arkadiusz.michalak.lecturesremover.exceptions.IncorrectParametersException;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        try {
            final String[] inputAndOutputFile = new ParametersRetriever().retrieveParametersFor(args);

            final String inputFile = inputAndOutputFile[0];
            final String outputFile = inputAndOutputFile[1];

            final CalendarFileReader reader = new CalendarFileReader();
            final LecturesRemover remover = new LecturesRemover();
            final CalendarFileWriter writer = new CalendarFileWriter();

            final List<String> inData = reader.readFile(inputFile);
            final List<String> outData = remover.removeLectures(inData);

            writer.writeCalendarData(outputFile, outData);

        } catch (IncorrectParametersException e) {
            System.out.println("ERROR: Expecting one or two args to be passed:");
            System.out.println("Option 1: <Input file name>");
            System.out.println("Option 2: <Input file name> <Output file name>");
        }
    }
}
