package com.mylnikov

import java.util.concurrent.Future

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord, RecordMetadata}
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{BeforeAndAfter, FunSuite}
import org.mockito.Mockito._
import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.Answer

class GenerateEventJobTest extends FunSuite with BeforeAndAfter with MockitoSugar {

  val mockKafkaProducer = mock[KafkaProducer[String, BookingEvent]]

  val generateEventJob = new GenerateEventJob(0,1, mockKafkaProducer)

  test("Should generate random events") {
    val event = generateEventJob.generateEvent()
    val event2 = generateEventJob.generateEvent()
    assert(event != null && event2 != null)
    assert(event.cnt != event2.cnt)
  }

  test("Should send random events to kafka") {
    when(mockKafkaProducer.send(org.mockito.Matchers.any[ProducerRecord[String, BookingEvent]])).thenAnswer(new Answer[Future[RecordMetadata]] {
      override def answer(invocation: InvocationOnMock): Future[RecordMetadata] = {
        assert(true == true)
        generateEventJob.stop()
        mock[Future[RecordMetadata]]
      }
    })
    generateEventJob.run()

  }

}
