package todo

import java.io.*
import scala.io.BufferedSource
import scala.io.Source
import scala.util.Failure
import scala.util.Success
import scala.util.Try
import scala.util.control.Exception.Finally

import IOHelper.*
import CollectionUtils.*


class Database(dbFilename: String):

  private def writeToFile(lines: Seq[String], append: Boolean): Try[Unit] = {
    var bw: BufferedWriter = null;

    try {
      bw = BufferedWriter(FileWriter(File(dbFilename), append))
      for line <- lines do bw.write(s"$line\n")
      Success(true)
    } catch {
      case e: Throwable => Failure(e)
    } finally {
      if bw != null then bw.close
    }
  }

  def insert(record: String): Try[Unit] = 
    writeToFile(List(record), true)

  def selectAll(): Try[Seq[String]] =
    
    var bufferedSource: BufferedSource = null
    try 
      bufferedSource = Source.fromFile(dbFilename)
      val lines = for line <- bufferedSource.getLines yield line
      Success(lines.toList)
    catch
      case t: Throwable => Failure(t)
    finally
      if bufferedSource != null then bufferedSource.close
    

  def delete(indexToDelete: Int): Try[Int] = 
    
    val maybeNumRowsDeleted: Try[Int] = for 
      rows <- selectAll()
      newRows = CollectionUtils.removeElementByIndex(
          rows, indexToDelete
        )
      numRowsDeleted = rows.size - newRows.size
      _ <- writeToFile(newRows, false)

    yield
      numRowsDeleted
    maybeNumRowsDeleted

end Database


@main def main: Unit =
  def ToDoList() = 
    val db = Database("./ToDoList.dat")

  promptUser()

