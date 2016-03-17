package com.example

import java.util.Locale

import com.cronutils.descriptor.CronDescriptor
import com.cronutils.model.CronType
import com.cronutils.model.definition.CronDefinitionBuilder
import com.cronutils.parser.CronParser
import org.joda.time.DateTime

object Hello {
  def main(args: Array[String]): Unit = {
    val cronDefinition = CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ)
    val parser = new CronParser(cronDefinition)
    val now = DateTime.now()
    val descriptor = CronDescriptor.instance(Locale.UK)
    // val executionTime = ExecutionTime.forCron(parser.parse("* 49 * * * ? 2016"))
    println(descriptor.describe(parser.parse("* * * * *")))
  }
}