package fr.soat;

import java.util.Arrays;

import org.openjdk.jmh.infra.Blackhole;


public abstract class LambdaVsAnonymousBenchmark {

	public void anonymous_class(PersonnesContainer c, Blackhole blackHole) {
		Arrays.sort(c.personneToSortArray, c.comparatorAsAnonymousClass);
		blackHole.consume(c.personneToSortArray);
	}


	public void lambda(PersonnesContainer c, Blackhole blackHole) {
		Arrays.sort(c.personneToSortArray, c.comparatorAsLambda);
		blackHole.consume(c.personneToSortArray);
	}


	public void lambda_then(PersonnesContainer c, Blackhole blackHole) {
		Arrays.sort(c.personneToSortArray, c.comparatorAsLinkedLambda);
		blackHole.consume(c.personneToSortArray);
	}


	public void method_reference(PersonnesContainer c, Blackhole blackHole) {
		Arrays.sort(c.personneToSortArray, c.comparatorWithMehodReference);
		blackHole.consume(c.personneToSortArray);
	}


	public void stream_anonymous_class(PersonnesContainer c, Blackhole blackHole) {
		Arrays.stream(c.personneToSortArray)
				.sorted(c.comparatorAsAnonymousClass)
				.toArray();
		blackHole.consume(c.personneToSortArray);
	}


	public void stream_lambda(PersonnesContainer c, Blackhole blackHole) {
		Arrays.stream(c.personneToSortArray)
				.sorted(c.comparatorAsLambda)
				.toArray();
		blackHole.consume(c.personneToSortArray);
	}


	public void stream_lambda_then(PersonnesContainer c, Blackhole blackHole) {
		Arrays.stream(c.personneToSortArray)
				.sorted(c.comparatorAsLinkedLambda)
				.toArray();
		blackHole.consume(c.personneToSortArray);
	}


	public void stream_method_ref_then(PersonnesContainer c, Blackhole blackHole) {
		Arrays.stream(c.personneToSortArray)
		.sorted(c.comparatorWithMehodReference)
		.toArray();
		blackHole.consume(c.personneToSortArray);
	}

	/* parallel */
	

	public void parallel_stream_anonymous_class(PersonnesContainer c, Blackhole blackHole) {
		Arrays.stream(c.personneToSortArray)
				.parallel()
				.sorted(c.comparatorAsAnonymousClass)
				.toArray();
		blackHole.consume(c.personneToSortArray);
	}
	

	public void parallel_stream_lambda(PersonnesContainer c, Blackhole blackHole) {
		Arrays.stream(c.personneToSortArray)
				.parallel()
				.sorted(c.comparatorAsLambda)
				.toArray();
		blackHole.consume(c.personneToSortArray);
	}
	

	public void parallel_stream_lambda_then(PersonnesContainer c, Blackhole blackHole) {
		Arrays.stream(c.personneToSortArray)
				.parallel()
				.sorted(c.comparatorAsLinkedLambda)
				.toArray();
		blackHole.consume(c.personneToSortArray);
	}
	

	public void parallel_stream_method_ref_then(PersonnesContainer c, Blackhole blackHole) {
		Arrays.stream(c.personneToSortArray)
				.parallel()
				.sorted(c.comparatorWithMehodReference)
				.toArray();
		blackHole.consume(c.personneToSortArray);
	}
	
	
}
