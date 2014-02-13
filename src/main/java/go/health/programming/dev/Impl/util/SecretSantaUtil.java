package go.health.programming.dev.Impl.util;

import go.health.programming.dev.Impl.SecretSantaImpl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Utility Class for {@link SecretSantaImpl}
 * @author mohanraj,sudhir
 */
public class SecretSantaUtil {
    /**
     * Returns a pseudo-random number between min and max, inclusive. The difference between min and max can be at most
     * <code>Integer.MAX_VALUE - 1</code>.
     * @param min Minimum value
     * @param max Maximum value. Must be greater than min.
     * @param exclude the value that should not be generated. Must be greater than min.
     * @return Integer between min and max, inclusive.
     * @see java.util.Random#nextInt(int);
     */
    public static int randInt(final int min, final int max, final int exclude) {
        final Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        while (randomNum == exclude) {
            randomNum = rand.nextInt((max - min) + 1) + min;
        }
        return randomNum;
    }

    /**
     * @param filename input file name
     * @return an array of strings
     * @throws IOException {@link IOException}
     */
    public static String[] readFile(final String filename) throws IOException {
        final List<String> individualParticipantsList = new ArrayList();
        final FileInputStream fstream = new FileInputStream(filename);
        final BufferedReader in = new BufferedReader(new FileReader(filename));
        final int length = 0;
        while (in.ready()) {
            final String s = in.readLine();
            individualParticipantsList.add(s);
        }
        in.close();
        final String[] individualParticipants = listToStringArrayCnversion(individualParticipantsList);
        return individualParticipants;
    }

    /**
     * @param individualParticipantsList the input {@link List}
     * @return String array representation of the input
     */
    private static String[] listToStringArrayCnversion(final List<String> individualParticipantsList) {
        final String[] individualParticipants = new String[individualParticipantsList.size()];
        int numberOfParticipants = 0;
        for (final String individualParticipantsname : individualParticipantsList) {
            individualParticipants[numberOfParticipants] = individualParticipantsname;
            numberOfParticipants++;
        }
        return individualParticipants;
    }

    /**
     * @param participants number of participants in the game.
     * @param assignmentsList randomized assignees by {@link SecretSantaImpl#generateAssignments(String[])} in Set form.
     * @return reassigned assignees for the participants in String array form.
     */
    public static String[] setToStringArrayConversion(final int participants, final Set<String> assignmentsList) {
        int numberOfParticipants = 0;
        final String[] individualParticipantsList = new String[participants];
        for (final String individualParticipantsname : assignmentsList) {
            individualParticipantsList[numberOfParticipants] = individualParticipantsname;
            numberOfParticipants++;
        }
        return individualParticipantsList;
    }
}
