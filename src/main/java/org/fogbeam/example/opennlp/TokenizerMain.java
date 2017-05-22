
package org.fogbeam.example.opennlp;

import org.fogbeam.example.opennlp.dinesh.StringTokenizer;

import java.io.*;

public class TokenizerMain {

    public static void main( String[] args ) throws Exception {

	    if (args.length > 0) {
	        for (final String filePath : args) {
	            String[] tokens = StringTokenizer.tokenize(readStringFromFile(filePath));

	            for(String token : tokens) {
                    System.out.println( token );
                }
                System.out.println( "\n-----\ndone" );
            }
        } else {
            System.out.println( "Sorry! We were expecting input arguments to the desired files :(\n" );
        }
	}

    /**
     * Method for reading {@link String}s from a file.
     *
     * @param filePath path to the file we want to read from where the app is executed.
     * @return a {@link String} with the contents of the file, which might be empty.
     */
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
