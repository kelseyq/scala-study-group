package org.womenwhocode.scala.app

import org.scalatra._
import java.util.Calendar

class ScalaStudyGroup extends ScalaStudyGroupStack {

  get("/") {
    contentType="text/html"
    val now = Calendar.getInstance().getTime()
    ssp("/index", "rightNow" -> now)
  }

  get("/trucks") {
    contentType="text/html"
    val theTruck = FoodTruckData.getAllFoodTrucks(0)

    //pattern matching on a case class
    val firstTruck = theTruck.cuisineType match {
      case Tacos => "Mexican!"
      case Indian => "Indian!"
      case _ => "Something else!"
    }

    //map and an anonymous function
    val tacoList = FoodTruckData.getAllFoodTrucks.map{
      //using pattern matching to extract members
      theTruck: FoodTruck => theTruck match {
        case FoodTruck(theName, Tacos, _, _) => theName + " Eff yeah!"
        case _ => theTruck.name + " (not tacos)"
      }
    }

    val myList = FoodTruckData.getAllFoodTrucks
    //pattern matching on a list
    val justOneTruck = myList match {
      case truckOne::restOfTheTrucks => truckOne.name
      case _ => "no trucks sorry!"
    }
   // ssp("/trucks", "firstTruck" -> firstTruck, "tacoList" -> tacoList, "justOneTruck" -> justOneTruck)

    val days: List[Day] = List(Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday)
    val foodTrucks = FoodTruckData.getAllFoodTrucks
    var listOfTrucksByDay = List[String]()
    val colors = List("blue", "yellow", "orange")

    val theAvailabilityList: List[String] = colors.flatMap{
      colors: String => days.flatMap {
        theDay: Day => foodTrucks.map {
          truck: FoodTruck =>
            if (theTruck.days.contains(theDay)) {
              truck.name + " is available on " + theDay
            }  else {
              truck.name + " is not available on " + theDay
            }
        }
      }
    }

    val availabilityList: List[String] = for {
      color <- colors
      day <- days
      truck <- foodTrucks
    } yield {
      if (truck.days.contains(day)) {
        truck.name + " is available on " + day + " in " + color
      }  else {
        truck.name + " is not available on " + day + " in " + color
      }
    }


    ssp("/trucks", "availability" -> availabilityList)
  }

  get("/trucks/new") {
  	<html>
  		<body>
  		<form method="post" action="/trucks/new">
  			Name: <input type="text" name="truckName"/><br/>
        Address: <input type="text" name="address"/><br/>
        <input type="submit"/>
  		</form>
  		</body>
  	</html>
  }

  post("/trucks/new") {
    val addressOpt: Option[String] = params.get("address")
    val nameOpt: Option[String] = params.get("name")

    val intOpt: Option[Int] = Some(4)
    val foodTruckOpt: Option[FoodTruck] = Some(FoodTruckData.foodTruckList(0))

    if (addressOpt.isDefined && nameOpt.isDefined)  {
      val newTruck = FoodTruck(name = addressOpt.get, address = nameOpt.get)
      FoodTruckData.foodTruckList = newTruck :: FoodTruckData.foodTruckList
      <html>
        <head>
          <title>Edited Truck List</title>
        </head>
        <body>
          <ul>
            {
            for {
              truck <- FoodTruckData.foodTruckList
            } yield {
              <li>{truck.name}</li>
            }
            }
          </ul>
        </body>
      </html>
    } else {
      <html>
      </html>
    }


  }

}
