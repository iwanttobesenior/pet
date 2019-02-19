package org.example.application.infrastructure.util.check;

import org.example.application.infrastructure.exception.uncheked.execution.InvalidArgumentException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test cases for {@link Verifications}
 *
 * @author Kul'baka Alex
 */
public class VerificationsTest {

    @Test
    public void testCheckInvalidArgumentsThenThrowException() {
        final String msg = "test";
        try {
            Verifications.checkArguments(false, msg);
            fail();
        } catch (Exception e) {
            assertSame(e.getClass(), InvalidArgumentException.class);
            assertEquals(e.getMessage(), msg);
        }
    }

    @Test
    public void testSeveralCheckInvalidArgumentsThenThrowException() {
        final String msg = "test";
        try {
            Verifications.checkArguments(msg, true, false, true);
            fail();
        } catch (Exception e) {
            assertSame(e.getClass(), InvalidArgumentException.class);
            assertEquals(e.getMessage(), msg);
        }
    }

    @Test
    public void testCheckValidArgumentsNoException() {
        final String msg = "test";
        try {
            Verifications.checkArguments(true, msg);
            assertTrue(true);
        } catch (Exception w) {
            fail();
        }
    }

    @Test
    public void testSeveralCheckValidArgumentsNoException() {
        final String msg = "test";
        try {
            Verifications.checkArguments(msg, true, true, true, true, true);
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }
}
