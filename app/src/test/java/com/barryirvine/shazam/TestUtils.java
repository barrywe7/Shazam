package com.barryirvine.shazam;

import com.barryirvine.shazam.network.IOUtils;

import org.junit.Assert;

import java.io.InputStream;

public class TestUtils {

    /**
     * Helper method that gets the string content of a file in the same package within the
     * resources directory as the test class
     *
     * @param fileResourceName The name of the file to be read
     * @param clazz            The class of the test
     * @return The string content of the file
     */

    public static String getFileContents(final String fileResourceName, final Class<?> clazz) {
        try {
            final InputStream inputStream = clazz.getResourceAsStream(fileResourceName);
            Assert.assertNotNull("File " + fileResourceName
                    + " not found in the classpath of " + clazz, inputStream);
            return IOUtils.convertUTF8StreamToString(inputStream);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }
}
