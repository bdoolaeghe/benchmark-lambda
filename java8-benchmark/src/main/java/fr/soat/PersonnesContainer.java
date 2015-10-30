package fr.soat;

import java.io.IOException;
import java.util.Arrays;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class PersonnesContainer extends Benchmarked {

    @Param({
//    	"10",
    	"100",
    	"1000",
    	"10000",
//    	"100000",
//    	"200000", 
//    	"400000",
//    	"800000",
//    	"1000000"
    	"100000"
    	})
	protected int nbPersons;

    // the array of peronne to sort during invokation work
    public Personne[] personneToSortArray;

    // the unsorted "read only" array of personne
    private Personne[] unsortedPersonneArray;

    @Setup(Level.Trial)
    public void readPersonnesFromFile() throws IOException {
        // one time at benchark init, read list of personnes
        unsortedPersonneArray = PersonneProvider.load("../data/personnes.txt", nbPersons);
    }

    @Setup(Level.Invocation)
    public void reshuflePersonnesArray() throws IOException {
        // before each sort invocation,
        // restore unsorted array of personnes before sorting
        personneToSortArray = Arrays.copyOf(unsortedPersonneArray, unsortedPersonneArray.length);
    }
    
	
}
