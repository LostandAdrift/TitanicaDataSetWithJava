package cisc191.sdmesa.edu;

import java.util.ArrayList;

/**
 * Lead Author(s): 
 * @author Martin Piceno
 * 
 * Other contributors:
 * None
 * 
 * References:
 *  * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * Bechtold, S., Brannen, S., Link, J., Merdes, M., Philipp, M., Rancourt, J. D., & Stein, C. (n.d.). 
 * JUnit 5 user guide. JUnit 5. 
 * https://junit.org/junit5/docs/current/user-guide/
 * 
 * Geron, A. Hands-On Machine Learning with Sciekit-Learn, Keras & Tensor FLow. 2023.
 * 
 * Larson, R. Elementary Linear Algebra 7th Edition. 2013.
 * 
 * patrickJMT. Inverse Matrix Using Gauss-Jordan / Row Reduction. https://www.youtube.com/watch?v=cJg2AuSFdjw. 
 * 
 * richland.edu. Gauss Jordan Elimination Through Pivoting. https://people.richland.edu/james/lecture/m116/matrices/pivot.html
 * 
 * Version/date: 03/31/2023
 * 
 * Responsibilities of class:
 * 
 * Template for data handler
 */
public interface DataHandler
{
	// ReadCSV of Passenger data
	ArrayList<Passenger> readCSV(String fileName) throws Exception;
	
	// Return 2D array of Passengers
	double [][] generateArray(String fileName, int numberOfParameters) throws Exception;
	
	// Generate running average of values
	double runningAverage(String value, double parameterSum) throws Exception;
	
}
