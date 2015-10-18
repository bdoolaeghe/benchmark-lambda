package fr.soat;

import java.util.Comparator;

/**
 * the "bencmarked" components
 */
public class Benchmarked {

//   	// anonymous class comparator
//    public Comparator<Personne> comparatorAsAnonymousClass = new Comparator<Personne>() {
//        public int compare(Personne p1, Personne p2) {
//            int nomCompaison = p1.getNom().compareTo(p2.getNom());
//            return (nomCompaison != 0) ? nomCompaison : p1.getPrenom().compareTo(p2.getPrenom()) ;
//        }
//    };
//
//    // comparator as simple lambda
//    public Comparator<Personne> comparatorAsLambda = (p1, p2) -> {
//        int nomCompaison = p1.getNom().compareTo(p2.getNom());
//        return (nomCompaison != 0) ? nomCompaison : p1.getPrenom().compareTo(p2.getPrenom()) ;
//    };
//    
//    // comparator as linked lambda
//    private Comparator<Personne> comparatorNom = (p1, p2) -> p1.getNom().compareTo(p2.getNom()); 
//    private Comparator<Personne> comparatorPrenom = (p1, p2) -> p1.getPrenom().compareTo(p2.getPrenom());
//    public Comparator<Personne> comparatorAsLinkedLambda  = comparatorNom.thenComparing(comparatorPrenom);
//
//    // comparator as lambda built with method references
//    public Comparator<Personne> comparatorWithMehodReference = Comparator
//    		.comparing(Personne::getNom)
//    		.thenComparing(Personne::getPrenom);
//
//	
}
