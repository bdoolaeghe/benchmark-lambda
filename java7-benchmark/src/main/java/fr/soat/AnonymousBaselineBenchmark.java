package fr.soat;

import java.util.Arrays;

import org.openjdk.jmh.infra.Blackhole;


public abstract class AnonymousBaselineBenchmark {

	public void anonymous_class(PersonnesContainer c, Blackhole blackHole) {
		Arrays.sort(c.personneToSortArray, c.comparatorAsAnonymousClass);
		blackHole.consume(c.personneToSortArray);
	}
	
}
