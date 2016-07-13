object simpleapp extends App {
  val list = List(1, 2, 3, 7, 9, 12, 34, 23)

  def insert(item: Int, list: List[Int]): List[Int] = list match {
    case head :: tail if head < item => head::insert(item, tail)
    case head :: tail if head > item => item :: head :: tail
    case _ => throw new Exception
  }

  val res = insert(14, list)
  println(res)
}

