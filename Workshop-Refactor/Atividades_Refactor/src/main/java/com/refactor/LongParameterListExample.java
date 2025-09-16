
package com.refactor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * EXERCÍCIO: Code Smell - Long Parameter List
 * Objetivo:
 *  - Introduce Parameter Object: criar MeetingOptions e substituir a lista longa
 * Critério de aceite:
 *  - Método com até 3 parâmetros
 */
public class LongParameterListExample {

    // TODO: transformar esta assinatura usando um objeto de parâmetros.
    public String scheduleMeeting(String title,
                                  LocalDate date,
                                  LocalTime start,
                                  LocalTime end,
                                  String room,
                                  boolean online,
                                  String meetingLink,
                                  List<String> participants) {
        String mode = online ? ("ONLINE (" + meetingLink + ")") : ("ROOM " + room);
        return "%s on %s from %s to %s, %s, participants=%d"
                .formatted(title, date, start, end, mode, participants.size());
    }
}
