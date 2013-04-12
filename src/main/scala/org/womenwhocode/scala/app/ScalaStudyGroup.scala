package org.womenwhocode.scala.app

import org.scalatra._
import java.util.Calendar

class ScalaStudyGroup extends ScalaStudyGroupStack {

  get("/") {
    <html>
      <body>
        <center>
        	<h1><blink>Hello, world!</blink></h1>
        	<center><img src="http://www.foodtruckcourt.com/img/fewdtruck.png"/></center>
        	<hr/>
      		<p>
       			It's {Calendar.getInstance().getTime()} and the Women Who Code Scala study group still rocks!
      		 </p>
      		<p>
      			<a href="/trucks">Food Truck List</a>
      		</p>
       </center>
      </body>
    </html>
  }  

  get("/trucks") {
  	<html>
  		<body>
  		TODO
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
