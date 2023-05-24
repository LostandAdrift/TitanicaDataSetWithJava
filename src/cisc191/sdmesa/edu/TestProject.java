package cisc191.sdmesa.edu;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import java.awt.Color;
import java.util.ArrayList;

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
 * Version/date: 1.0  
 * 
 * Responsibilities of class:
 * Test class and methods to support a boat shop
 */

/**
 * For each of the test methods below create a method in the LinearRegression class that
 * makes the test run and pass.
 * 
 * Read the test methods to understand what the ArrayChallenge class methods
 * should do. The assertEquals methods check to see if the two arguments are
 * equal. If they are equal the test passes; if not, the test will be marked as
 * failed and the execution stops.
 * 
 */
class TestProject
{

	// Check LinearRegression class
	@Test
	void testLinearRegressor()
	{
		double [][] xOne = {{1,2},{3,4}};
		double [][] xTwo = {{10,20},{15,40}};
		double [] yOne = {3,7};
		double[] yTwo = {5,30};
		
		double scalar = 2;  
		double [][] scaledX = {{2,4}, {6, 8}};
		double [][] adjugateX= {{4,3}, {2,1}};

		double [][] xTransposed = {{1,3},{2,4}};
		double [][] squareThreeXThree= {{5,2,3},{4,5,6}, {7,8,9}};
		// Matrices to multiply
		double [][] bMatrix = {{7,8}, {9,10}};
		double [][] cMatrix = {{1,2,3},{4,5,6}};
		double [][] xMatrix = {{1,2},{3,4},{5,6}};

		// Matrices multiplication results
		double [][] bMatrixResult= {{25,28} ,{57,64}};
		double [][] cMatrixResult = {{9,12,15}, {19,26,33}, {29,40,51}};
		
		double [][] inverseX= {{-1.99,.99}, {1.49,-.49}};
		LinearRegressor linReg = new LinearRegressor(xOne,yOne, .2);
		double [] resultOfVectorTimesMatrix = {17,37};
		double [][] transposeTest = {{1,1,2},{1,3,4}};
		double [][] transposeTestResult = {{1,1},{1,3},{2,4}};
		double [] coefficientsXOne= {1, 1};
		double [] coefficientsXTwo= {10,20};
		
		// Check the matrix transpose works with two and three column matrices
		assertArrayEquals(xTransposed, linReg.matrixTranspose(xOne));
		assertArrayEquals(transposeTestResult, linReg.matrixTranspose(transposeTest));
		
		// Check that the matrix multiplication works
		assertArrayEquals(bMatrixResult, linReg.matrixMultiplication(xOne, bMatrix));
		assertArrayEquals(cMatrixResult, linReg.matrixMultiplication(xMatrix, cMatrix));
		
		// Check the adjugate matrix 
		assertArrayEquals(adjugateX, linReg.adjugate(xOne));
		
		// Check that vectorMatrixMult works
		assertArrayEquals(scaledX, linReg.scalarMatrixMult(xOne,scalar));
		
		// Check that the matrix multiplication works
		//assertArrayEquals(inverseX, linReg.inverseMatrix(x));
		assertArrayEquals(resultOfVectorTimesMatrix, linReg.vectorMatrixMult(xOne, yOne));
		
		// Final Step check
		// TODO fix rounding errors
		//assertArrayEquals(coefficientsXOne, linReg.getCoefficients(xOne, yOne));
		//assertArrayEquals(coefficientsXTwo, linReg.getCoefficients(xTwo, yTwo));
		
	}

	// Checks Pipeline class
	@Test
	void testPipeline()
	{
		String fileName = "titanicTraining.csv";
		PassengerDataPipeline pipeline = new PassengerDataPipeline();
		ArrayList<Passenger> passengers = null;
		try
		{
			passengers = pipeline.readCSV(fileName);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double[][] array = new double [1309][5];
		try
		{
			array = pipeline.generateArray(fileName, 5);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// First Passenger
		Passenger first = passengers.get(0);
		assertEquals(1.0, first.getFinanicalClass());
		assertEquals(1.0, first.getSurvived());
		assertEquals(29.0, first.getAge());
		assertEquals(211.3375, first.getFare());
		assertEquals(0.0, first.getSex());
		
		// Passenger 1128
		Passenger second = passengers.get(1126);
		assertEquals(3, second.getFinanicalClass());
		assertEquals(0, second.getSurvived());	
		assertEquals(7.8959, second.getFare());
		assertEquals(0.0, second.getSex());		
		
		// Test array is equivalent to first row in CSV/ArrayList
		assertEquals(1.0, array[0][0]);
		assertEquals(0.0, array[0][1]);
		assertEquals(29.0, array[0][2]);
		assertEquals(211.3375, array[0][3]);
		assertEquals(1.0, array[0][4]);
		
		// Test passenger 1129
		assertEquals(3.0, array[1127][0]);
		assertEquals(1.0, array[1127][1]);
		assertEquals(19.0, array[1127][2]);
		assertEquals(7.8958, array[1127][3]);
		assertEquals(0.0, array[1127][4]);
	}

	

}
