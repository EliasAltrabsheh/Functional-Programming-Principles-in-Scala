import forcomp.loadDictionary

/** A word is simply a `String`. */
type Word = String

/** A sentence is a `List` of words. */
type Sentence = List[Word]

/** `Occurrences` is a `List` of pairs of characters and positive integers saying
  *  how often the character appears.
  *  This list is sorted alphabetically w.r.t. to the character in each pair.
  *  All characters in the occurrence list are lowercase.
  *
  *  Any list of pairs of lowercase characters and their frequency which is not sorted
  *  is **not** an occurrence list.
  *
  *  Note: If the frequency of some character is zero, then that character should not be
  *  in the list.
  */
type Occurrences = List[(Char, Int)]

/** The dictionary is simply a sequence of words.
  *  It is predefined and obtained as a sequence using the utility method `loadDictionary`.
  */


/** Converts the word into its character occurrence list.
  *
  *  Note: the uppercase and lowercase version of the character are treated as the
  *  same character, and are represented as a lowercase character in the occurrence list.
  *
  *  Note: you must use `groupBy` to implement this method!
  */
def wordOccurrences(w: Word): Occurrences = w.toLowerCase.filterNot((x:Char) => x.isWhitespace).groupBy(x=>x).mapValues(k=>k.length).toList.sorted

def sentenceOccurrences(s: Sentence): Occurrences = wordOccurrences(s.mkString(" "))

sentenceOccurrences(List("abcd", "e"))

val dictionary: List[Word] = loadDictionary
lazy val dictionaryByOccurrences: Map[Occurrences, List[Word]] = dictionary.groupBy(x => wordOccurrences(x))



dictionaryByOccurrences.get(List(('a', 1), ('e', 1), ('t', 1))).map(_.toSet)


def wordAnagrams(word: Word): List[Word] = dictionaryByOccurrences(wordOccurrences(word))

wordAnagrams("Love")