package com.arkadiusz.michalak.lecturesremover;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CalendarFileReader {

    public List<String> readFile(String fileName) throws IOException {

        List<String> result = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))
        ) {
            while (br.ready()) {
                result.add(br.readLine());
            }
        }

        return result;
    }

}
