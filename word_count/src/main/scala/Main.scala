import scala.collection.immutable.VectorMap
@main def hello: Unit =
  println("Hello world!")
  println(msg)

def msg =
  "Problem territories let's circle back to that,\nface time, so game-plan window-licker,\nand helicopter view."

def wc(document: String): VectorMap[String, Int] = {

  val stringWithoutNewlines = replaceNewlinesWithBlanks(document);
  val stringWithoutFormatting =
    stripFormattingCharacters(stringWithoutNewlines);
  val stringWithSingleBlanks = squeezeBlankSpaces(stringWithoutFormatting);
  val listOfWords = convertStringToListOfWords(stringWithSingleBlanks);
  val lcListOfWords = lowerCaseAllWords(listOfWords);
  val initialMap = convertWordListToWordCount(lcListOfWords);
  val sortedMap = sortMatByHighestValue(initialMap);

  sortedMap
}

def replaceNewlinesWithBlanks(document: String): String = {
  document.replace('\n', ' ');
}

def stripFormattingCharacters(stringWithoutNewlines: String): String = ???

def squeezeBlankSpaces(stringWithoutFormatting: String): String = ???

def convertStringToListOfWords(stringWithSingleBlanks: String): String = ???

def lowerCaseAllWords(listOfWords: String): String = ???

def convertWordListToWordCount(lcListOfWords: String): VectorMap[String, Int] =
  ???

def sortMatByHighestValue(
    initialMap: VectorMap[String, Int]
): VectorMap[String, Int] = ???
