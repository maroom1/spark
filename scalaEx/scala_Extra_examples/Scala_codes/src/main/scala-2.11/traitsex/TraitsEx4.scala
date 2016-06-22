package traitsex

/**
  * Created by Goduguluri on 6/21/2016.
  */
object TraitsEx4 extends App{


  abstract class Check {
    def check() : String = "Checked Application Details..."
  }

  trait CreditCheck extends Check {
    override def check() : String = "Checked Credit..."+ super.check()
  }

  trait EmploymentCheck extends Check {
    override def check() : String = "Checked Employment..." + super.check()
  }
  trait CriminalRecordCheck extends Check {
    override def check() : String = "Checked Criminal Records..."+ super.check()
  }


  val apartmentApplication = new Check with CreditCheck with CriminalRecordCheck
  //criminal record check ---super--> Credit check --super ---> check vlass
  println(apartmentApplication check)

  val emplomentApplication = new Check with CriminalRecordCheck with EmploymentCheck
  println(emplomentApplication check)

}
