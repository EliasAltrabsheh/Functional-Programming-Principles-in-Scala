package funsets


/**
 * 2. Purely Functional Sets.
 */
object FunSets {
  /**
   * We represent a set by its characteristic function, i.e.
   * its `contains` predicate.
   */
  type Set = Int => Boolean

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem)

  /**
   * Returns the set of the one given element.
    *
    * Define a function singletonSet which creates a singleton set from one integer value:
    * the set represents the set of the one given element.
    * Now that we have a way to create singleton sets, we want to define a function that allow us to build bigger sets from smaller ones.
   */
    def singletonSet(elem: Int): Set = Set(elem)
  

  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
  def union(s: Set, t: Set): Set = {
    def theunion (item: Int ):Boolean= {
      s( item ) || t ( item )
    }
    theunion
  }
  
  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` and `t`.
   */
    def intersect(s: Set, t: Set): Set =  (item:Int) => s(item) && t(item)
  
  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
    def diff(s: Set, t: Set): Set = (item:Int)=> s(item) && !t(item)
  
  /**
   * Returns the subset of `s` for which `p` holds.
   */
    def filter(s: Set, p: Int => Boolean): Set = (item:Int)=> s(item) && p(item)
  

  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 1000

  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
    def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a>bound) true
      else if (contains(s,a) && !p(a)) false
      else iter(a+1)
    }
    iter(-bound)
  }
  
  /**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
    * Using forall, implement a function exists
    * which tests whether a set contains at least one element for which the given predicate is true.
    * Note that the functions forall and exists behave like the universal and existential quantifiers of first-order logic.
   */
    def exists(s: Set, p: Int => Boolean): Boolean =  !forall(s,(item: Int) =>p(item))
  
  /**
   * Returns a set transformed by applying `f` to each element of `s`.
    * Finally, write a function map which transforms a given set into another one by applying to each of its elements the given function.
   */
    def map(s: Set, f: Int => Int): Set = {
      def Mapping(x:Int):Boolean ={
        exists(s,(y=>f(y) == x))
      }
      Mapping
    }
  /**
   * Displays the contents of a set
   */
  def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  }

  /**
   * Prints the contents of a set on the console.
   */
  def printSet(s: Set) {
    println(toString(s))
  }
}
