package org.example.persistence.infrastructure.util.annotationetector;

import eu.infomas.annotation.AnnotationDetector;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import javax.persistence.Entity;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.concurrent.TimeUnit;

/**
 * Performance test of {@link eu.infomas.annotation.AnnotationDetector}
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
public class BenchmarkAnnotationDetectorClasspathScan {

    @Benchmark
    public void findClassFromPackageByEntityAnnotationViaAnnotationDetector() throws IOException {

        AnnotationDetector annotationDetector = new AnnotationDetector(new AnnotationDetector.TypeReporter() {
            @Override
            public void reportTypeAnnotation(Class<? extends Annotation> annotation, String className) {
                System.out.println(annotation + "    -    " +className);
            }

            @Override
            public Class<? extends Annotation>[] annotations() {
                return new Class[]{Entity.class};
            }
        });
        annotationDetector.detect("org.example.application.domain.entity");
    }

    public static void main(String[] args) throws Exception {
        Options opts = new OptionsBuilder().include(".*").resultFormat(ResultFormatType.TEXT).build();

        new Runner(opts).run();
    }
}
