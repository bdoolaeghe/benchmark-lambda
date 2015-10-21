package fr.soat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;


@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 50)
@Measurement(iterations = 200)
@Fork(value = 10, jvmArgsPrepend = { "-server", "-Xmx2g", "-XX:+TieredCompilation" })
@Threads(1)
public class LambdaVsAnonymousBenchmark {

	@Benchmark
	public void anonymous_class(PersonnesContainer c, Blackhole blackHole) {
		Arrays.sort(c.personneToSortArray, 
				new Comparator<Personne>() {
			        public int compare(Personne p1, Personne p2) {
			            int nomCompaison = p1.getNom().compareTo(p2.getNom());
			            return (nomCompaison != 0) ? nomCompaison : p1.getPrenom().compareTo(p2.getPrenom()) ;
			        }
				});
		blackHole.consume(c.personneToSortArray);
	}

	@Benchmark
	public void lambda(PersonnesContainer c, Blackhole blackHole) {
		Arrays.sort(c.personneToSortArray,
					 (p1, p2) -> {
								int nomCompaison = p1.getNom().compareTo(p2.getNom());
								return (nomCompaison != 0) ? nomCompaison : p1.getPrenom().compareTo(p2.getPrenom());
							});
		blackHole.consume(c.personneToSortArray);
	}

//
//	public void lambda_then(PersonnesContainer c, Blackhole blackHole) {
//		Arrays.sort(c.personneToSortArray, c.comparatorAsLinkedLambda);
//		blackHole.consume(c.personneToSortArray);
//	}

	@Benchmark
	public void method_reference(PersonnesContainer c, Blackhole blackHole) {
		Arrays.sort(c.personneToSortArray, 
					Comparator.comparing(Personne::getNom)
							  .thenComparing(Personne::getPrenom));
		blackHole.consume(c.personneToSortArray);
	}

	@Benchmark
	public void stream_anonymous_class(PersonnesContainer c, Blackhole blackHole) {
		Arrays.stream(c.personneToSortArray)
				.sorted(new Comparator<Personne>() {
					        public int compare(Personne p1, Personne p2) {
					            int nomCompaison = p1.getNom().compareTo(p2.getNom());
					            return (nomCompaison != 0) ? nomCompaison : p1.getPrenom().compareTo(p2.getPrenom()) ;
					        }
					    })
				.toArray();
		blackHole.consume(c.personneToSortArray);
	}

	@Benchmark
	public void stream_lambda(PersonnesContainer c, Blackhole blackHole) {
		Arrays.stream(c.personneToSortArray)
			  .sorted((p1, p2) -> {
							int nomCompaison = p1.getNom().compareTo(p2.getNom());
							return (nomCompaison != 0) ? nomCompaison : p1.getPrenom().compareTo(p2.getPrenom());
						})
			  .toArray();
		blackHole.consume(c.personneToSortArray);
	}

//
//	public void stream_lambda_then(PersonnesContainer c, Blackhole blackHole) {
//		Arrays.stream(c.personneToSortArray)
//				.sorted(c.comparatorAsLinkedLambda)
//				.toArray();
//		blackHole.consume(c.personneToSortArray);
//	}

	@Benchmark
	public void stream_method_ref(PersonnesContainer c, Blackhole blackHole) {
		Arrays.stream(c.personneToSortArray)
			  .sorted(Comparator.comparing(Personne::getNom)
			    				.thenComparing(Personne::getPrenom))
			  .toArray();
		blackHole.consume(c.personneToSortArray);
	}

	/* parallel */
	
	@Benchmark
	public void parallel_stream_anonymous_class(PersonnesContainer c, Blackhole blackHole) {
		Arrays.stream(c.personneToSortArray)
				.parallel()
				.sorted(new Comparator<Personne>() {
					        public int compare(Personne p1, Personne p2) {
					            int nomCompaison = p1.getNom().compareTo(p2.getNom());
					            return (nomCompaison != 0) ? nomCompaison : p1.getPrenom().compareTo(p2.getPrenom()) ;
					        }
					    })
				.toArray();
		blackHole.consume(c.personneToSortArray);
	}
	
	@Benchmark
	public void parallel_stream_lambda(PersonnesContainer c, Blackhole blackHole) {
		Arrays.stream(c.personneToSortArray)
				.parallel()
				.sorted((p1, p2) -> {
							int nomCompaison = p1.getNom().compareTo(p2.getNom());
							return (nomCompaison != 0) ? nomCompaison : p1.getPrenom().compareTo(p2.getPrenom());
						})
				.toArray();
		blackHole.consume(c.personneToSortArray);
	}
	
//
//	public void parallel_stream_lambda_then(PersonnesContainer c, Blackhole blackHole) {
//		Arrays.stream(c.personneToSortArray)
//				.parallel()
//				.sorted(c.comparatorAsLinkedLambda)
//				.toArray();
//		blackHole.consume(c.personneToSortArray);
//	}
//	
	
	@Benchmark
	public void parallel_stream_method_ref(PersonnesContainer c, Blackhole blackHole) {
		Arrays.stream(c.personneToSortArray)
				.parallel()
				.sorted(Comparator.comparing(Personne::getNom)
								  .thenComparing(Personne::getPrenom))
				.toArray();
		blackHole.consume(c.personneToSortArray);
	}
	
	
}
