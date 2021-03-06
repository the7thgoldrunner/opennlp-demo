package org.fogbeam.example.opennlp.dinesh;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class StringTokenizer {

    private static final String ENGLISH_MODEL_PATH = "models/en-token.model";

    /**
     * Singleton class.
     *
     * We don't want this class to be instanced.
     */
    private StringTokenizer() {
        // Singleton
    }

    /**
     * Call this method if you'd like to have a {@link String}s contents split into tokens.
     *
     * @param s the {@link String} you'd like to tokenize.
     */
    public static String[] tokenize(final String s) {

        InputStream modelIn = null;
        String[] tokens = new String[0];

        String inputString = s;
        if (inputString == null) {
            inputString = "";
        }
        try {
            modelIn = new FileInputStream(StringTokenizer.ENGLISH_MODEL_PATH);
            TokenizerModel model = new TokenizerModel( modelIn );
            Tokenizer tokenizer = new TokenizerME(model);

            tokens = tokenizer.tokenize(inputString);
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } catch (final IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (modelIn != null) {
                try {
                    modelIn.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return tokens;
    }
}
