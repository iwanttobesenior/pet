package org.example.application.infrastructure.transformation.transformer.cache;

import mockit.Expectations;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
import org.example.application.infrastructure.util.transformation.ReflectionUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collections;

import static org.junit.Assert.*;

@RunWith(JMockit.class)
public class CacheFieldProvider_Test {

    private FieldProvider provider;
    @Mocked
    private final ReflectionUtil reflectionUtil = null;

    @Before
    public void init() {
        provider = new CacheFieldProvider();
    }

    @Test
    public void testGetFieldNamesAreCachedUsing_JMockit() {
        new Expectations() {
            {
                ReflectionUtil.findSimilarFields(CacheFieldProviderTest.Source.class, CacheFieldProviderTest.Destination.class);
                result = Collections.singletonList("name");
            }
        };
        final var fields = provider.getFieldNames(CacheFieldProviderTest.Source.class, CacheFieldProviderTest.Destination.class);
        new Expectations() {
            {
                ReflectionUtil.findSimilarFields(CacheFieldProviderTest.Source.class, CacheFieldProviderTest.Destination.class);
                result = Collections.emptyList();
            }
        };
        assertTrue(ReflectionUtil.findSimilarFields(CacheFieldProviderTest.Source.class, CacheFieldProviderTest.Destination.class).isEmpty());
        final var fields2 = provider.getFieldNames(CacheFieldProviderTest.Source.class, CacheFieldProviderTest.Destination.class);
        assertFalse(fields.isEmpty());
        assertEquals(fields, fields2);

    }
}
