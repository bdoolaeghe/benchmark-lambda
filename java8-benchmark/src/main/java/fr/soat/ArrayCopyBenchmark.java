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

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations=100, time=10, timeUnit=TimeUnit.MILLISECONDS)
@Measurement(iterations=100, time=10, timeUnit=TimeUnit.MILLISECONDS)
@Fork(value = 1, jvmArgsPrepend = { "-server", "-Xmx2g", "-XX:+TieredCompilation" })
@Threads(1)
//@BenchmarkMode(Mode.SingleShotTime)
//@OutputTimeUnit(TimeUnit.MILLISECONDS)
//@Warmup(iterations = 50)
//@Measurement(iterations = 200)
//@Fork(value = 10, jvmArgsPrepend = { "-server", "-Xmx2g", "-XX:+TieredCompilation" })
//@Threads(1)
public class ArrayCopyBenchmark {

	@Benchmark
	public void copy_array(PersonnesContainer c, Blackhole blackHole) {
		blackHole.consume(c.personneToSortArray);
	}
	
}
