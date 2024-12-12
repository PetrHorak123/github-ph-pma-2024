package com.example.myapp016avanocniappka

import android.app.AlarmManager
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period

class ChristmasWidget : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            val views = RemoteViews(context.packageName, R.layout.widget_layout)

            // Set up the refresh button
            val refreshIntent = Intent(context, ChristmasWidget::class.java).apply {
                action = "com.example.myapp016avanocniappka.ACTION_REFRESH_WIDGET"
            }

            val refreshPendingIntent = PendingIntent.getBroadcast(
                context, 0, refreshIntent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

            views.setOnClickPendingIntent(R.id.refresh_button, refreshPendingIntent)

            // Update the widget
            updateWidget(context, appWidgetManager, appWidgetId)
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)

        if (intent.action == "com.example.myapp016avanocniappka.ACTION_REFRESH_WIDGET") {
            val appWidgetManager = AppWidgetManager.getInstance(context)
            val appWidgetIds = appWidgetManager.getAppWidgetIds(
                ComponentName(context, ChristmasWidget::class.java)
            )

            for (appWidgetId in appWidgetIds) {
                updateWidget(context, appWidgetManager, appWidgetId)
            }
        }
    }


    fun calculateTimeUntilChristmas(): String {
        val now = LocalDateTime.now()
        val christmas = LocalDateTime.of(LocalDate.now().year, 12, 25, 0, 0)

        val duration = if (now.isAfter(christmas)) {
            Duration.between(now, christmas.plusYears(1))
        } else {
            Duration.between(now, christmas)
        }

        val days = duration.toDays()
        val hours = duration.toHours() % 24
        val minutes = duration.toMinutes() % 60
        val seconds = duration.seconds % 60

        return "$days Days, $hours Hours, $minutes Minutes, $seconds Seconds"
    }

    private fun updateWidget(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int
    ) {
        val views = RemoteViews(context.packageName, R.layout.widget_layout)
        views.setTextViewText(R.id.countdown_text, calculateTimeUntilChristmas())
        appWidgetManager.updateAppWidget(appWidgetId, views)
    }

}