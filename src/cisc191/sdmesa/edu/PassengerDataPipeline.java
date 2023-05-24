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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//PassengerDataPipeline is-a DataHandler
public class PassengerDataPipeline implements DataHandler
{
	// PassengerDataPipeline has-a rowNum
	private int rowNum= 0;
	// PassengerDataPipeline has-a ageSum
	private double ageSum = 0;
	// PassengerDataPipeline has-a ageSum
	private double fareSum= 0;
	// PassengerDataPipeline has many passengers
	ArrayList<Passenger> passengerList;
	// PassengerDataPipeline has a csv of data
	String csvLocation;
	// Array of data
	double [][] dataArray;
	
	// Default Constructor
	public PassengerDataPipeline() 
	{
		
	}
	public PassengerDataPipeline(String csvLocation, int numOfParams) throws Exception
	{
		this.csvLocation = csvLocation;
		this.dataArray = generateArray(csvLocation, numOfParams);
		
	}
	
	
	/**
	 * Purpose: Generate ArrayList of Passengers from CSV File
	 * 
	 * @param  Filename of CSV
	 * @return ArrayList<Passenger>
	 */
	public  ArrayList<Passenger> readCSV(String fileName) throws Exception
	{
		// Create ArrrayList to read in CSV data
		ArrayList<Passenger> passengers = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
		{
			String line;
			
			// Skip header
			br. readLine();
			
			// Read each line and create a  Passenger object
			while ((line = br.readLine()) != null)
			{
				// Keep track of the row number
				rowNum++;
				
				// Split line into columns
				String [] columns = line.split(",");

				// Create column based on the parameters
				// runningAverage is used to handle missing values
				double financialClass = Double.parseDouble(columns[0]);
				double sex = sexToDouble(columns[1]);
				double age = runningAverage(columns[2], ageSum);
				double fare= runningAverage(columns[3], fareSum);
				double survived= Double.parseDouble(columns[4]);
				
				// Add the Passenger the ArrayList
				passengers.add(new Passenger(financialClass, survived, sex, age, fare));
				
			}
		}
		catch (IOException e)
		{
			System.out.println(rowNum);
			e.printStackTrace();
		}
		
		return passengers;
	}

	
	/**
	 * Purpose: Generate 2D array of passenger data.
	 * 
	 * Method will need to be altered to if more columns/parameters are added
	 * 
	 * 										Each row represents one passenger.
	 * [financialClass, sex, age, fare, survivedStatus]
	 * financialClass: Stand in for financial status , goes from 1-3
	 * sex : 1 if male, 0 if female
	 * fare: amount paid for ticket
	 * survivedStatus: 1 if passenger survived, 0 if passenger did not
	 * 
	 * @param  fileName The name of the file name containing the Passenger data
	 * @param numberOfParameters The number of parameters (columns) in the resulting array.
	 * @return ArrayList<Passenger>
	 */
	
	// Final column will be training values (Survived)
	// TODO Generate constant for passengerList length instead of calling fileName
	public double [][] generateArray(String fileName, int numberOfParameters) throws Exception
	{
		// Generate array from data
		ArrayList<Passenger> passengerList = readCSV(fileName);
		double [][] array = new double [passengerList.size()][numberOfParameters];
		
		// Transfer passenger data to the array
		for (int index = 0; index < passengerList.size(); index++)
		{
			Passenger passenger = passengerList.get(index);
			array[index][0] = passenger.getFinanicalClass();
			array[index][1] = passenger.getSex();
			array[index][2] =passenger.getAge();
			array[index][3] = passenger.getFare();
			array[index][4] = passenger.getSurvived();
		}
		return array;
	}
	
	/**
	 * Purpose:  Update running average of age
	 * 
	 * @param String of "male" or "female"
	 * @return 0 or 1
	 */
	public double runningAverage(String valueString, double parameter) throws Exception
	{
		double age;
		
		// Sets age equal to the average age of users if value is null
		// and adds age to the ageSum
		if (valueString == null || valueString.isEmpty())
			age = parameter  / rowNum;
		else
			age = Double.parseDouble(valueString);
		
		// Keeps track of average age of passengers
		parameter += age;
		return age;
	}
	
	/**
	 * Purpose:  // Return 1.0 if male, 0.0 if female
	 * 
	 * @param String of "male" or "female"
	 * @return 0 or 1
	 */
	private double sexToDouble(String sex)
	{
		double returnVal;
		
		if (sex.equals("male"))
			returnVal = 1.0;
		
		else
			returnVal = 0.0;
		return returnVal;
	}
	
	public double [][] getDataArray()
	{
		return dataArray;
	}
	
}
