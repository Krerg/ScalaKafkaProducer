package com.mylnikov

import java.util

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.serialization.Serializer

import scala.util.{Failure, Success}

/**
  * Serializer for [[BookingEvent]].
  * Serializer output is JSON representation of object.
  */
class EventSerializer extends Serializer[BookingEvent]{

  val mapper= new ObjectMapper()

  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {
  }

  override def serialize(topic: String, data: BookingEvent): Array[Byte] = {
    try mapper.writeValueAsString(data).getBytes match {
      case bytes: Array[Byte] => bytes
      case ex => Array.emptyByteArray
    }
  }

  override def close(): Unit = {
  }
}
