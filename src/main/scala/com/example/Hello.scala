package com.example

import com.cronutils.model.CronType
import com.cronutils.model.definition.CronDefinitionBuilder
import com.cronutils.model.time.ExecutionTime
import com.cronutils.parser.CronParser
import org.joda.time.DateTime

object Hello {
  def main(args: Array[String]): Unit = {
    val cronDefinition = CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ)
    val parser = new CronParser(cronDefinition)
    val now = DateTime.now
    // val cronField = CronField
    // val cron = new Cron(cronDefinition, java.util.List[CronField])
    val executionTime = ExecutionTime.forCron(parser.parse("? 49 * * * ? 2016"))
    println(executionTime.lastExecution(now))
    println(executionTime.timeFromLastExecution(now))
    println(executionTime.timeToNextExecution(now).getStandardMinutes) // returns minutes to next cron
  }
}