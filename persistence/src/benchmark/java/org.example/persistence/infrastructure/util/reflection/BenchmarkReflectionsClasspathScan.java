package org.example.persistence.infrastructure.util.reflection;

import org.example.persistence.repository.base.BaseHibernateRepository;
import org.example.persistence.repository.geography.ICityRepository;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.reflections.Reflections;

import javax.persistence.Entity;
import java.util.concurrent.TimeUnit;

/**
 * Performance test of {@link org.reflections.Reflections}
 * <p>
 * relates to {@link org.example.application}
 */
@Warmup(iterations = 10)
@Measurement(iterations = 10)
@Fork(value = 1, jvmArgsAppend = "-server")
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class BenchmarkReflectionsClasspathScan {

    @Benchmark
    public void findClassFromPackageByEntityAnnotation(final Blackhole blackhole) {
        Reflections reflections = new Reflections("org.example.application.domain.entity");
        blackhole.consume(reflections.getTypesAnnotatedWith(Entity.class));
    }

    @Benchmark
    public void findAllClassesThatImplementCityRepository(final Blackhole blackhole) {
        Reflections reflections = new Reflections("org.example.persistence.repository");
        blackhole.consume(reflections.getSubTypesOf(ICityRepository.class));
    }

    @Benchmark
    public void findAllClassesThatExtendBaseRepository(final Blackhole blackhole) {
        Reflections reflections = new Reflections("org.example.persistence.repository");
        blackhole.consume(reflections.getSubTypesOf(BaseHibernateRepository.class));
    }

    public static void main(String[] args) throws Exception {
        Options opts = new OptionsBuilder().include(".*").resultFormat(ResultFormatType.TEXT).build();

        new Runner(opts).run();
    }
}
