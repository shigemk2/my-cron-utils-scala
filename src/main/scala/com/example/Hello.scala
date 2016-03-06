package com.example

import java.lang.InterruptedException
import java.util.Date

import com.cronutils.mapper.CronMapper
import com.cronutils.model.definition.CronDefinitionBuilder
import it.sauronsoftware.cron4j._

object Hello {
  def main(args: Array[String]): Unit = {
    val cronDefinition =
      CronDefinitionBuilder.defineCron()
      .withSeconds().and()
      .withMinutes().and()
      .withHours().and()
      .withDayOfMonth()
      .supportsHash().supportsL().supportsW().and()
      .withMonth().and()
      .withDayOfWeek()
      .withIntMapping(7, 0)
      .supportsHash().supportsL().supportsW().and()
      .withYear().and()
      .lastFieldOptional()
      .instance()
    println(cronDefinition)
    try {
      val scheduler = new Scheduler()
      scheduler.schedule("* * * * *", new CronTask())
      scheduler.start()
    } catch {
      case ex: InterruptedException => {
        ex.printStackTrace()
      }
    }
    // val cronMapper = new CronMapper(
    //   cronDefinition,
    //   CronDefinitionBuilder.instanceDefinitionFor()
    // )
    println("Hello, world!")
  }
}

class CronTask extends Runnable {
  def run(): Unit = {
    println(new Date() + ": Hello cron4j!")
  }
}
