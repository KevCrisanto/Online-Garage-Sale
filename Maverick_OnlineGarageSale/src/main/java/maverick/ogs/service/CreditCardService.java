package maverick.ogs.service;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import maverick.ogs.beans.CreditCard;
import maverick.ogs.dao.CreditCardDAO;
import maverick.ogs.dao.CreditCardDAOImpl;

public class CreditCardService {

	public static String insertCreditCard(CreditCard card) {
		CreditCardDAO cd = new CreditCardDAOImpl();
		return cd.insertCreditCard(card);
	}
	
	public static List<CreditCard> getAllCreditCards(){
		CreditCardDAO cd = new CreditCardDAOImpl();
		return cd.getAllCards();
	}
	
	public static String getAllCreditCardsJSON(){
		List<CreditCard> cards = getAllCreditCards();
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		
		try {
			json = mapper.writeValueAsString(cards);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return json;
	}
	
	public static List<CreditCard> getUserCreditCardsById(String id){
		CreditCardDAO cd = new CreditCardDAOImpl();
		return cd.getCreditCardsUserHas(id);
	}
	
	public static String getUserCreditCardsByIdJSON(String id) {
		List<CreditCard> cards = getUserCreditCardsById(id);
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		
		try {
			json = mapper.writeValueAsString(cards);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return json;
	}
	
	public static Boolean updateCreditCardById(String id, CreditCard card) {
		CreditCardDAO cd = new CreditCardDAOImpl();
		return cd.updateCreditCardById(id, card);
	}
	
	public static Boolean deleteCreditCardById(String id) {
		CreditCardDAO cd = new CreditCardDAOImpl();
		return cd.deleteCreditCardById(id);
	}
}
