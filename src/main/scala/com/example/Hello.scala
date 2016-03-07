package com.example

import java.util.{Date, Locale}

import com.cronutils.descriptor.CronDescriptor
import com.cronutils.model.CronType
import com.cronutils.model.definition.CronDefinitionBuilder
import com.cronutils.parser.CronParser
import com.cronutils.validator.CronValidator
import it.sauronsoftware.cron4j._

object Hello {
  def main(args: Array[String]): Unit = {
    val descriptor = CronDescriptor.instance(Locale.UK)
    val cronDefinition =  CronDefinitionBuilder.instanceDefinitionFor(CronType.CRON4J)
    val cron4jParser= new CronParser(cronDefinition)
    println(descriptor.describe(cron4jParser.parse("/2 * * * *")))
    val validator = new CronValidator(cronDefinition)
    println(validator.isValid("30-59 11 * * *"))
    println(validator.isValid("hoge"))
    val scheduler = new Scheduler()
    scheduler.schedule("* * * * *", new CronTask())
    scheduler.start
    val scheduler2 = new Scheduler()
    scheduler2.schedule("* * * * *", new CronTask())
    scheduler2.start
    val scheduler3 = new Scheduler()
    scheduler3.schedule("* * * * *", new CronTask())
    scheduler3.start
    val scheduler4 = new Scheduler()
    scheduler4.schedule("* * * * *", new CronTask())
    scheduler4.start


    // try {
    //   val scheduler = new Scheduler()
    //   scheduler.schedule("* * * * *", new CronTask())
    //   scheduler.start()
    // } catch {
    //   case ex: InterruptedException => {
    //     ex.printStackTrace()
    //   }
    // }

    // debris of cronMapper
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
