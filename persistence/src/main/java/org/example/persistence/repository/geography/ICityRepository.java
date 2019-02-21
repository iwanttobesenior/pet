package org.example.persistence.repository.geography;

import org.example.application.domain.entity.geography.City;

import java.util.List;

/**
 * Repository for {@link City} entity
 *
 * @author Kul'baka Alex
 */
public interface ICityRepository {

    /**
     * save,update
     */
    void save(final City city);

    /**
     * Find {@link City} by current {@code id} as PK
     *
     * @return found entity or {@code null}
     */
    City findById(final long cityId);

    /**
     * Delete {@link City} from storage by current {@code cityId}
     */
    void delete(final int cityId);

    /**
     * Find all exist {@link City}
     *
     * @return {@code list<City>}
     */
    List<City> findAll();
}
