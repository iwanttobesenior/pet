package org.example.service.service.infrastructure.transformation.cache;

import mockit.Mock;
import mockit.MockUp;
import org.example.application.infrastructure.util.transformation.ReflectionUtil;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class CacheFieldProvider_Test_ {

    private FieldProvider provider;

    @Before
    public void init() {
        provider = new CacheFieldProvider();
    }

    public static final class MockReflectionUtil extends MockUp<ReflectionUtil> {
        protected static List<String> fields;

        @Mock
        public static List<String> findSimilarFields(Class<?> clz1, Class<?> clz2) {
            return fields;
        }
    }

    @Ignore
    @Test
    public void testGetFieldNamesAreCachedUsingMockupsAPI() {
        new MockReflectionUtil();

        MockReflectionUtil.fields = Collections.singletonList("name");

        List<String> fields = provider.getFieldNames(CacheFieldProviderTest.Source.class, CacheFieldProviderTest.Destination.class);

        MockReflectionUtil.fields = Collections.emptyList();

        assertTrue(ReflectionUtil.findSimilarFields(CacheFieldProviderTest.Source.class, CacheFieldProviderTest.Destination.class).isEmpty());
        List<String> fields2 = provider.getFieldNames(CacheFieldProviderTest.Source.class, CacheFieldProviderTest.Destination.class);
        assertFalse(fields.isEmpty());
        assertEquals(fields, fields2);
    }
}
