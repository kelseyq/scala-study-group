package org.womenwhocode.scala.app

import org.scalatra._
import java.util.Calendar

class ScalaStudyGroup extends ScalaStudyGroupStack {

  get("/") {
    <html>
      <body>
        <center>
        	<h1>Hello, world!</h1>
        	<center><img src="http://www.foodtruckcourt.com/img/fewdtruck.png"/></center>
        	<hr/>
      		<p>
       			It's {Calendar.getInstance().getTime()} and the Women Who Code Scala study group still rocks!
      		 </p>
       </center>
      </body>
    </html>
  }  
}
