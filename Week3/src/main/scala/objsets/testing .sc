import objsets._

class Tweet(val user: String, val text: String, val retweets: Int) {
  override def toString: String =
    "User: " + user + "\n" +
      "Text: " + text + " [" + retweets + "]"
}


val e= new Tweet("elias", "my name", 10)

val temp = new Cons(e,e)