
package org.fogbeam.example.opennlp;

import org.fogbeam.example.opennlp.dinesh.StringTokenizer;

import java.io.*;

public class TokenizerMain {

    public static void main( String[] args ) throws Exception {

	    if (args.length > 0) {
	        for (final String filePath : args) {
	            StringTokenizer.tokenize(readStringFromFile(filePath));
            }
        } else {
	        // Demo mode.
            StringTokenizer.tokenize( "A ranger journeying with Oglethorpe, founder of the Georgia Colony, "
                    + " mentions \"three Mounts raised by the Indians over three of their Great Kings"
                    + " who were killed in the Wars.\"");
        }
	}

	private static String readStringFromFile(final String filePath) {

        String fileContents = "";
        try {
            final InputStream is = new FileInputStream(filePath);
            final BufferedReader buffer = new BufferedReader(new InputStreamReader(is));

            String line = buffer.readLine();
            final StringBuilder stringBuilder = new StringBuilder();
            while (line != null) {
                stringBuilder.append(line).append("\n");
                line = buffer.readLine();
            }
            fileContents = stringBuilder.toString();
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } catch (final IOException ioe) {
            ioe.printStackTrace();
        }

        return fileContents;
    }
}
