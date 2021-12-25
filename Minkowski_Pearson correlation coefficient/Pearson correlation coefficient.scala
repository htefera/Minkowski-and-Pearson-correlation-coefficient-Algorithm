package code

object Program2
{
  
  /*
   * This program includes the implementation of Pearson correlation coefficient
   * 
   * It is implemented only in form of Higher order function, as it was a choice in question 
   * 
   * Currification:
   * 				it is not implemented in this function because it was not in the requirements to do so.
   * 
   */
  
  
  // function to calculate length of vector list of type List[Double]
  // Taken from book "Scala: From a functional programming perspective page#24 topic 2.7.1"
  val length: (List[Double]=>Int) = (l) => {
    if (l==Nil) { 0 } else { 1+length(l.tail)}  
  }
  
  
  // function to calculate sum of vector list of type List[Double]
  // Taken from book "Scala: From a functional programming perspective page#24 topic 2.7.1"
  val sum: (List[Double] => Double) = (l) => {
    if (l==Nil) { 0 } else { l.head+sum(l.tail) } 
  }
  
  // function to calculate mean of vector list of type List[Double]
  // it uses the up defined two functions length and sum to calculate mean of a vector
  val mean: (List[Double] => Double) = (l) => {
    sum(l)/length(l)
  }
  
  // function to check if both vectors have same length or not ... 
  // returns true if both vectors have same length, false otherwise
  def checkinput(x:List[Double], y:List[Double]): Boolean = {    
    if ( length(x) == length(y) ) 
      return true
    else
      return false
  }
  
  // Function to calculate a part of main formula 
  // it calculates the numinator of the main formula for Pearson Coefficient
  def sumdiff(x:List[Double],y:List[Double]) : Double = {
  
      var s:Double = 0        // variable to store sum in iterations
      val xm = mean(x)        // mean of vector x
      val ym = mean(y)        // mean of vector y
      val len = length(x)     // length of vector x ( same as vector y ) :: if not same, they're already rejected
      for (i <- 0 to len-1)   // Traversing through the vectors
      {
        // calculating numinator of main formula
        s = s + (x(i) - xm)*( y(i) - ym )
      }
      // returning calculated summation
      return s;
  }
  
  
  // function to calculate a part of denominator of main formula
  def diff(x:List[Double]): Double = {
      
      var s:Double = 0        // variable to store sum in iterations
      val xm = mean(x)        // mean of vector 
      val len = length(x)      // length of vector
  
      for (i <- 0 to len-1)    // traversing through the loop
      {
        // calculating denominator part of main formula
        s = s + ((x(i) - xm)*(x(i) - xm))
      }
      // returning calculated part 
      return math.sqrt(s)
  }
  
  
  // Main function to be used to get pearson coefficient from two vectors
  // it checks if both vectors have same length or not.
  // it not it gives an error, if yes it calculates the coefficient and prints it
  def Pearson(x:List[Double],y:List[Double]): Double = {
    
    if(checkinput(x,y))  // checking the length of vectors
    { 
      // calculating coefficients
      val r = sumdiff(x,y)/(diff(x)*diff(y))
      println("r =  "+r) // printing answer
      return r // returning the coefficient
    }
    else
    {
      // giving error message
      println("both vectors have different length, can't be solved")
      return -1
    }
  }
  
  def main(args: Array[String]): Unit = {
  
    val xlist: List[Double] = List(1,2,3)  // declaration of vector 1
    val ylist: List[Double] = List(4,5,6)  // declaration of vector 2
    
    Pearson(xlist,ylist)                    // Method 1: using variables to calculate result
    Pearson(1.0::2.0::Nil,2.0::1.0::Nil)    // Method 2: Using direct inputs to calculate result
  }
  
}