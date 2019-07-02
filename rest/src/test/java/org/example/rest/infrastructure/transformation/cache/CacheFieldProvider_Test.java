package org.example.rest.infrastructure.transformation.cache;

import mockit.Expectations;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
import org.example.application.infrastructure.util.reflection.ReflectionUtil;
import org.example.service.infrastructure.transformation.cache.CacheFieldProvider;
import org.example.service.infrastructure.transformation.cache.FieldProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
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

    @Ignore
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
        Assert.assertEquals(fields, fields2);

    }
}
