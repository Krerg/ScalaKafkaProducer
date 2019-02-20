package com.mylnikov

import java.util.Date

import scala.beans.BeanProperty

case class BookingEvent(@BeanProperty dateTime: Date = null,
                        @BeanProperty siteName: Int = 0,
                        @BeanProperty posaContinent: Int = 0,
                        @BeanProperty userLocationCountry: Int = 0,
                        @BeanProperty userLocationRegion: Int = 0,
                        @BeanProperty userLocationCity: Int = 0,
                        @BeanProperty origDestinationDistance: Double = 0,
                        @BeanProperty userId: Int = 0,
                        @BeanProperty mobile: Boolean = false,
                        @BeanProperty package_ : Boolean = false,
                        @BeanProperty channel: Int = 0,
                        @BeanProperty srchCi: String = null,
                        @BeanProperty srchCo: String = null,
                        @BeanProperty srchAdultsCnt: Int = 0,
                        @BeanProperty srchRmCnt: Int = 0,
                        @BeanProperty srchDestinationId: Int = 0,
                        @BeanProperty srchDestinationTypeId: Int = 0,
                        @BeanProperty hotelContinent: Int = 0,
                        @BeanProperty hotelMarket: Int = 0,
                        @BeanProperty booking: Boolean = false,
                        @BeanProperty cnt: Long = 0,
                        @BeanProperty hotelCluster: Int = 0
                       ) {

  def this() {
    this(dateTime = new Date(), srchCi = "", srchCo = "")
  }

}