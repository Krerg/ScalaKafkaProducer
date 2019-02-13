package com.mylnikov

import java.util.Date

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

import scala.concurrent.forkjoin.ThreadLocalRandom
import scala.util.Random

class GenerateEventJob(minimumDelay: Long, maximumDelay: Long, producer: KafkaProducer[String, BookingEvent]) extends Runnable{
  override def run(): Unit = {

    while(true) {
      val delay = ThreadLocalRandom.current().nextLong(minimumDelay, maximumDelay)
      Thread.sleep(delay)
      producer.send(new ProducerRecord[String, BookingEvent]("test", generateEvent()))
    }

  }

  def generateEvent() : BookingEvent = {
    BookingEvent(
      new Date(ThreadLocalRandom.current().nextLong()),
      ThreadLocalRandom.current().nextInt(),
      ThreadLocalRandom.current().nextInt(),
      ThreadLocalRandom.current().nextInt(),
      ThreadLocalRandom.current().nextInt(),
      ThreadLocalRandom.current().nextInt(),
      ThreadLocalRandom.current().nextDouble(),
      ThreadLocalRandom.current().nextInt(),
      ThreadLocalRandom.current().nextBoolean(),
      ThreadLocalRandom.current().nextBoolean(),
      ThreadLocalRandom.current().nextInt(),
      Random.nextString(10),
      Random.nextString(10),
      ThreadLocalRandom.current().nextInt(),
      ThreadLocalRandom.current().nextInt(),
      ThreadLocalRandom.current().nextInt(),
      ThreadLocalRandom.current().nextInt(),
      ThreadLocalRandom.current().nextInt(),
      ThreadLocalRandom.current().nextInt(),
      ThreadLocalRandom.current().nextBoolean(),
      ThreadLocalRandom.current().nextLong(),
      ThreadLocalRandom.current().nextInt()
    )
  }

}
