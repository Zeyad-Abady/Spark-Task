# Spark-Task
In this project you will find my efforts to analyze the Stores dataset that I found on keggel  using Spark dataframes and Spark SQL APIs

### Technologies
* **Spark** version 3.1.2
* **Scala** scala-sdk-2.12.12
* **Java** jdk-11.0.12
* **Intellij** IDEA 2022.1.3 (Community Edition)


### Dataset
Supermarket store branches sales analysis contains information about store sales.

  * StoreID
  * StoreArea
  * ItemsAvailable
  * Daily Customer Count
  * StoreSales
  
Download the dataset at Kaggle: [Dataset](https://www.kaggle.com/datasets/surajjha101/stores-area-and-sales-data)

### Run Code
1. Setup Java jdk.
2. Add Spark jars to project build path.
3. Add Scala sdk to project build path.

## Queries
#### 1. The store ID with max Sales:

|StoreID|StoreSales|
|-------|:----------:|
|    650|    116320|

#### 2. The correlation between StoreSales and StoreArea:


|StoreArea|StoreSales|
|---------|:----------:|
|     1989|    116320|
|     1775|    105150|
|     1365|    102920|
|     1303|    102310|
|     1486|    101820|
|     1137|    101780|
|     1565|    100900|
|     1465|     99570|
|     1548|     99480|
|     1800|     98260|
|     1060|     97360|
|     1931|     97260|
|     1769|     96650|
|     1299|     96610|
|     1354|     95900|
|     1766|     94690|
|     1834|     94460|
|     1078|     94370|
|     1374|     94170|
|     1291|     93950|

![image](https://user-images.githubusercontent.com/56560956/183865237-c4cd986b-dcc1-4f46-9ac2-33dba0c0b9c3.png)


#### 3. Store with the largest number of daily customers:
|StoreID|Max_Customer_Count|
|-------|:------------------:|
|    849|              1560|

#### 4. The number of items available at each store:
|StoreID|ItemsAvailable|
|-------|:--------------:|
|      1|          1961|
|      2|          1752|
|      3|          1609|
|      4|          1748|
|      5|          2111|
|      6|          1733|
|      7|          1858|
|      8|          1507|
|      9|          1321|
|     10|          1235|
|     11|          1439|
|     12|          2098|
|     13|          2064|
|     14|          1931|
|     15|          1756|
|     16|          1950|
|     17|          1907|
|     18|          2045|
|     19|          1731|
|     20|          2340|

![image](https://user-images.githubusercontent.com/56560956/183867231-670efbdd-804a-4ee7-8c64-93d14da6591b.png)


#### 5. The correlation between StoreSales and Items Available:
|StoreSales|ItemsAvailable|
|----------|:--------------:|
|116320    |2414          |
|105150    |2104          |
|102920    |1638          |
|102310    |1587          |
|101820    |1758          |
|101780    |1374          |
|100900    |1854          |
|99570     |1763          |
|99480     |1858          |
|98260     |2158          |
|97360     |1279          |
|97260     |2342          |
|96650     |2112          |
|96610     |1560          |
|95900     |1635          |
|94690     |2111          |
|94460     |2184          |
|94370     |1276          |
|94170     |1655          |
|93950     |1546          |

![image](https://user-images.githubusercontent.com/56560956/183868367-84d4430b-584e-4f89-93c0-f0e714427044.png)


#### 6. Correlation between items available and Store area:
|StoreArea|ItemsAvailable|
|-------|:------------------:|
|     2229|          2667|
|     2214|          2647|
|     2169|          2617|
|     2063|          2493|
|     2067|          2492|
|     2044|          2474|
|     2049|          2465|
|     2015|          2436|
|     2019|          2420|
|     1989|          2414|
|     2044|          2408|
|     2026|          2400|
|     2007|          2397|
|     2013|          2396|
|     2019|          2396|
|     2001|          2394|
|     2011|          2391|
|     2004|          2390|
|     1975|          2385|
|     1990|          2384|

![image](https://user-images.githubusercontent.com/56560956/183869601-2a986c96-0340-4366-a054-93047555dfca.png)


### During my exploration I concluded that using a schema when reading a csv file is preffered as this will allow you to define the types of the columns you wish to be, because if left to spark to inffer the schema, it will by default let the columns all be strings.

### In the analysis phase, I tried to bring out the relation between several columns with each other. For instance, the realtion between store area and store sales is that when the area increases, the store sales increase also to somn extent. Also, I showed the stores with the most sales and daily customers in my analysis.







