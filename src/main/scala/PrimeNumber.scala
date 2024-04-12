object PrimeNumber{
  def SeieveOfErathnoisis(n: Int):Int={
    if (n <= 0) throw new IllegalArgumentException("n must be a positive integer")
    val limit=n *(math.log(n) + math.log(math.log(n))).toInt
    val sieve =Array.fill(limit + 1)(true)
    sieve(0)=false
    sieve(1)=false
    var cnt=0
    for (p<-2 to limit if sieve(p)) {
      cnt+=1
      if (cnt==n) return p
      for (i <-p*p to limit by p) {
        sieve(i) = false
      }
    }
    throw new IllegalStateException("Failed to find nth prime")
  }
  def main(args: Array[String]): Unit = {
    println("Enter the n-th prime number you want = ")
    val n:Int=scala.io.StdIn.readInt()
    val nth=SeieveOfErathnoisis(n)
    println(s"The $n-th prime number is $nth")
  }
}
