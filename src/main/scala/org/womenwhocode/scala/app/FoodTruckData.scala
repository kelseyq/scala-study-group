package org.womenwhocode.scala.app

object FoodTruckData {
	val MayoMustard = FoodTruck("Mayo and Mustard", Deli, "123 Fake St", List(Monday, Wednesday))
	val CurryUpNow = FoodTruck("Curry Up Now", Indian, "505 Anywhere Dr", List(Tuesday, Thursday))
	val BaconBacon = FoodTruck("Bacon Bacon", Other, "1000 Bacon Thruway", List(Tuesday, Saturday, Sunday))
	val ChairmanBao = FoodTruck("Chairman Bao", Chinese, "123 Fake St", List(Monday))
	val RoliRoti = FoodTruck("RoliRoti", BBQ, "123 Fake St", List(Friday, Saturday))
	val RoachCoach = FoodTruck("Ye Olde Roach Coach", Tacos, "123 Fake St", List(Thursday, Saturday))
	val TandooriUSA = FoodTruck("Tandoori USA", Indian, "505 Anywhere Dr", List(Monday, Wednesday))

	val foodTruckList = List[FoodTruck](MayoMustard, CurryUpNow, BaconBacon, ChairmanBao, RoliRoti, RoachCoach, TandooriUSA)

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
case object Chinese extends TruckType
case object BBQ extends TruckType
case object Deli extends TruckType
case object Other extends TruckType