package org.example.rest.infrastructure.transformation.impl;

import org.example.application.domain.entity.geography.City;
import org.example.application.infrastructure.exception.uncheked.execution.InvalidArgumentException;
import org.example.rest.dto.geography.CityDTO;
import org.example.rest.infrastructure.transformation.ITransformer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * test for {@link SimpleDTOTransformer}
 *
 * @author Kul'baka ALex
 */
public class SimpleDTOITransformerTest {

    private ITransformer transformer;

    @Before
    public void init() {
        transformer = new SimpleDTOTransformer();
    }

    @Test
    public void testTransformEntityToDTO_Success() {
        final City entity = new City("odessa");

        CityDTO dto = transformer.transform(entity, CityDTO.class);

        assertSame(dto.getClass(), CityDTO.class);
        assertEquals(entity.getName(), dto.getName());
    }

    @Test(expected = InvalidArgumentException.class)
    public void testTransformEntityAsNullToDTO_Fail() {
        final City city = null;

        transformer.transform(city, CityDTO.class);

        fail();
    }

    @Test(expected = InvalidArgumentException.class)
    public void testTransformEntityToDTOasNull_Fail() {
        final City city = new City("Paris");

        final Class<CityDTO> dtoClass = null;

        transformer.transform(city, dtoClass);

        fail();
    }

    @Test
    public void testUntransformDTOToEntity_Success() {
        final CityDTO dto = new CityDTO();
        dto.setName("stuttgart");

        final City entity = transformer.untransform(dto, City.class);

        assertSame(entity.getClass(), City.class);
        assertEquals(dto.getName(), entity.getName());
    }

    @Test(expected = InvalidArgumentException.class)
    public void testUntransformDTOAsNullToEntity_fail() {
        final CityDTO dto = null;

        transformer.untransform(dto, City.class);

        fail();
    }

    @Test(expected = InvalidArgumentException.class)
    public void testUntransformDTOToEntityAsNull_fail() {
        final CityDTO dto = new CityDTO();
        dto.setName("basel");

        final Class<City> entity = null;

        transformer.untransform(dto, entity);

        fail();
    }
}
