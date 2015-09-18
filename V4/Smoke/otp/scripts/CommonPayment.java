package V4.Smoke.otp.scripts;

import java.util.Map;

public interface CommonPayment {
	
	void makePayment(Map<String,String> sd,String ACH_types) throws InterruptedException;

}
