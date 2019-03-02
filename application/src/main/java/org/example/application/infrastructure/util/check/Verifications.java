package org.example.application.infrastructure.util.check;

import org.example.application.infrastructure.exception.uncheked.execution.InvalidArgumentException;

/**
 * Util argument checker class
 *
 * @author Kul'baka Alex
 */
public class Verifications {

    /**
     * @throws UnsupportedOperationException if someone tries create instant of this class via reflection
     */
    private Verifications() {
        throw new UnsupportedOperationException("you should't create instance of utility class");
    }

    /**
     * validation check the passed expression
     *
     * @param message for description exception if it will occur
     * @throws InvalidArgumentException if expression is {@code false}
     */
    public static void verifyArg(final boolean expresion, final String message) {
        if (!expresion) {
            throw new InvalidArgumentException(message);
        }
    }

    /**
     * validation check the passed array of expression
     *
     * @param message for description exception if it will occur
     * @throws InvalidArgumentException if any of arguments is {@code false}
     */
    public static void verifyArg(final String message, final boolean... expressions) {
        for (boolean expresion : expressions) {
            if (!expresion) {
                throw new InvalidArgumentException(message);
            }
        }
    }

    /**
     * Check specific objects
     *
     * @throws InvalidArgumentException if any of arguments is {@code null}
     */
    public static void verifyArg(final Object param, final Class<?> clazz) {
        verifyArg(param != null, "Source transformation object is not initialized");
        verifyArg(clazz != null, "No class is defined for transformation");
    }
}
