package maverick.ogs.service;

import maverick.ogs.beans.CreditCard;
import maverick.ogs.dao.CreditCardDAO;
import maverick.ogs.dao.CreditCardDAOImpl;

public class CreditCardService {

	public static String insertCreditCard(CreditCard card) {
		CreditCardDAO cd = new CreditCardDAOImpl();
		return cd.insertCreditCard(card);
	}
}
