package cisc191.sdmesa.edu;

/**
 * Lead Author(s): 
 * @author Martin Piceno
 * 
 * Other contributors:
 * None
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
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
 * Abstract class for  regression.
 */

// Regressor is a LinearAlgebra
public abstract class Regressor implements LinearAlgebra
{
	
	//Transpose the input array
	public double[][] matrixTranspose(double[][] array)
	{
		
		double [][] returnArray = new double [array[0].length][array.length];
	
		// Transpose the array
		for(int i=0; i< array.length; i++)
		{
			for(int j=0; j<array[0].length;j++)
			{
				returnArray[j][i] = array[i][j];
			}
		}
		return returnArray;
	}
	
	/**
	 * Purpose: Multiply a vector (one dimensional matrix) and 
	 *  a matrix (2D array)
	 * 
	 * @param 2D array and 1D array
	 * @return 1D array
	 */
	// Multiplies a two-dimensional matrix by a one dimension matrix
	// Only works if the matrix has the same number of columns as the input vector has number of rows
	public double[] vectorMatrixMult(double[][] array, double[] vector)
	{
		// Holds result values
		double[] returnMatrix = new double[array.length];

		// Multiply array and vector; store result in return Matrix
		for(int x=0; x<array.length;x++)
		{
			for(int y=0; y<vector.length;y++)
				{
					returnMatrix[x] += vector[y] * array[x][y];
				}
		}
		return returnMatrix;
	}
	
	// Multiply a matrix by a scalar
	public double[][] scalarMatrixMult(double[][] array, double scalar)
	{
		// Store product values
		double [][] scaledMatrix = new double [array.length][array[0].length];
		
		// Multiplies scalar and array values; stores result in scaledMatrix
		for(int i=0; i < array.length;i++)
		{
			for (int j=0; j<array[0].length; j++)
			{
				scaledMatrix[i][j] = array[i][j] * scalar;
			}
		}
		
		return scaledMatrix;
	}
	
	/**
	 * Purpose: Multiply two matrixes (2D arrays)
	 * 
	 * NOTE: Method is not communicative
	 * 
	 * @param Two, 2D arrays
	 * @return 2D array
	 */
	public double[][] matrixMultiplication(double[][] arrayOne, double[][] arrayTwo)
	{
		// Instantiate a new array with rows equal to the columns in arrayOne and 
		// with rows into the columns in arrayTwo
		double [][] productArray = new double[arrayTwo[0].length][arrayOne.length];
		
		// For each element in arrayOne's rows
		for(int i=0; i<arrayOne.length;i++)
		{
			// For each element in arrayTwo's columns
			for (int j = 0; j<arrayTwo[0].length; j++)
			{
				// For each element in arrayOne's columns
				for (int k = 0; k < arrayOne[0].length; k++)
				{
					// Multiply across the matrices and add the result to Product Array
					productArray[i][j] += arrayOne[i][k]  * arrayTwo[k][j]; 
				}
			}
		}
		return productArray;
	}
	
	/**
	 * Purpose:  Calculate the inverse using Gauss-Jordan elimination with pivoting
	 * 
	 * NOTE: Method is not communicative
	 * 
	 * @param 2D array
	 * @return 2D array
	 */
	public double[][] inverseMatrix(double[][] matrix)
	{
		// Create a new matrix with twice as many columns
		// Left half of doubleMatrix is the input array, 
	    int numberOfRows = matrix.length;
	    double[][] doubleMatrix = new double[numberOfRows][2*numberOfRows];
 
	    // Copy Contents of input array into doubleMatrix and add diagonal of ones.
	    for (int i = 0; i < numberOfRows; i++) 
	    {
	        for (int j = 0; j < numberOfRows; j++)
	        {
	        	doubleMatrix[i][j] = matrix[i][j];
	        }
	        
	        // The right half of the array is the identity matrix,
	        // which will be transformed into the inverse of the original array.
	        doubleMatrix[i][i+numberOfRows] = 1.0;
	        
	    }

	    //Gauss-Jordan elimination
	    for (int i = 0; i < numberOfRows; i++) 
	    {
	        
	    	// Placeholder variable
	        int pivot = i;
	        
	        // Find pivot row
	    	// Finds the row with the largest absolute value in the i column
	        for (int j = i+1; j < numberOfRows; j++)
	        {
	            if ((doubleMatrix[j][i] * doubleMatrix[j][i]) > (doubleMatrix[pivot][i] *doubleMatrix[pivot][i])) 
	            {
	                pivot = j;
	            }
	        }
	        
	        // Swaps rows
            // If the pivot element is not in the i row, swap rows so it is.
	        if (pivot != i) 
	        {
	            double[] temp = doubleMatrix[i];
	            doubleMatrix[i] = doubleMatrix[pivot];
	            doubleMatrix[pivot] = temp;
	        }

	        // Normalize the pivot row by dividing all elements by the pivot element.
	        double pivotValue = doubleMatrix[i][i];
	        for (int j = i; j < 2 * numberOfRows; j++)
	        {
	        	doubleMatrix[i][j] /= pivotValue;
	        }

	        // Eliminate other rows
            // Subtract a multiple of the pivot row from each other row to eliminate
            // the i-th column in all rows except the pivot row.
	        for (int j = 0; j < numberOfRows; j++) 
	        {
	            if (j != i) 
	            {
	                double factor = doubleMatrix[j][i];
	                for (int k = i; k < 2*numberOfRows; k++)
	                {
	                	doubleMatrix[j][k] -= factor * doubleMatrix[i][k];
	                }
	            }
	        }
	    }

	    // Extract the right half of doubleMatrix as the inverse of the original matrix.
	    double[][] inverse = new double[numberOfRows][numberOfRows];
	    
	    for (int i = 0; i < numberOfRows; i++) {
	        for (int j = 0; j < numberOfRows; j++) 
	        {
	            inverse[i][j] = doubleMatrix[i][j+numberOfRows];
	        }
	    }
	    // TODO Find a pretty way to round this for testing
	    //System.out.println(Arrays.deepToString(inverse));

	    return inverse;
	}
	
	/**
	 * Purpose:  Return the adjugate matrix
	 * 
	 * 
	 * @param 2D array
	 * @return 2D array
	 */
	public double[][] adjugate(double[][] array)
	{
		// Instantiate a new array with same length 
		double [][] adjugate = new double[array.length][array[0].length];
		
		for (int i = 0; i< array.length; i++)
		{ 
			for (int j=0; j< array[0].length; j++)
			{
				adjugate[i][j] = array[array.length - 1 -i][array[0].length -1 - j];
			}
		}
		return adjugate ;
	}
}
