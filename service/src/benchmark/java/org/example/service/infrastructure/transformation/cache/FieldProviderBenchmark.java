package org.example.service.infrastructure.transformation.cache;

import org.example.application.domain.entity.base.AbstractEntity;
import org.example.application.domain.entity.geography.City;
import org.example.application.domain.entity.geography.Station;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Performance test for {@link org.example.service.infrastructure.transformation.cache.FieldProvider}
 *
 * @author Kul'baka Alex
 */
@Warmup(iterations = 2)
@BenchmarkMode(Mode.AverageTime)
@Fork(value = 1, jvmArgsAppend = "-server")
@Measurement(iterations = 5)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class FieldProviderBenchmark {

    private Map<String, FieldProvider> providers;

    @Param({"Basic", "Cache", "Guava"})
    private String provider;

    @Setup
    public void init() {
        providers = new HashMap<>();
        providers.put("Basic", new FieldProvider());
        providers.put("Cache", new CacheFieldProvider());
        providers.put("Guava", new GuavaCacheFieldProvider());
    }

    /**
     * There are two requirements:
     * {@code public} method without parameters
     * {@link Benchmark} annotation
     */
    @Benchmark
    public void getFieldNames_targetCityCopy(final Blackhole blackhole) {
        blackhole.consume(providers.get(provider).getFieldNames(City.class, CityCopy.class));
    }

    @Benchmark
    public void getFieldNames_targetObject(final Blackhole blackhole) {
        blackhole.consume(providers.get(provider).getFieldNames(City.class, Object.class));
    }

    @State(Scope.Benchmark)
    public class CityCopy extends AbstractEntity {

        private String name;

        private String district;

        private String region;

        private Set<Station> stationSet;

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) throws Exception {
        Options opts = new OptionsBuilder().include(".*").resultFormat(ResultFormatType.TEXT).build();

        new Runner(opts).run();
    }
}
