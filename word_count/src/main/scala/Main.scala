import scala.collection.immutable.VectorMap
import scala.util.matching.Regex

@main def hello: Unit =
  println(
    lowerCaseAllWords(
      convertStringToListOfWords(
        squeezeBlankSpaces(
          stripFormattingCharacters(replaceNewlinesWithBlanks(msg))
        )
      )
    )
  )
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

def stripFormattingCharacters(stringWithoutNewlines: String): String = {
  val regex: Regex = """[^\w\d\s]""".r
  regex.replaceAllIn(stringWithoutNewlines, " ")
}

def squeezeBlankSpaces(stringWithoutFormatting: String): String = {
  val regex: Regex = """\s+""".r
  regex.replaceAllIn(stringWithoutFormatting, " ")

}

def convertStringToListOfWords(stringWithSingleBlanks: String): List[String] = {
  stringWithSingleBlanks.split(' ').map(_.trim).toList
}

def lowerCaseAllWords(listOfWords: List[String]): List[String] = {
  listOfWords.map(_.toLowerCase()).toList
}

def convertWordListToWordCount(
    lcListOfWords: List[String]
): VectorMap[String, Int] = ???
def sortMatByHighestValue(
    initialMap: VectorMap[String, Int]
): VectorMap[String, Int] = ???
