object PrimeNumber{
  def SeieveOfErathnoisis(n: Int):Int={
    if (n <= 0) throw new IllegalArgumentException("n must be a positive integer")
    val limit = n * (math.log(n) + math.log(math.log(n))).toInt
    val sieve = Array.fill(limit + 1)(true)
    sieve(0) = false
    sieve(1) = false
    var count = 0
    for (p <- 2 to limit if sieve(p)) {
      count += 1
      if (count == n) return p
      for (i <-p* p to limit by p) {
        sieve(i) = false
      }
    }
    throw new IllegalStateException("Failed to find nth prime")
  }
  def main(args: Array[String]): Unit = {
    val n=10
    val nth=SeieveOfErathnoisis(n)
    println(s"The $n-th prime number is $nth")
  }
}
