package code

object Program1 
{
  /*
   * This program includes the implementation of Minkowski Algorithm
   * 
   * It is being implemented in two ways:
   * 1. Recursive 					2. Higher Order Function
   * 
   * 1. recursive
   * 			This approach used the basic principle of recursion to find the minkowski distance between
   * 			two given vectors and an additional input p.
   * 
   * 2. Higher Order Function
   * 			This approach used the inner functions to calculate the minkowski distance between two
   * 			given vectors.
   * 
   * Currification:
   * 			Both these methods are implemented with the principles of currification being noticed
   * 			as it was required in assignment. These methods are implemented to fulfill all the 
   * 			requirements of assignment.
   * 
   */
  
   // function to calculate length of vector list of type List[Double]
  // Taken from book "Scala: From a functional programming perspective page#24 topic 2.7.1"
  val length: (List[Double]=>Int) = (l) => {
    if (l==Nil) { 0 } else { 1+length(l.tail)}  
  }
  
  // function to check if both vectors have same length or not ... 
  // returns true if both vectors have same length, false otherwise
  def checkinput(x:List[Double], y:List[Double]): Boolean = {    
    if ( length(x) == length(y) ) 
      return true
    else
      return false
  }
  
  // function to calculate part of formula
  // it calculates the inner part of main formula and returns to the calling function
  def sumitr(p:Double, x:List[Double],y:List[Double]):Double = 
  {
    var s:Double = 0          // variable to store result
    val len = length(x)      // length of vector x ( same as vector y )
    
    for( i <- 0 to len-1)    // iterating through the vectors
    {
      // calculating formula 
      s  = s + math.pow(math.abs(x(i)-y(i)),p)
    }
    
    // returning calculated value
    return s
  }
       
  // function to calculate part of formula recursively
  // it calculates the inner part of main formula recursively and returns to the calling function
  def sumrec(p:Double,x:List[Double],y:List[Double]):Double = 
  {
    if(x == Nil || y == Nil)
      return 0
    else
      return math.pow((x.head - y.head),p) + sumrec(p,x.tail,y.tail)
  }
  
  // Recusrsive Function Minkowski
  // It uses recursion to calculate the minkowski distance between given vectors
  // It also uses the principle of currification
 val Minkowski: (Double => ((List[Double],List[Double]) => Double )) = (p:Double) =>
   (x:List[Double],y:List[Double]) =>
 {
  if(checkinput(x,y))
  {
    math.pow(sumrec(p,x,y),(1/p))
  }
  else
  {
    // give warning and exit
      println("Vectors length didnot matched")
      math.pow(0,1) // just a random value to exit the function with a return Double statement
  }
 }
  
  // Higher Order Function MinkowskiHOF
  // it calculates the Minkowski distance between vectors
  // It also uses the principle of currification
  val MinkowskiHOF: (Double => ((List[Double],List[Double]) => Double)) = 
    (p:Double)  => (x:List[Double],y:List[Double]) => 
      {
        if(checkinput(x,y)) // if vectors have same length
         {
          // calcualte and return distance
           math.pow(sumitr(p,x,y),(1/p))
         } 
        else 
          {
          // give warning and exit
            println("Vectors length didnot matched")
            math.pow(0,1) // just a random value to exit the function with a return Double statement
          }
      }
      
  def main(args: Array[String]): Unit = {
  
    val xlist: List[Double] = List(1,2)                     // creation of vector 1
    val ylist: List[Double] = List(3,4)                    // creation of vector 2
  
    val EucledeanDistance = MinkowskiHOF(2.0)            // Method 1: Using currification principle
    val ManHattanDistance = MinkowskiHOF(1.0)
    println("direct D(x,y) : "+MinkowskiHOF(2)(xlist,ylist))    // Method 2: Using direct function
    println("currified D(x,y) : "+EucledeanDistance(xlist,ylist))
  
    val Euc = Minkowski(2.0)
    println("recursive D(x,y) : "+Euc(xlist,ylist))
    println("recursive D(x,y) : "+Minkowski(2)(xlist,ylist))    // Method 2: Using direct function  
  }
  
}