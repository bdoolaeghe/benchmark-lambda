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
public class AnonymousBaselineColdBenchmark extends AnonymousBaselineBenchmark {

	@Benchmark
	public void anonymous_class(PersonnesContainer c, Blackhole blackHole) {
		super.anonymous_class(c, blackHole);
	}

}
