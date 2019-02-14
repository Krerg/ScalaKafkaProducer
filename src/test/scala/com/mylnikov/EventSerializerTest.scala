package com.mylnikov

import java.util.Date

import com.fasterxml.jackson.databind.ObjectMapper
import org.scalatest.FunSuite

import scala.concurrent.forkjoin.ThreadLocalRandom
import scala.util.Random

class EventSerializerTest extends FunSuite {

  val eventSerializer = new EventSerializer()

  test("Should serialize event") {
    val event = BookingEvent(
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
    val serializedEvent = eventSerializer.serialize("test",event)
    val objectMapper = new ObjectMapper()
    val deserializedEvent = objectMapper.readValue(serializedEvent, classOf[BookingEvent])
    assert(deserializedEvent.equals(event))
  }

  test("Should return null in case null object") {
    val deserializedEvent = eventSerializer.serialize("test", null)
    assert(deserializedEvent.length == 4)
  }


}
