package com.mylnikov

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

import scala.concurrent.forkjoin.ThreadLocalRandom

class GenerateEventJob(minimumDelay: Long, maximumDelay: Long, producer: KafkaProducer[String, String]) extends Runnable{
  override def run(): Unit = {

    while(true) {
      val delay = ThreadLocalRandom.current().nextLong(minimumDelay, maximumDelay)
      Thread.sleep(delay)
      val event = new Event()
      producer.send(new ProducerRecord[String, String]("test", "ffgdfgdfgdfgdfg"));
    }

  }
}
