package org.example.service.rest;


import org.apache.commons.lang3.math.NumberUtils;
import org.example.application.domain.dto.geography.CityDTO;
import org.example.application.domain.entity.enums.StationType;
import org.example.application.domain.entity.geography.City;
import org.example.application.infrastructure.transformation.transformer.Transformer;
import org.example.application.infrastructure.transformation.transformer.impl.SimpleDTOTransformer;
import org.example.service.rest.base.AbstractResource;
import org.example.service.service.ICityService;
import org.example.service.service.impl.CityServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Rest web service that handles {@link City}-related requests
 * format - json
 *
 * @author Kul'baka Alex
 * @see AbstractResource
 */
@Path(value = "/cities")
public class CityResource extends AbstractResource {

    /**
     * Underlying source of data
     */
    private final ICityService cityService;
    /**
     * DTO <-> Entity transformer
     */
    private final Transformer transformer;

    public CityResource() {
        cityService = new CityServiceImpl();
        transformer = new SimpleDTOTransformer();

        final City copenhagen = new City("Copenhagen");
        copenhagen.setId(1L);
        copenhagen.addStation(StationType.SEA);
        copenhagen.addStation(StationType.RAILWAY);
        copenhagen.addStation(StationType.RIVER);

        cityService.saveCity(copenhagen);
    }

    /**
     * Return all existing {@link City}'s. As {@link CityDTO}
     *
     * @return List<CityDTO>
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CityDTO> findCities() {
        return cityService.findCities()
                .stream()
                .map(entity -> transformer.transform(entity, CityDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Save new {@link City} instance
     *
     * @param cityDTO
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveCity(final CityDTO cityDTO) {
        cityService.saveCity(transformer.untransform(cityDTO, City.class));
    }

    /**
     * Return {@link City} with specified {@code cityId}
     *
     * @param cityId passed from client
     */
    @GET
    @Path(value = "/{cityId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCityById(@PathParam("cityId") final String cityId) {
        if (!NumberUtils.isDigits(cityId)) {
            return BAD_REQUEST;
        }
        // TODO: 15.02.2019 NumberUtils adapter!?
        Optional<City> cityById = cityService.findCityById(NumberUtils.toLong(cityId));

        if (cityById.isEmpty()) {
            return NOT_FOUND;
        }

        return ok(transformer.transform(cityById.get(), CityDTO.class));
    }
}
