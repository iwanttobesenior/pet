package org.example.application.infrastructure.util.security;

import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

/**
 * Util class for security purposes
 *
 * @author Kul'baka Alex
 */
public final class SecurityUtil {

    /**
     * you should't create instance of util {@code class}
     */
    private SecurityUtil() {
        throw new UnsupportedOperationException("you should't create instance of utility class");
    }

    /**
     * SHA-256 algorithm
     *
     * @return encrypted {@code password}
     */
    public static String encryptSHA(final String password) {
        return Hashing.sha256().hashString(password, Charset.forName("UTF-8")).toString();
    }

    private static String generateSalt() {
        // TODO: 18.03.2019
        return null;
    }
}
