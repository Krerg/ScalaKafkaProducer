package com.mylnikov

import java.util.Properties

import org.apache.kafka.clients.producer.KafkaProducer
import org.spark_project.jetty.util.thread.{ExecutorThreadPool, ThreadPool}

/**
  * Entry point of program.
  * Launches the kafka producer and jobs in parallel for sending events.
  */
object KafkaDaemon {

  val DEFAULT_THREAD_SIZE = 10

  val MINIMUM_EVENT_DELAY = 20

  val MAXIMUM_EVENT_DELAY = 50

  def main(args: Array[String]): Unit = {

    if (args.length < 2) {
      throw new IllegalArgumentException("You should specify bootstrap server and topic in arguments in arguments")
    }

    // Kafka config
    val props = new Properties()
    props.put("bootstrap.servers", args(0))
    props.put("value.serializer", "com.mylnikov.EventSerializer")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")

    val producer = new KafkaProducer[String, BookingEvent](props)

    val THREAD_POOL = new ExecutorThreadPool(DEFAULT_THREAD_SIZE)

    // Launch jobs in parallel
    for (i <- 0 to DEFAULT_THREAD_SIZE) {
      THREAD_POOL.execute(new GenerateEventJob(MINIMUM_EVENT_DELAY, MAXIMUM_EVENT_DELAY, producer, args(2)))
    }
  }

}
