import scala.annotation.tailrec

object Main extends App {
  def Zad1(Week_list: List[String]) = {

    var str1 = ""
    var str2 = ""
    var str3 = ""
    for (i <- Week_list) {
      str1 = str1 + (i + ", ")
    }
    for (i <- Week_list if i(0) == 'P') {
      // println(Week_list(i)(0))
      str2 = str2 + (i + ", ")
    }
    var i = 0
    while (i < Week_list.length) {
      str3 = str3 + (Week_list(i) + ", ")
      i += 1
    }

    println(str1)
    println(str2)
    println(str3)
  }

  def Zad2a(Week_list: List[String], WeekStr: String = ""): String = Week_list match {
    case Nil => WeekStr
    case s :: Nil => (WeekStr + ',' + s) //.substring(1, (WeekStr + ',' +s).length())
    case s :: x :: xs => Zad2a(x :: xs, WeekStr + ',' + s)
  }

  def Zad2b(Week_list: List[String], WeekStr: String = ""): String = Week_list match {
    case Nil => WeekStr
    case s :: Nil => (s + ',' + WeekStr) //.substring(1, (WeekStr + ',' +s).length())
    case s :: x :: xs => Zad2b(x :: xs, s + ',' + WeekStr)
  }

  @tailrec
  def Zad3(Week_list: List[String], WeekStr: String = ""): String = {
    if (Week_list.length == 0) WeekStr
    else
      Zad3(Week_list.tail, if (WeekStr != "") WeekStr + ", " + Week_list.head else Week_list.head)
  }

  def Zad4(Week_list: List[String]) = {
    println("Foldl")
    println(Week_list.foldLeft("")((str, el) => if (str != "") str + ',' + el else el))
    println("Foldr")
    println(Week_list.foldRight("")((str, el) => if (el != "") el + ',' + str else str))
    println("Foldl z filtrem")
    println(Week_list.filter(_.head == 'P').foldLeft("")((str, el) => if (str != "") str + ',' + el else el))


  }

  def Zad5() = {
    val produkty = Map("Coca-Cola" -> 7, "Woda" -> 1, "Ketchup" -> 5)
    val po_znizce = produkty.view.mapValues(cena => cena * 0.9).toMap
    println(s"ceny przed zniżką: $produkty")
    println(s"ceny po zniżce: $po_znizce")

  }

  def Zad6(krotka: (Any, Any, Any)) = {
    println(krotka)
  }

  def Zad7(klucz: Option[Int]) = klucz match {
    case Some(x) => x
    case None => "Brak danych"
  }

  def Zad8(lista_liczb: List[Double], lista_bez_zer: List[Double] = List[Double]()): List[Double] = lista_liczb match {
    case Nil => lista_bez_zer
    case x :: Nil => if (x != 0) x :: lista_bez_zer else lista_bez_zer
    case x :: y :: z => if (x != 0) Zad8(y :: z, x :: lista_bez_zer) else Zad8(y :: z, lista_bez_zer)

  }

  def Zad9(liczby: List[Double])={
    def Zwieksz(liczba: Double):Double ={
      liczba+1
    }
    liczby.map(Zwieksz)
  }

  def Zad10(liczby: List[Double])={
     val x =liczby.filter( x =>x < 12 && x > -5)
    def WartBezwzgledna(x: Double):Double ={
      if(x<0.0) x * -1.0
      else x
    }
    x.map(WartBezwzgledna)
  }

  def Zad2_1(dzien : String) = dzien match {
    case "Poniedzialek" | "Wtorek" | "Sroda" | "Czwartek" | "Piatek" => "Praca"
    case "Sobota" | "Niedziela" => "Weekend"
    case _=> "Nie ma takiego dnia"
  }
//Zadanie 2.2
  class KontoBankowe(private var stanKonta:Double = 0)
  {
    def Wplata(wartosc: Double): Unit ={
      stanKonta+=wartosc
    }
    def Wyplata(wartosc: Double): Unit ={
      stanKonta-=wartosc
    }
    def Saldo(): Double ={
      stanKonta
    }
  }
//Zadanie 2.3
  case class Osoba(private var imie:String, private var nazwisko:String)

  def Przywitanie(osoba :Osoba): String = osoba match
  {
    case Osoba("Jan","Kowalski") => "cześć Jan Kowalski"
    case Osoba("Andrzej","Nowak") => "Witaj!"
    case _ =>"dzień dobry!"
  }
  //zadanie 2.4
  def Zad2_4(x:Double, func:(Double) => Double):Double ={
    func(func(func(x)))
  }

  //Zadanie 2.5
  abstract class Osoba2(val imie:String, val nazwisko:String)
  {
    def podatek() : Double
  }
  trait Student extends Osoba2 {override def podatek = 0}
  trait Pracownik extends Osoba2 {
    var pensja: Double = 0
    override def podatek = 0.2*pensja
  }
  trait Nauczyciel extends Pracownik {override def podatek = 0.1*pensja}

  val WeekList = List("Poniedzialek", "Wtorek", "Sroda", "Czwartek", "Piatek", "Sobota", "Niedziela")
  val krotka = ("Tekst", 10, true)
  val mapa = Map("Jacek" -> 20, "Adam" -> 21, "Jan" -> 30, "Hubert" -> 25, "Tomasz" -> 19)
  val rand_liczby = List(1.0, 4.0, 0.0, 1.0, 6.0, 3.0, 0.0, 0.0, 0.0, 2.0, 7.0, 5.0, 3.0, -2.0, -10.0, 100.0, 55.0,20.0 )
  println(Zad1(WeekList))
  println("Zad2a")
  println(Zad2a(WeekList))
  println("Zad2b")
  println(Zad2b(WeekList))
  println("Zad3")
  println(Zad3(WeekList))
  println("Zad4")
  println(Zad4(WeekList))
  println("Zad5")
  println(Zad5())

  println("Zad6")
  println(Zad6(krotka))

  println("Zad7")
  println(s"Jacek ma lat " + Zad7(mapa.get("Jacek")))
  println(s"Wojciech ma lat " + Zad7(mapa.get("Wojciech")))

  println("Zad8")
  println(Zad8(rand_liczby))

  println("Zad9")
  println(Zad9(rand_liczby))

  println("Zad10")
  println(Zad10(rand_liczby))

  println("Zad2.1")
  println("W poniedzialek jest " + Zad2_1("Poniedzialek"))
  println("W sobote jest " + Zad2_1("Sobota"))
  println("W tydzien jest " + Zad2_1("tydzien"))

  println("Zad2.2")
  var konto = new KontoBankowe()
  var konto2 = new KontoBankowe(200)
  println(konto.Saldo())
  println(konto2.Saldo())
  konto.Wplata(1000)
  konto2.Wyplata(50)

  println(konto.Saldo())
  println(konto2.Saldo())

  println("Zad2.3")
  var osoba1=new Osoba("Jan", "Kowalski")
  var osoba2=new Osoba("Andrzej","Nowak")
  var osoba3=new Osoba("Wojciech","Kuna")
  println(Przywitanie(osoba1))
  println(Przywitanie(osoba2))
  println(Przywitanie(osoba3))

  println("Zad2.4")
  println(Zad2_4(2, x => x*x))

  println("Zad2.5")
  var o1=new Osoba2("Jan", "Kowalski") with Student
  var o2=new Osoba2("Andrzej","Nowak") with Pracownik
  o2.pensja = 1000
  var o3=new Osoba2("Wojciech","Kuna") with Nauczyciel
  o3.pensja=1000
  println(o1.podatek())
  println(o2.podatek())
  println(o3.podatek())

  var o4=new Osoba2("x","y") with Student with Pracownik
  o4.pensja = 1000
  var o5=new Osoba2("a","b") with Pracownik with Student
  o5.pensja=1000
  println(o4.podatek())
  println(o5.podatek())
}
