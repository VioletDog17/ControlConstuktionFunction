import java.time.temporal.TemporalAmount
import kotlin.math.roundToInt
fun main(args: Array<String>) {
    val secondCount = 60
    println(agoToText(secondCount))

}
fun agoToText(secondCount: Int): String {
    var ans = ""
    when {
        (secondCount in 0..60) -> ans = "только что"
        (secondCount in 1..60 * 60) -> ans = minuteDeclination(secondCount)
        (secondCount in 60 * 60 + 1..24 * 60 * 60) -> ans = hourDelination(secondCount)
        (secondCount in 24 * 60 * 60 + 1..48 * 60 * 60) -> ans = "вчера"
        (secondCount in 48 * 60 * 60 + 1..72 * 60 * 60) -> ans = "позавчера"
        else -> ans = "давно"
    }
    return ans
}

fun hourDelination(secondCount: Int): String {
    val hour = secondCount / 60 / 60
    var ans = "неизвестно"
    when{
        (hour % 10 == 1 && hour % 100 != 11) -> ans = "был(а) в сети $hour час назад"
        (hour % 10 == 5  || hour % 100 in 11..14) -> ans = "был(а) в сети $hour часов назад"
        (hour % 10 in 2..4 && hour % 100 !in 12..14) -> ans = "был(а) в сети $hour часа назад"
        else -> ans = "был(а) в сети $hour часов назад"
    }
    return ans
}

fun minuteDeclination(secondCount: Int): String {
    val min = secondCount / 60
    var ans = "неизвестно"
    when{
        (min % 10 == 1 && min % 100 != 11) -> ans = "был(а) в сети $min минуту назад"
        (min % 10 == 5  || min % 100 == 11) -> ans = "был(а) в сети $min минут назад"
        (min % 10 in 2..4 && min % 100 !in 12..14) -> ans = "был(а) в сети $min минуты назад"
        else -> ans = "был(а) в сети $min минут назад"
    }
    return ans
}