package cisc191.sdmesa.edu;

import java.util.Arrays;

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
 * Geron, A. Hands-On Machine Learning with Scikit-Learn, Keras & Tensor FLow. 2023.
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

// LinearRegressor is-a Regressor
// LinearRegressor is-a LinearAlgebra
public class LinearRegressor extends Regressor
{
	// LinearRegressor has-many coefficients
	private double [] coefficients;
	// LinearRegressor has-a threshold
	private double threshold;
	
	// Constructor
	// Takes single 2D array with training data and labels in final column
	public LinearRegressor(double [][] inputArray, double threshold)
	{
		this.threshold = threshold;
		
		// Create arrays for training data and labels
		double [][] trainingData = new double [inputArray.length][inputArray[0].length -1];
		double [] labelData = new double [inputArray.length];
		
		// Iterate through input array
		for (int x = 0; x < trainingData.length; x++)
		{ 
			for(int y=0; y< trainingData[0].length; y++)
				{
					// Copy all but the last column into trainingData
					trainingData[x][y] = inputArray[x][y];
				}
				labelData[x] = inputArray[x][inputArray[0].length -1];
		}
		
		// Fit model to input data
		this.coefficients = getCoefficients(trainingData, labelData);
	}
	
	// Constructor
	// Takes training and label arrays separately, where the last column are the training labels
	public LinearRegressor(double [][] inputArray, double [] labels, double threshold)
	{
		this.threshold = threshold;

		// Fit model to input data
		this.coefficients = getCoefficients(inputArray, labels);
	}
	
	/**
	 * Purpose:  Generate linear regression coefficients.
	 * 
	 * @param 2D array of training data, 1D array of label data
	 * @return Void
	 */
	public void fit(double [][] trainingData, double[] labelData)
	{
		// TODO Auto-generated method stub
		coefficients = getCoefficients(trainingData, labelData);
	}

	/**
	 * Purpose:  Generate predictions based on input array.
	 * 
	 *  Input array is that of a Passenger [ pClass, sex, age, fare] which must be multiplied 
	 * 
	 * @param array One dimensional array of Passenger data
	 * @return prediction Boolean value, true if survived, false if died
	 */
	public boolean[] predictSurvivors(double[][] array)
	{
	    boolean[] predictions = new boolean[array.length];

	    for (int rowIndex = 0; rowIndex < array.length; rowIndex++) 
	    {
	        double rawPrediction = 0;

	        // rawPrediction is gathered by multiplying the input features by the coefficients
	        // Iterate through all columns except the last one
	        for (int inputFeature = 0; inputFeature < array[rowIndex].length - 1; inputFeature++) {

	        	rawPrediction += array[rowIndex][inputFeature] * coefficients[inputFeature];  
	        }

	        // Returns true if the rawPrediction is greater than or equal to the threshold
	        if (rawPrediction >= threshold) 
	        {
	            predictions[rowIndex] = true;
	        } 
	        else {
	            predictions[rowIndex] = false;
	        }
	        
	        
	        
	        
	        
	    }

	    return predictions;
	}

	/**
	 * Purpose: Get the coefficients from the normal equation.
	 * 
	 *  NormalEquation =  ((X^T * X)^-1 ) * (X ^T * Y)
	 *  Input array is that of a Passenger [ pClass, sex, age, fare] which must be multiplied 
	 * 
	 * @param array Two dimensional array of training data.
	 * @param vector One dimensional array of label data.
	 * @return coefficients A one dimensional array of values.
	 */
	public double[] getCoefficients(double array[][], double [] vector)
	{
		// Transpose the initial array
		double[][] X_T =  matrixTranspose(array);
		
		// Multiply the transpose of the array by the initial array
		double [][] XT_X = matrixMultiplication(X_T, array);
		
		// take the inverse of the product
		double[][] XT_X_InV = inverseMatrix(XT_X);

		// Get the transpose of X times Vector
		double [] X_T_Y = vectorMatrixMult(X_T, vector);
		
		// Coefficients Finally
		double [] coefficients = vectorMatrixMult( XT_X_InV, X_T_Y);
		
		// TroubleShooting; check array output w/ calculator
		System.out.print("X: ");
		System.out.println(Arrays.deepToString(array));
		System.out.print("X^T: ");
		System.out.println(Arrays.deepToString(X_T));
		System.out.print("X^T*X ");
		System.out.println(Arrays.deepToString(XT_X));
		System.out.print("(X^T*X)^(-1): ");
		System.out.println(Arrays.deepToString(XT_X_InV));
		System.out.print("(X^T * Y ):");
		System.out.println(Arrays.toString(X_T_Y));
		System.out.print("Coefficients:");
		System.out.println(Arrays.toString(coefficients));
		
		return coefficients;
	}

}
