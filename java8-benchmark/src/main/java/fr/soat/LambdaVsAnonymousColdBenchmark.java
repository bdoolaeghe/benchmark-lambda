package fr.soat;

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

//@BenchmarkMode(Mode.SingleShotTime)
//@OutputTimeUnit(TimeUnit.MILLISECONDS)
//@Warmup(iterations = 0)
//@Measurement(iterations = 1)
//@Fork(value = 1, jvmArgsPrepend = { "-server", "-Xmx2g", "-XX:+TieredCompilation" })
//@Threads(1)
//
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 0)
@Measurement(iterations = 1)
@Fork(value = 100, jvmArgsPrepend = { "-server", "-Xmx2g", "-XX:+TieredCompilation" })
@Threads(1)
public class LambdaVsAnonymousColdBenchmark extends LambdaVsAnonymousBenchmark {

	@Benchmark
	public void anonymous_class(PersonnesContainer c, Blackhole blackHole) {
		super.anonymous_class(c, blackHole);
	}

	@Benchmark
	public void lambda(PersonnesContainer c, Blackhole blackHole) {
		super.lambda(c, blackHole);
	}

	@Benchmark
	public void lambda_then(PersonnesContainer c, Blackhole blackHole) {
		super.lambda_then(c, blackHole);
	}

	@Benchmark
	public void method_reference(PersonnesContainer c, Blackhole blackHole) {
		super.method_reference(c, blackHole);
	}

	@Benchmark
	public void stream_anonymous_class(PersonnesContainer c, Blackhole blackHole) {
		super.stream_anonymous_class(c, blackHole);
	}

	@Benchmark
	public void stream_lambda(PersonnesContainer c, Blackhole blackHole) {
		super.stream_lambda(c, blackHole);
	}

	@Benchmark
	public void stream_lambda_then(PersonnesContainer c, Blackhole blackHole) {
		super.stream_lambda_then(c, blackHole);
	}

	@Benchmark
	public void stream_method_ref_then(PersonnesContainer c, Blackhole blackHole) {
		super.stream_method_ref_then(c, blackHole);
	}

	/* parallel */
	
	@Benchmark
	public void parallel_stream_anonymous_class(PersonnesContainer c, Blackhole blackHole) {
		super.parallel_stream_anonymous_class(c, blackHole);
	}
	
	@Benchmark
	public void parallel_stream_lambda(PersonnesContainer c, Blackhole blackHole) {
		super.parallel_stream_lambda(c, blackHole);
	}
	
	@Benchmark
	public void parallel_stream_lambda_then(PersonnesContainer c, Blackhole blackHole) {
		super.parallel_stream_lambda_then(c, blackHole);
	}
	
	@Benchmark
	public void parallel_stream_method_ref_then(PersonnesContainer c, Blackhole blackHole) {
		super.parallel_stream_method_ref_then(c, blackHole);
	}
	

}
