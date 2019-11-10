package com.arkadiusz.michalak.lecturesremover;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LecturesRemover {

    public List<String> removeLectures(List<String> in) {
        LinkedList<String> data = new LinkedList<>(in);
        ListIterator<String> iterator = data.listIterator();

        while (iterator.hasNext()) {
            String currentLine = iterator.next();

            if (currentLine.contains("SUMMARY:W ")) {
                while (iterator.hasPrevious()) {
                    String previous = iterator.previous();

                    iterator.remove();

                    if (previous.contains("BEGIN:VEVENT")) {
                        break;
                    }
                }

                while (iterator.hasNext()) {
                    String next = iterator.next();

                    iterator.remove();

                    if (next.contains("END:VEVENT")) {
                        break;
                    }
                }
            }
        }

        return data;
    }
}
