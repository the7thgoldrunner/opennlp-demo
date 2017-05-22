package org.fogbeam.example.opennlp.tests.org.fogbeam.example.opennlp.tests;

import junit.framework.TestCase;
import org.fogbeam.example.opennlp.dinesh.StringTokenizer;

public class StringTokenizerTestCase extends TestCase {

    public void testNullInput() {
        String[] tokens = StringTokenizer.tokenize(null);

        assertEquals(0, tokens.length);
    }

    public void testEmptyInput() {
        final String emptyString = "";
        String[] tokens = StringTokenizer.tokenize(emptyString);

        assertEquals(0, tokens.length);
    }

    public void testText() {
        final String inputText = "A ranger journeying with Oglethorpe, founder of the Georgia Colony, "
                + " mentions \"three Mounts raised by the Indians over three of their Great Kings"
                + " who were killed in the Wars.\"";
        String[] tokens = StringTokenizer.tokenize(inputText);

        assertEquals(33, tokens.length);
    }
}
