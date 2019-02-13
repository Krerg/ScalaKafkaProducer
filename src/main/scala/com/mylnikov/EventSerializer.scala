package com.mylnikov

import java.util

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.serialization.Serializer

class EventSerializer extends Serializer[BookingEvent]{
  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {

  }

  override def serialize(topic: String, data: BookingEvent): Array[Byte] = {
    val mapper = new ObjectMapper()
    var retVal:Array[Byte] = null
    try
      mapper.writeValueAsString(data).getBytes
    catch {
      case e: Exception =>
        e.printStackTrace()
        null
    }

  }

  override def close(): Unit = {

  }
}
