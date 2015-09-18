package V4.Smoke.client_console.scripts;

import java.util.Map;

public interface CommonPayment_clientconsole {
	String makePayment(Map<String,String> sd,String ACH_types,Map<String, String>accountdetails) throws InterruptedException;
}

