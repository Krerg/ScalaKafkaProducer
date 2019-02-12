package com.mylnikov

import java.util.Properties

import org.apache.kafka.clients.producer.KafkaProducer
import org.spark_project.jetty.util.thread.{ExecutorThreadPool, ThreadPool}

object KafkaDaemon {

  val DEFAULT_THREAD_SIZE = 5

  val MINIMUM_EVENT_DELAY = 0

  val MAXIMUM_EVENT_DELAY = 70

  def main(args: Array[String]): Unit = {

    val  props = new Properties()
    props.put("bootstrap.servers", "localhost:6667")

    //props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
   // props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")

    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")


    val producer = new KafkaProducer[String, String](props)

    val THREAD_POOL = new ExecutorThreadPool(DEFAULT_THREAD_SIZE);
    THREAD_POOL.execute(new GenerateEventJob(MINIMUM_EVENT_DELAY, MAXIMUM_EVENT_DELAY, producer))

  }

}
