package cisc191.sdmesa.edu;

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

public class Main
{
	public static void main(String[] args) throws Exception {
	    // Initial Variables
	    String testData = "test.csv";
	    String trainingData =  "titanicTraining.csv";
	    int numberOfParameters = 5; // Update this if you have a different number of parameters
	    double threshold = 0.3;
	    
	    // For training and testing the linear regressor
	    PassengerDataPipeline trainingPipeline = new PassengerDataPipeline(trainingData,numberOfParameters);
	    PassengerDataPipeline testingPipeline = new PassengerDataPipeline(testData,numberOfParameters);
	    
	    // Create regressor and train it on training data
	    LinearRegressor linearRegressor = new LinearRegressor(trainingPipeline.getDataArray(), threshold);


	    boolean[] predictions = linearRegressor.predictSurvivors(testingPipeline.getDataArray());

	    System.out.println("Passenger Predictions:");
	    
	    // Print predictions to the console
	    for (int i = 0; i < predictions.length; i++) 
	    {
	    	if (predictions[i])
	    	{
	    		System.out.println(1);
	    	}
	    	else
	    		System.out.println(0);
	    }
	}

}
