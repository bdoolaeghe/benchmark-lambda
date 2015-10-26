/*
 * Decompiled with CFR 0_108.
 * 
 * Could not load the following classes:
 *  fr.soat.Personne
 *  org.openjdk.jmh.annotations.Benchmark
 *  org.openjdk.jmh.annotations.BenchmarkMode
 *  org.openjdk.jmh.annotations.Fork
 *  org.openjdk.jmh.annotations.Measurement
 *  org.openjdk.jmh.annotations.Mode
 *  org.openjdk.jmh.annotations.OutputTimeUnit
 *  org.openjdk.jmh.annotations.Threads
 *  org.openjdk.jmh.annotations.Warmup
 *  org.openjdk.jmh.infra.Blackhole
 */
package fr.soat;

import fr.soat.Personne;
import fr.soat.PersonnesContainer;
import java.lang.invoke.LambdaMetafactory;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Stream;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(value={Mode.SingleShotTime})
@OutputTimeUnit(value=TimeUnit.MILLISECONDS)
@Warmup(iterations=50)
@Measurement(iterations=200)
@Fork(value=10, jvmArgsPrepend={"-server", "-Xmx2g", "-XX:+TieredCompilation"})
@Threads(value=1)
public class LambdaVsAnonymousBenchmark {
    @Benchmark
    public void anonymous_class(PersonnesContainer c, Blackhole blackHole) {
        Arrays.sort(c.personneToSortArray, new Comparator<Personne>(){

            @Override
            public int compare(Personne p1, Personne p2) {
                int nomCompaison = p1.getNom().compareTo(p2.getNom());
                return nomCompaison != 0 ? nomCompaison : p1.getPrenom().compareTo(p2.getPrenom());
            }
        });
        blackHole.consume(c.personneToSortArray);
    }

    @Benchmark
    public void lambda(PersonnesContainer c, Blackhole blackHole) {
        Arrays.sort(c.personneToSortArray, (p1, p2) -> {
            int nomCompaison = p1.getNom().compareTo(p2.getNom());
            return nomCompaison != 0 ? nomCompaison : p1.getPrenom().compareTo(p2.getPrenom());
        }
        );
        blackHole.consume(c.personneToSortArray);
    }

    @Benchmark
    public void method_reference(PersonnesContainer c, Blackhole blackHole) {
        Arrays.sort(c.personneToSortArray, Comparator.comparing((Function<Personne, String>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, getNom(), (Lfr/soat/Personne;)Ljava/lang/String;)()).thenComparing((Function<Personne, String>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, getPrenom(), (Lfr/soat/Personne;)Ljava/lang/String;)()));
        blackHole.consume(c.personneToSortArray);
    }

    @Benchmark
    public void stream_anonymous_class(PersonnesContainer c, Blackhole blackHole) {
        Arrays.stream(c.personneToSortArray).sorted(new Comparator<Personne>(){

            @Override
            public int compare(Personne p1, Personne p2) {
                int nomCompaison = p1.getNom().compareTo(p2.getNom());
                return nomCompaison != 0 ? nomCompaison : p1.getPrenom().compareTo(p2.getPrenom());
            }
        }).toArray();
        blackHole.consume(c.personneToSortArray);
    }

    @Benchmark
    public void stream_lambda(PersonnesContainer c, Blackhole blackHole) {
        Arrays.stream(c.personneToSortArray).sorted((p1, p2) -> {
            int nomCompaison = p1.getNom().compareTo(p2.getNom());
            return nomCompaison != 0 ? nomCompaison : p1.getPrenom().compareTo(p2.getPrenom());
        }
        ).toArray();
        blackHole.consume(c.personneToSortArray);
    }

    @Benchmark
    public void stream_method_ref(PersonnesContainer c, Blackhole blackHole) {
        Arrays.stream(c.personneToSortArray).sorted(Comparator.comparing((Function<Personne, String>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, getNom(), (Lfr/soat/Personne;)Ljava/lang/String;)()).thenComparing((Function<Personne, String>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, getPrenom(), (Lfr/soat/Personne;)Ljava/lang/String;)())).toArray();
        blackHole.consume(c.personneToSortArray);
    }

    @Benchmark
    public void parallel_stream_anonymous_class(PersonnesContainer c, Blackhole blackHole) {
        ((Stream)Arrays.stream(c.personneToSortArray).parallel()).sorted(new Comparator<Personne>(){

            @Override
            public int compare(Personne p1, Personne p2) {
                int nomCompaison = p1.getNom().compareTo(p2.getNom());
                return nomCompaison != 0 ? nomCompaison : p1.getPrenom().compareTo(p2.getPrenom());
            }
        }).toArray();
        blackHole.consume(c.personneToSortArray);
    }

    @Benchmark
    public void parallel_stream_lambda(PersonnesContainer c, Blackhole blackHole) {
        ((Stream)Arrays.stream(c.personneToSortArray).parallel()).sorted((p1, p2) -> {
            int nomCompaison = p1.getNom().compareTo(p2.getNom());
            return nomCompaison != 0 ? nomCompaison : p1.getPrenom().compareTo(p2.getPrenom());
        }
        ).toArray();
        blackHole.consume(c.personneToSortArray);
    }

    @Benchmark
    public void parallel_stream_method_ref(PersonnesContainer c, Blackhole blackHole) {
        ((Stream)Arrays.stream(c.personneToSortArray).parallel()).sorted(Comparator.comparing((Function<Personne, String>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, getNom(), (Lfr/soat/Personne;)Ljava/lang/String;)()).thenComparing((Function<Personne, String>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, getPrenom(), (Lfr/soat/Personne;)Ljava/lang/String;)())).toArray();
        blackHole.consume(c.personneToSortArray);
    }

}
