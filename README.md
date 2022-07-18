# Assignment Brief

The Java Project was made using Netbeans IDE with java version 18 and MySQL as the database. 
MySQL connector(vesion 8.0.29) was used as library for the connecting the database. 
JDBC was used for creating connection between java application and MySQL database.

Steps : 
The date-time data provided in the example of problem statement couldn't be directly as DATETIME value.
So the columns start_time and end_time was declared with VARCHAR instead of DATETIME.
While performing query on the table, string was converted to date-time using "date_format" function and extracting and processing of data was further done.

In the java file, JDBC was used to create a connection to the local database.
queries were passed in the ResultSet and the output was produced.
