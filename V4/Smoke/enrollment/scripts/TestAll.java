package V4.Smoke.enrollment.scripts;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;






@RunWith(Suite.class)
@SuiteClasses(
		{ 
			
			Test_Erm_Add_BankAc.class,
			Test_Erm_Autopayment.class
			}
		)
public class TestAll
{

}
