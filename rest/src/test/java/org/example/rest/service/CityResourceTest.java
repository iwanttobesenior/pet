package org.example.rest.service;

import org.example.application.domain.entity.geography.City;
import org.example.rest.configuration.JerseyConfig;
import org.example.service.infrastructure.dto.geography.CityDTO;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CompletionStage;

import static org.junit.Assert.*;

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

    //    @Test
//    public void testFindCities_Success() {
//        final var size = target("/cities").request().get(List.class).size();
//        final var result = target("/cities").request().get(List.class);
//
//        assertNotNull(result);
//        assertEquals(size, result.size());
//    }
//
//    /**
//     * Jersey as Jax-rs provider may convert {@link Response} object to Java type inside it
//     * {@code request().get()}
//     */
//    @Test
//    public void testFindCityById_success() {
//        final var dto = target("/cities/60").request().get(CityDTO.class);
//
//        assertNotNull(dto);
//        assertEquals(60L, dto.getId());
//        assertEquals("Copenhagen", dto.getName());
//    }
//
//    @Test
//    public void testFindCityByInvalidId_fail() {
//        final var response = target("/cities/impermissible").request().get(Response.class);
//
//        assertNotNull(response);
//        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
//    }
//
//    @Test
//    public void testFindCityByNonexistentId_Fail() {
//        final var response = target("/cities/404").request().get(Response.class);
//
//        assertNotNull(response);
//        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
//    }
//
    @Test
    public void testSaveNewCity_success() {

        Instant start = Instant.now();

        final var newCity = new CityDTO();


        newCity.setName("yokohamaCity");
        newCity.setDistrict("yokohamaCity");
        newCity.setRegion("yokohamaCity");

        final var response = target("/cities").request().post(Entity.entity(newCity, MediaType.APPLICATION_JSON));

        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());

        List<Map<String, String>> result = target("/cities").request().get(List.class);
        assertNotNull(result);
        assertTrue(result.stream().anyMatch(item -> item.get("name").equals("yokohamaCity")));

        Instant finish = Instant.now();
        System.out.println(Duration.between(start, finish).toMillis());
    }

    //    @Test
//    public void testSaveNewCity_success_reactive() {
//
//        Instant start = Instant.now();
//
//        final var newCity = new CityDTO();
//        newCity.setName("Reactive");
//        newCity.setDistrict("Reactive");
//        newCity.setRegion("Reactive");
//
//        CompletionStage<Response> completion = target().request("/cities")
//                .rx()
//                .post(Entity.entity(newCity, MediaType.APPLICATION_JSON));
//        completion.thenAccept(response -> {
//            assertEquals(response.getStatus(), Response.Status.NO_CONTENT.getStatusCode());
//
//            target("/cities").request().rx().get(Response.class).thenAccept(resp -> {
//                List<Map<String, String>> cities = (List<Map<String, String>>) resp.getEntity();
//                assertNotNull(cities);
//                assertTrue(cities.stream().anyMatch(item -> item.get("name").equals("Reactive")));
//            });
//        });
//
//        Instant finish = Instant.now();
//        System.out.println(Duration.between(start, finish).toMillis());
//    }
//    @SuppressWarnings("unchecked")
//    @Test
//    public void testSaveCitySuccess() throws Throwable {
//        var city = new CityDTO();
//        city.setName("Kiev");
//        city.setDistrict("Kiev");
//        city.setRegion("Kiev");
//
//        var cf = target("cities").request().rx()
//                .post(Entity.entity(city, MediaType.APPLICATION_JSON)).thenAccept(response ->
//                        assertEquals(response.getStatus(), Response.Status.NO_CONTENT.getStatusCode())
//                ).thenCompose(v -> target("cities").request().rx().get(Response.class)).thenAccept(response -> {
//                    List<Map<String, String>> cities = (List<Map<String, String>>) response.readEntity(List.class);
//                    assertNotNull(cities);
//                    assertTrue(cities.stream().anyMatch(item -> item.get("name").equals("Kiev")));
//                }).toCompletableFuture();
//
//        try {
//            cf.join();
//        } catch (CompletionException e) {
//            if (e.getCause() != null) {
//                throw e.getCause();
//            }
//            fail(e.getMessage());
//        }
//    }

}
