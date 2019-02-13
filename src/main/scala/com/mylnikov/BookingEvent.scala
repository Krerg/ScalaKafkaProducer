package com.mylnikov

import java.util.Date

import scala.beans.BeanProperty

case class BookingEvent(@BeanProperty var dateTime: Date,
                        @BeanProperty var siteName: Int,
                        @BeanProperty var posaContinent: Int,
                        @BeanProperty var userLocationCountry: Int,
                        @BeanProperty var userLocationRegion	: Int,
                        @BeanProperty var userLocationCity	: Int,
                        @BeanProperty var origDestinationDistance	: Double,
                        @BeanProperty var userId	: Int,
                        @BeanProperty var isMobile	: Boolean,
                        @BeanProperty var isPackage	: Boolean,
                        @BeanProperty var channel	: Int,
                        @BeanProperty var srchCi	: String,
                        @BeanProperty var srchCo	: String,
                        @BeanProperty var srchAdultsCnt	: Int,
                        @BeanProperty var srchRmCnt	: Int,
                        @BeanProperty var srchDestinationId	: Int,
                        @BeanProperty var srchDestinationTypeId	: Int,
                        @BeanProperty var hotelContinent	: Int,
                        @BeanProperty var hotelMarket	: Int,
                        @BeanProperty var isBooking	: Boolean,
                        @BeanProperty var cnt	: Long,
                        @BeanProperty var hotelCluster	: Int
                       ) {
}

