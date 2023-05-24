# Titanic Survival Predictions using Java
An attempt at solving Kaggle's Titanic Data Set using linear algebra with Java...without external libraries.

# Overview
The goal of this project is to implement basic regression algorithms in Java without leaning on external libraries and train it on the publicly available Titanic data set from Kaggle. This project was used as a side project to gain experience in implementing regression algorithms and dealing with real-world data. The project achieved over a score of 71% on Kaggle. There are no plans for future updates.

# Dataset
The Titanic data set is in a CSV format. It includes labels (who survived) and other information about the passengers such as ticket price, name, passenger id, sex, and more. Some data points are missing and need to be accounted for.

# Work Flow
1 Account for missing data.
2 Normalize and transform data into vectors.
3 Feed data into a regression model for training.
4 Model will make predictions on the test set, output to a CSV, then submitted to Kaggle for accuracy evaluation.

# Class Structure
DataHandler: Interface. Contains methods for reading Titanic CSV and handling data.
LinearAlgebra: Interface. Contains methods for different forms of matrix multiplication.
Regressor: Abstract class. Implements LinearAlgebra and contains methods for matrix multiplication.
LinearRegressor: Each object is a linear regression model, fitted to training data using the normal equation.
Passenger: Represents a passenger on the Titanic.
PassengerDataPipeline: Implements DataHandler. Reads CSV of Passenger data and generates an array for fitting a LinearRegressor.

# Project Challenges
Implementing the inverseMatrix method was a significant challenge in the initial stages of this project. After extensive research and attempts, Gauss Jordan elimination via pivoting was used to overcome this issue.

Moreover, getting the array multiplication to work was another challenge. Off by one errors, mixed up columns vs rows, and wrongly referenced length variables created a lot of troubleshooting work. Setting up unit tests helped a lot in this process.

Design-wise, handling passenger data needed a significant revamp. Initially, it was planned to read data directly from the CSV into an array, but it was more challenging than expected. Eventually, by implementing ArrayLists and generating a Passenger class, the program was made much easier to work on and understand.
