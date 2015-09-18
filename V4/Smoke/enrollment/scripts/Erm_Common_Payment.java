package V4.Smoke.enrollment.scripts;

import java.util.Map;

/**Interface consists of the metohods needs to be implemented for making payments
 * @author patilpa
 *
 */
public interface Erm_Common_Payment
{

	String makePayment(Map<String,String> sd,String ACH_types) throws InterruptedException;
	String oneTimePayment(Map<String,String> sd,String ACH_types) throws InterruptedException;

	
}
