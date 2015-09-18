package V4.Smoke.otp.applibs;

import core.webwidgets.TextField;

public class otp_CreditCardEntryPAge {
	 
		public static TextField Credit_Card_Num() {
			return new TextField("//input[@name='cardNumber']");
			 
	}

		public static void EnterCreditCardNumber(String sText) {
			Credit_Card_Num().setText(sText);

  }
		public static boolean isCreditcardnumebrtextpresent() {
			return Credit_Card_Num().isVisible();
		}
		
		public static void Entercardnumber(String cardnumber) {
			
			otp_CreditCardEntryPAge.EnterCreditCardNumber(cardnumber);

			Otp_CreditCardPayementPage.Click_Continue();
		}
}
