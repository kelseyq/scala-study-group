package org.womenwhocode.scala.app

import org.scalatra._
import java.util.Calendar

class ScalaStudyGroup extends ScalaStudyGroupStack {

  get("/") {
    <html>
      <body>
        <center>
        	<h1><blink>Hello, world!</blink></h1>
          <center><img src="/images/fewdtruck.png"/></center>
        	<hr/>
      		<p>
       			It's {Calendar.getInstance().getTime()} and the Women Who Code Scala study group still rocks!
      		</p>
      		<p>
      			<a href="/trucks">Food Truck List!!!! YEA!</a>
      		</p>
       </center>
      </body>
    </html>
  }

  get("/trucks") {
  	<html>
  		<body>
  		<h2>The first truck is...</h2>
  		{
  		    val theTruck = FoodTruckData.getAllFoodTrucks(0) 
  			//pattern matching on a case class
  		    theTruck.cuisineType match {
  		    	case Tacos => <p>Mexican!</p>
  		    	case Indian => <p>Indian!</p>
  		    	case _ => <p>Something else!</p>
  		    }
  		}
  		<h2>Is it tacos?</h2>
  		<ul>
  		{

  			//map and an anonymous function
  	      FoodTruckData.getAllFoodTrucks.map{
  	      		//using pattern matching to extract members
  	      		theTruck: FoodTruck => theTruck match {
  	      			case FoodTruck(theName, Tacos, _, _) => <li>{theName}! Eff yeah!</li>
  	      			case _ => <li>{theTruck.name} (not tacos)</li>
  	      		}
  	      	}
		}
		</ul>
		<h2>Just one truck</h2>
		{
			val myList = FoodTruckData.getAllFoodTrucks
			//pattern matching on a list
			myList match {
				case firstTruck::restOfTheTrucks => <li>{firstTruck.name}</li>
				case _ => <li>no trucks sorry!</li>
			}

  		}
  		</body>
  	</html>
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
