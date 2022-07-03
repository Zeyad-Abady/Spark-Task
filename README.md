# Spark-Task
This is a Spark Scala Program/Task to apply what I have learnt

### In this project you will find my efforts to analyze the Stores dataset that I found on keggel [](https://www.kaggle.com/datasets/surajjha101/stores-area-and-sales-data) using Spark dataframes and Spark SQL APIs

### During my exploration I concluded that using a schema when reading a csv file is preffered as this will allow you to define the types of the columns you wish to be, because if left to spark to inffer the schema, it will by default let the columns all be strings.

### In the analysis phase, I tried to bring out the relation between several columns with each other. For instance, the realtion between store area and store sales is that when the area increases, the store sales increase also to somn extent. Also, I showed the stores with the most sales and daily customers in my analysis.
