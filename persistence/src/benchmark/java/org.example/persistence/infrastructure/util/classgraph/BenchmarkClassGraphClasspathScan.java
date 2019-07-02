package org.example.persistence.infrastructure.util.classgraph;

import io.github.classgraph.ClassGraph;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Performance test of {@link io.github.classgraph.ClassGraph}
 * <p>
 * relates to {@link org.example.application}
 *
 * @author Kul'baka Alex
 */
@Warmup(iterations = 10)
@Measurement(iterations = 10)
@Fork(value = 1, jvmArgsAppend = "-server")
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class BenchmarkClassGraphClasspathScan {

    private ClassGraph classGraph;

    @Setup
    public void init() {
        classGraph = new ClassGraph();
    }

    @Benchmark
    public void findClassFromPackageByEntityAnnotationViaClassGraph(final Blackhole blackhole) {
        blackhole.consume(classGraph
                .whitelistPackages("org.example.application.domain.entity")
                .enableAllInfo()
                .scan()
                .getClassesWithAnnotation("javax.persistence.Entity")
                .loadClasses());
    }

    @Benchmark
    public void findAllClassesThatImplementCityRepositoryViaClassGraph(final Blackhole blackhole) {
        blackhole.consume(classGraph
                .whitelistPackages("org.example.persistence.repository")
                .enableAllInfo()
                .scan()
                .getClassesImplementing("org.example.persistence.repository.geography.ICityRepository")
                .loadClasses());
    }

    @Benchmark
    public void findAllClassesThatExtendBaseRepositoryViaClassGraph(final Blackhole blackhole) {
        blackhole.consume(classGraph
                .whitelistPackages("org.example.persistence.repository")
                .scan()
                .getSubclasses("org.example.persistence.repository.base.BaseHibernateRepository")
                .loadClasses());
    }

    public static void main(String[] args) throws Exception {
        Options opts = new OptionsBuilder().include(".*").resultFormat(ResultFormatType.TEXT).build();

        new Runner(opts).run();
    }
}
