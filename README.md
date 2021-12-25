# Minkowski Distance and Pearson correlation coefficient


### 1.  Minkowski Distance

Minkowski Distance is the generalized form of Euclidean and Manhattan Distance. The formula for Minkowski distance is given as

![Minkowski Distance Formula](Images/minwoski.png)
<div align="left">
 
Figure 1: Minkowski Distance Formula]
 </div>

For the minkowski distance i used both recursion and higher order function to
implement it based on the following formula of minkowski distance.




### 2. Pearson correlation coefficient

The Pearson correlation coefficient is used to measure the strength of a linear association between two variables in a given datasets.


Pearson’s correlation coefficient returns a value between -1 and 1. The interpretation of the correlation coefficient is as under:
* If the coefficient is -1, it indicates a strong negative relationship which implies a perfect negative relationship between the variables in the data
* If the  coefficient is 0, it indicates no relationship or correlation exists between the variables
* If the coefficient is 1, it indicates a strong positive relationship. It implies a perfect positive relationship between the variables

For the pearson correlation coefficient we applied higher order functions on the following formula. <br>

![Pearson Correlation Formula](Images/pearson.PNG)
 
 <div align="center">
 Figure 2:Pearson Correlation Formula
 </div> 
 <br>

### 3. Program Execution
* Pearson(1.0::2.0::Nil,2.0::1.0::Nil)
* MinkowskiHOF(1.0::2.0::Nil)(2.0::3.0::Nil)(1.0)
* Minkowski(1.0)(1.0::2.0::Nil)(2.0::3.0::Nil)


### 4. Reference
1. [Types of Distances in Machine Learning](https://medium.com/analytics-vidhya/types-of-distances-in-machine-learning-5b1233380775)
2. [Pearson Correlation Coefficient](https://www.wallstreetmojo.com/pearson-correlation-coefficient/)
3. [Scala Documentation](https://www.scala-lang.org/)
