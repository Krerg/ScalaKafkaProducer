package com.mylnikov

import java.util.Date

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

import scala.concurrent.forkjoin.ThreadLocalRandom
import scala.util.Random

/**
  * Runnable for generating event and sending them into Kafka
  *
  * @param minimumDelay minimum delay between sending events
  * @param maximumDelay maximum delay between sending events
  * @param producer kafka producer
  */
class GenerateEventJob(minimumDelay: Long, maximumDelay: Long, producer: KafkaProducer[String, BookingEvent]) extends Runnable{

  /**
    * For testing purposes.
    */
  private var stopped = false

  override def run(): Unit = {

    while(!stopped) {
      val delay = ThreadLocalRandom.current().nextLong(minimumDelay, maximumDelay)
      Thread.sleep(delay)
      producer.send(new ProducerRecord[String, BookingEvent]("test", generateEvent()))
    }

  }

  /**
    * Creates {@link BookingEvent} and randomize properties for it.
    * @return event woth ranomized properties
    */
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

  def stop(): Unit = {
    stopped = true
  }

}
