package org.example.application.infrastructure.transformation.transformer.cache;

import org.example.application.infrastructure.transformation.transformer.impl.SimpleDTOTransformer;
import org.example.application.infrastructure.util.transformation.ReflectionUtil;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


/**
 * Verifies functionality of the {@link SimpleDTOTransformer} unit
 * Specify class {@link ReflectionUtil} that will be mocked
 *
 * @author Kul'baka Alex
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ReflectionUtil.class)
public class CacheFieldProviderTest {

    private FieldProvider provider;

    @Before
    public void init() {
        provider = new CacheFieldProvider();
    }

    @Ignore
    @Test
    public void testGetFieldNamesAreCached() {
        final var fields = provider.getFieldNames(Source.class, Destination.class);

        PowerMockito.mockStatic(ReflectionUtil.class);
        when(ReflectionUtil.findSimilarFields(Source.class, Destination.class)).thenReturn(Collections.emptyList());

        assertTrue(ReflectionUtil.findSimilarFields(Source.class, Destination.class).isEmpty());
        final var fields2 = provider.getFieldNames(Source.class, Destination.class);
        assertFalse(fields.isEmpty());
        assertEquals(fields, fields2);
    }

    @Ignore
    @Test
    public void testGetFieldNamesCached_Success() {
        final var filds1 = provider.getFieldNames(Source.class, Destination.class);
        final var filds2 = provider.getFieldNames(Source.class, Destination.class);
        assertFalse(filds1.isEmpty());
        assertFalse(filds2.isEmpty());
        assertEquals(filds1, filds2);
    }

    @Ignore
    @Test
    public void testGetFieldNames_Success() {
        final var fields = provider.getFieldNames(Source.class, Destination.class);
        assertFalse(fields.isEmpty());
        assertTrue(fields.contains("value"));
    }

    public final class Source {
        private int value;
    }

    public final class Destination {
        private int value;
    }
}


