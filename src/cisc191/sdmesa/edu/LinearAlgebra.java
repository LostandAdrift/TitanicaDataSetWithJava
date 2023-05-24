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
 * Template for Linear Algebra operations
 */
public interface LinearAlgebra
{

	// Multiply a matrix by a scalar
	public double[][] scalarMatrixMult(double[][] array, double scalar);
	
	// Multiply two, 2D arrays
	public double[][] matrixMultiplication(double[][] arrayOne, double[][] arrayTwo);
	
	// Inverse a matrix
	public double[][] inverseMatrix(double[][] matrix);
	
	// Return adjugate matrix
	public double[][] adjugate(double[][] array);
	
	// transpose the input matrix
	public double[][] matrixTranspose(double[][] array);
	
	// Multiplies a two-dimensional matrix by a one dimension matrix
	// Only works if the matrix has the same number of columns as the input vector has number of rows
	// TODO handle improperly sized arrays
	public double[] vectorMatrixMult(double[][] array, double[] vector);
}
