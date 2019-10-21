import patmat.Huffman.{CodeTree, Fork, Leaf}

def times (char: List[Char]):List[(Char,Int)] = {

      def loop(chars: List[Char], list: List[(Char, Int)]): List[(Char, Int)] =
      {
        if (chars.isEmpty) list
        else
        {
          val head = chars.head
          val freq = chars.count(x=> x == head)
          (head,freq) :: list
          loop(chars.tail.filterNot(x=> x == head),list)
        }
      }
      loop(char,List())
}


times(List('a','b','b','a','c'))


val s = Seq("apple", "oranges", "apple", "banana", "apple", "oranges", "oranges")
s.groupBy(l => l).map(t => (t._1, t._2.length))


val j = List('a','b','b','a','c')



def times_map(char: List[Char]):List[(Char,Int)] = {

val output = char.groupBy(k=>k).map(t => (t._1, t._2.length))

output.map{case (k,v)=>(k,v)} toList
}


times_map(j)

def makeOrderedLeafList(freqs: List[(Char, Int)]): List[Leaf] =  {

  freqs.sortWith((f1,f2) => f1._2 < f2._2).map((f) => Leaf (f._1, f._2))
}

makeOrderedLeafList(times_map(j))

val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
def singleton(trees: List[CodeTree]): Boolean = trees.size ==1

singleton(t2)



