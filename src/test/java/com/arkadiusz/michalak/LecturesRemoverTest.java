package com.arkadiusz.michalak;

import com.arkadiusz.michalak.lecturesremover.CalendarFileReader;
import com.arkadiusz.michalak.lecturesremover.LecturesRemover;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;


import static org.assertj.core.api.Assertions.*;


class LecturesRemoverTest {

    @Test
    void testCase1() throws IOException {

        List<String> in = new CalendarFileReader().readFile("src/test/resources/TestCase1.in.txt");
        List<String> out = new CalendarFileReader().readFile("src/test/resources/TestCase1.out.txt");

        List<String> result = new LecturesRemover().removeLectures(in);

        assertThat(result).isEqualTo(out);
    }
}