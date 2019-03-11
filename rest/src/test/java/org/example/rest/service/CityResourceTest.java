package org.example.rest.service;

import org.example.rest.configuration.JerseyConfig;
import org.example.service.infrastructure.dto.geography.CityDTO;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Integration test
 * Test service as web service
 * via jersey test
 */
public class CityResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new JerseyConfig();
    }

    @Test
    public void testFindCities_Success() {
        final var result = target("/cities").request().get(List.class);

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    /**
     * Jersey as Jax-rs provider may convert {@link Response} object to Java type inside it
     * {@code request().get()}
     */
    @Test
    public void testFindCityById_success() {
        final var dto = target("/cities/1").request().get(CityDTO.class);

        assertNotNull(dto);
        assertEquals(1L, dto.getId());
        assertEquals("Copenhagen", dto.getName());
    }

    @Test
    public void testFindCityByInvalidId_fail() {
        final var response = target("/cities/impermissible").request().get(Response.class);

        assertNotNull(response);
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }

    @Test
    public void testFindCityByNonexistentId_Fail() {
        final var response = target("/cities/404").request().get(Response.class);

        assertNotNull(response);
        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
    }

    @Test
    public void testSaveNewCity_success() {
        final var newCity = new CityDTO();
        newCity.setName("yokohama");
        newCity.setId(10000);

        final var response = target("/cities").request().post(Entity.entity(newCity, MediaType.APPLICATION_JSON));

        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());
    }
}
