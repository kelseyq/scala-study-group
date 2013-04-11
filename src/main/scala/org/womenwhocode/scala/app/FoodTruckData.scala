package org.womenwhocode.scala.app

object FoodTruckData {
	val MayoMustard = FoodTruck("Mayo and Mustard", Deli, "123 Fake St", List(Monday, Wednesday))
	val CurryUpNow = FoodTruck("Curry Up Now", Indian, "505 Anywhere Dr", List(Tuesday, Thursday))
	val BaconBacon = FoodTruck("Bacon Bacon", Other, "1000 Bacon Thruway", List(Tuesday, Saturday, Sunday))


	val foodTruckList = List[FoodTruck](MayoMustard, CurryUpNow, BaconBacon)

	def getAllFoodTrucks: List[FoodTruck] = foodTruckList
}

case class FoodTruck(name: String, cuisineType: TruckType, address: String, days: List[Day])

sealed trait Day
case object Monday extends Day
case object Tuesday extends Day
case object Wednesday extends Day
case object Thursday extends Day
case object Friday extends Day
case object Saturday extends Day
case object Sunday extends Day

sealed trait TruckType
case object Tacos extends TruckType
case object Indian extends TruckType
case object Burgers extends TruckType
case object Korean extends TruckType
case object BBQ extends TruckType
case object Deli extends TruckType
case object Other extends TruckType