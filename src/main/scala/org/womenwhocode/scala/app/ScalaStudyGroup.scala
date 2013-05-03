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
  		<form method="post" action="trucks/new">
  			Name: <input type="text" name="truckName"/><br/>
        Address: <input type="text" name="address"/><br/>
        Type:
<select name="cuisine">
  <option>Milk</option>
  <option>Coffee</option>
  <option>Tea</option>
</select><br/>
			Days: <input type="checkbox" name="monday" value="Monday"/> Monday<br/>
			<input type="checkbox" name="monday" value="Monday"/>Tuesday<br/>
			<input type="checkbox" name="monday" value="Monday"/>Wednesday<br/>
			<input type="checkbox" name="monday" value="Monday"/>Thursday<br/>
			<input type="checkbox" name="monday" value="Monday"/>Friday<br/>
			<input type="checkbox" name="monday" value="Monday"/>Saturday<br/>
			<input type="checkbox" name="monday" value="Monday"/>Sunday<br/>

  		</form>
  		</body>
  	</html>
  }

}
