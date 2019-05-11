import funsets.FunSets.bound

val x = 9

type Set = Int => Boolean

def contains(s: Set, elem: Int): Boolean = s(elem)

contains(Set(1,2,3,4),9)

def singletonSet(elem: Int): Set = Set(elem)

singletonSet(39)

def union(s: Set, t: Set): Set = {
 def theunion (item: Int ):Boolean= {
    s( item ) || t ( item )
 }
  theunion
}


def intersect(s: Set, t: Set): Set = item => s(item) && t(item)

union(Set(1,2,3,4),Set(172,6,5))

def forall(s: Set, p: Int => Boolean): Boolean = {
  def iter(a: Int): Boolean = {
    if (a>bound) true
    else if (contains(s,a) && !p(a)) false
    else iter(a+1)
  }
  iter(-bound)
}

forall(Set(1,2,3,4),Set(1,2,3,5))
