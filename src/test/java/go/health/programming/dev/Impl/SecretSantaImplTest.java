package go.health.programming.dev.Impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import go.health.programming.dev.Impl.util.SecretSantaUtil;

import java.io.IOException;

import org.junit.Test;

/**
 * Tests {@link SecretSantaImpl}
 * @author mohanraj,sudhir
 */
public class SecretSantaImplTest {

    /**
     * Verifies the {@link SecretSantaImpl} with a valid Input File
     * @throws IOException {@link IOException}
     */
    @Test
    public void testSecretSantaWithValidInput() throws IOException {
        final SecretSantaImpl secretSantaImpl = new SecretSantaImpl();
        final String[] participants = SecretSantaUtil.readFile("src/test/resources/assignmentsList.txt");
        final String[] actualOutput = secretSantaImpl.generateAssignments(participants);
        assertEquals(participants.length, actualOutput.length);
        int i = 0;
        for (final String participant : participants) {
            assertFalse(participant.equals(actualOutput[i]));
            i++;
        }
    }

    /**
     * Verifies the {@link SecretSantaImpl} with an valid Input File of zero participants.
     * @see {@link SecretSantaImpl#generateAssignments(String[])}
     * @throws IOException {@link IOException}
     */
    @Test
    public void testSecretSantaWithInvalidInput() throws IOException {
        final SecretSantaImpl secretSantaImpl = new SecretSantaImpl();
        try {
            final String[] participants = SecretSantaUtil.readFile("src/test/resources/noParticipants.txt");
            final String[] actualOutput = secretSantaImpl.generateAssignments(participants);
        } catch (final IllegalArgumentException e) {
            assertEquals("n must be positive", e.getMessage());
        }

    }

    /**
     * Verifies the {@link SecretSantaImpl} with an Input File containing just numbers.
     * @throws IOException {@link IOException}
     */
    @Test
    public void testSecretSantaWithNumbersInput() throws IOException {
        final SecretSantaImpl secretSantaImpl = new SecretSantaImpl();
        final String[] participants = SecretSantaUtil.readFile("src/test/resources/numbers.txt");
        final String[] actualOutput = secretSantaImpl.generateAssignments(participants);
        assertEquals(participants.length, actualOutput.length);
    }

    /**
     * Verifies the {@link SecretSantaImpl} with an Input File containing random ascii characters.
     * @throws IOException {@link IOException}
     */
    @Test
    public void testSecretSantaWithUnicodeCharactersInput() throws IOException {
        final SecretSantaImpl secretSantaImpl = new SecretSantaImpl();
        final String[] participants = SecretSantaUtil.readFile("src/test/resources/random.txt");
        final String[] actualOutput = secretSantaImpl.generateAssignments(participants);
        assertEquals(participants.length, actualOutput.length);
    }

}
