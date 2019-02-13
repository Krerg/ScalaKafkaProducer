package com.mylnikov

import java.util.Properties

import org.apache.kafka.clients.producer.KafkaProducer
import org.spark_project.jetty.util.thread.{ExecutorThreadPool, ThreadPool}

object KafkaDaemon {

  val DEFAULT_THREAD_SIZE = 5

  val MINIMUM_EVENT_DELAY = 500

  val MAXIMUM_EVENT_DELAY = 1500

  def main(args: Array[String]): Unit = {

    if (args.length < 1) {
      throw new IllegalArgumentException("You should specify bootstrap server in arguments")
    }

    val props = new Properties()
    props.put("bootstrap.servers", args(0))
    props.put("value.serializer", "com.mylnikov.EventSerializer")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")

    val producer = new KafkaProducer[String, BookingEvent](props)

    val THREAD_POOL = new ExecutorThreadPool(DEFAULT_THREAD_SIZE)

    (0 to DEFAULT_THREAD_SIZE) ->
      THREAD_POOL.execute(new GenerateEventJob(MINIMUM_EVENT_DELAY, MAXIMUM_EVENT_DELAY, producer))

  }

}
