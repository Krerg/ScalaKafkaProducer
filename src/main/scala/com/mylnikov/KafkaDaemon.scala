package com.mylnikov

import org.spark_project.jetty.util.thread.{ExecutorThreadPool, ThreadPool}

object KafkaDaemon {

  val DEFAULT_THREAD_SIZE = 5

  val MINIMUM_EVENT_DELAY = 0

  val MAXIMUM_EVENT_DELAY = 70

  def main(args: Array[String]): Unit = {

    val THREAD_POOL = new ExecutorThreadPool(DEFAULT_THREAD_SIZE);
    THREAD_POOL.exe

  }

}
