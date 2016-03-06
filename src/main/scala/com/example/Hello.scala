package com.example

import com.cronutils.model.definition.CronDefinitionBuilder

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
    println("Hello, world!")
  }
}
