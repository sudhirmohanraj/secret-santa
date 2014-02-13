package go.health.programming.dev.Impl;

import go.health.programming.dev.Impl.util.SecretSantaUtil;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Implementation for Secret Santa Idea.
 * @author mohanraj,sudhir
 */
public class SecretSantaImpl {
    public static void main(final String[] args) throws IOException {
        final String[] assignments = SecretSantaUtil.readFile("src/test/resources/assignmentsList.txt");
        generateAssignments(assignments);
    }

    /**
     * <p>
     * <ol>
     * <li>Number of participants must be greater than 1.</li>
     * <li>Numbers,unicode characters and words are supported as input</li>
     * </ol>
     * </p>
     * @param participants list of individuals participating in the draw.
     * @return the list of individuals paired with the participants where participants[0] is matched with
     *         assignments[0], participants[1] is matched with assignments[1], and so on.
     */
    public static String[] generateAssignments(final String[] participants) {
        if (participants.length > 1) {
            final int size = participants.length;
            final Set<Integer> numbers = new HashSet<Integer>();
            final Set<String> assignmentsList = new HashSet<String>();
            int temp = SecretSantaUtil.randInt(1, size, 1);
            numbers.add(temp);
            assignmentsList.add(participants[temp - 1]);
            while (numbers.size() < size) {
                temp = SecretSantaUtil.randInt(1, size, numbers.size() + 1);
                numbers.add(temp);
                assignmentsList.add(participants[temp - 1]);
                if (assignmentsList.size() == temp - 1) {
                    assignmentsList.remove(participants[temp - 1]);
                    numbers.remove(temp);
                }
            }

            // again logging this is the way to go about it.
            System.out.println(assignmentsList);
            // converting back to a string array since it is the requirement.
            final String[] individualParticipantsList = SecretSantaUtil.setToStringArrayConversion(participants.length,
                    assignmentsList);
            return individualParticipantsList;
        }
        // Logging this error is the way to go about it, do it a later point.
        System.out.println("Cannot assign the participants please verify your input");
        return participants;
    }

}
