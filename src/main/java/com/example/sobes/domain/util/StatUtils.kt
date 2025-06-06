package com.example.sobes.domain.util

import com.example.sobes.domain.model.statistic.Statistic
import com.example.sobes.domain.model.statistic.VisitStatistic
import java.time.LocalDate
import java.time.temporal.WeekFields
import java.util.Locale

private const val VIEW_TYPE = "view"
private const val UNSUBSCRIPTION_TYPE = "unsubscription"
private const val SUBSCRIPTION_TYPE = "subscription"

fun countViewPerDay(model: List<Statistic>): List<VisitStatistic> = model
    .filter { it.type == VIEW_TYPE }
    .flatMap { it.dates }
    .mapNotNull { parseDate(it) }
    .groupingBy { it }
    .eachCount()
    .map { VisitStatistic(it.key, it.value) }
    .sortedBy { it.date }

fun countTotalVisits(model: List<Statistic>): Int = model
    .filter { it.type == VIEW_TYPE }
    .flatMap { it.dates }
    .size

fun countSubscribed(model: List<Statistic>): Int = model
    .filter { it.type == SUBSCRIPTION_TYPE }
    .flatMap { it.dates }
    .size

fun countUnsubscribed(model: List<Statistic>): Int = model
    .filter { it.type == UNSUBSCRIPTION_TYPE }
    .flatMap { it.dates }
    .size

fun groupByWeek(visits: List<VisitStatistic>): List<VisitStatistic> {
    val weekFields = WeekFields.of(Locale.getDefault())
    return visits
        .groupBy { Pair(it.date.year, it.date.get(weekFields.weekOfYear())) }
        .map { (yearWeek, weekVisits) ->
            VisitStatistic(
                date = weekVisits.minByOrNull { it.date }?.date ?: LocalDate.now(),
                visits = weekVisits.sumOf { it.visits }
            )
        }
        .sortedBy { it.date }
}

fun groupByMonth(visits: List<VisitStatistic>): List<VisitStatistic> {
    return visits
        .groupBy { it.date.withDayOfMonth(1) }
        .map { (monthDate, monthVisits) ->
            VisitStatistic(
                date = monthDate,
                visits = monthVisits.sumOf { it.visits }
            )
        }
        .sortedBy { it.date }
}

private fun parseDate(raw: Long): LocalDate? {
    return try {
        val str = raw.toString().padStart(8, '0')
        val day = str.substring(0, str.length - 6).toInt()
        val month = str.substring(str.length - 6, str.length - 4).toInt()
        val year = str.substring(str.length - 4).toInt()
        LocalDate.of(year, month, day)
    } catch (e: Exception) {
        null // или обрабатываем ошибку
    }
}