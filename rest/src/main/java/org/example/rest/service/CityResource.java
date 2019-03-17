package org.example.rest.service;

import io.swagger.annotations.*;
import org.apache.commons.lang3.math.NumberUtils;
import org.example.application.domain.entity.enums.StationType;
import org.example.application.domain.entity.geography.City;
import org.example.service.infrastructure.dto.geography.CityDTO;
import org.example.rest.service.base.AbstractResource;
import org.example.service.service.geography.ICityService;
import org.example.service.infrastructure.transformation.ITransformer;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Rest web service that handles {@link City}-related requests
 * format - json
 * <p>
 * Documented by {@code Swagger}
 *
 * @author Kul'baka Alex
 * @see org.example.rest.swagger.SwaggerConfiguration
 * @see AbstractResource
 */
@Path(value = "/cities")
@Api(value = "/cities")
public final class CityResource extends AbstractResource {

    /**
     * Underlying source of data
     */
    private final ICityService cityService;
    /**
     * DTO <-> Entity transformer
     */
    private final ITransformer transformer;

    @Inject
    public CityResource(final ICityService cityService, final ITransformer transformer) {
        this.cityService = cityService;
        this.transformer = transformer;

        final var copenhagen = new City("Copenhagen");
        copenhagen.addStation(StationType.SEA);
        copenhagen.addStation(StationType.RAILWAY);
        copenhagen.addStation(StationType.RIVER);
        copenhagen.setDistrict("Vesterbro");
        copenhagen.setRegion("Capital Region of Denmark");

        this.cityService.saveCity(copenhagen);
    }

    /**
     * Return all existing {@link City}'s. As {@link CityDTO}
     *
     * @return List<CityDTO>
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Returns all existing cities", produces = "json", httpMethod = "GET")
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
    @ApiOperation(value = "Save incoming city", consumes = "json", httpMethod = "POST")
    public void saveCity(final CityDTO cityDTO) {
        cityService.saveCity(transformer.unTransform(cityDTO, City.class));
    }

    /**
     * Return {@link City} with specified {@code cityId}
     *
     * @param cityId passed from client
     */
    @GET
    @Path(value = "/{cityId}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Returns city by specific id")
    @ApiResponses
            (value = {
                    @ApiResponse(code = 404, message = "such city not found"),
                    @ApiResponse(code = 400, message = "Invalid city identifier")
            })
    public Response findCityById(@ApiParam("Unique numeric city identifier")
                                 @PathParam("cityId") final String cityId) {
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
