package com.arkadiusz.michalak.lecturesremover;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class CalendarFileWriter {

    public void writeCalendarData(String fileName, List<String> data) throws IOException {

        try (BufferedWriter br = new BufferedWriter(new FileWriter(fileName))
        ) {

            for (String datum : data) {
                br.write(datum);
                br.write('\n');
            }
        }
    }
}
