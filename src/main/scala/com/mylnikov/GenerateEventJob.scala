package com.mylnikov

import scala.concurrent.forkjoin.ThreadLocalRandom

class GenerateEventJob(minimumDelay: Long, maximumDelay: Long) extends Runnable{
  override def run(): Unit = {

    while(true) {
      val delay = ThreadLocalRandom.current().nextLong(minimumDelay, maximumDelay);
      Thread.sleep(delay)
      val event = new Event()

    }

  }
}
