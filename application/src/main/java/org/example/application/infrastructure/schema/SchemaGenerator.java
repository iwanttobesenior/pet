package org.example.application.infrastructure.schema;

import org.example.application.domain.entity.geography.City;
import org.example.application.domain.entity.geography.Country;
import org.example.application.domain.entity.geography.Station;
import org.example.application.domain.entity.person.Account;
import org.example.application.domain.entity.valueobject.Address;
import org.example.application.domain.entity.valueobject.Coordinates;
import org.example.application.infrastructure.exception.uncheked.configuration.ConfigurationException;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.EnumSet;
import java.util.Set;

/**
 * Class for generation sql script for specific dialect,in specific folder
 *
 * @author Kul'baka Alex
 */
public final class SchemaGenerator {

    private static final String STATEMENT_DELIMITER_IN_SQL_SCRIPT = ";";

    private SchemaGenerator() {
    }

    /**
     * Generate sql script with DDL statement
     *
     * @param folder  in which your script will be located
     * @param dialect for concrete database
     */
    // TODO: 21.02.2019 provide auto-scan package which contain entities
    public static void generateSchema(final String folder, final Class<? extends Dialect> dialect) {
        MetadataSources metadata = new MetadataSources(
                new StandardServiceRegistryBuilder()
                        .applySetting("hibernate.dialect", dialect.getName())
                        .build());

        Set<Class<?>> entityClasses = Set.of(City.class, Country.class, Station.class, Account.class, Coordinates.class, Address.class);
        entityClasses.forEach(metadata::addAnnotatedClass);
        SchemaExport schema = new SchemaExport();
        schema.setDelimiter(STATEMENT_DELIMITER_IN_SQL_SCRIPT);
        var fileName = folder + "schema_" + dialect.getSimpleName() + ".sql";
        try {
            Files.deleteIfExists(new File(fileName).toPath());
            schema.setOutputFile(fileName);
            schema.create(EnumSet.of(TargetType.SCRIPT), metadata.buildMetadata());
        } catch (IOException e) {
            throw new ConfigurationException("schema generation with name " + fileName + " was failed", e);
        }
    }

    public static void main(String[] args) {
        generateSchema("", MySQL5Dialect.class);
    }
}
