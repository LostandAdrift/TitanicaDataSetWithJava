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
 * 
 * Version/date: 03/31/2023
 * 
 * Responsibilities of class:
 *  	
 *  Passenger represents a person on the Titanic.
 */

public class Passenger
{
	// Instance Variables
	private double financialClass;
	private double survived;
	private double fare;
	private double age;
	private double sex;
	
	// Constructor
	public Passenger(double financialClass, double survived, double sex, double age, double fare)
	{
		this.financialClass = financialClass;
		this.survived = survived;
		this.sex = sex;
		this.fare = fare;
		this.age = age;
		}

	// Accessors
    public double getFinanicalClass() 
    {
        return financialClass;
    }

    public double getSurvived() 
    {
        return survived;
    }

    public double getFare() 
    {
        return fare;
    }

    public double getAge() 
    {
        return age;
    }

    public double getSex() 
    {
        return sex;
    }
	
	
}
