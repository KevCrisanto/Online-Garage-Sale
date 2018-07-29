package maverick.ogs.dao;

import java.util.List;

import maverick.ogs.beans.CreditCard;

public interface CreditCardDAO {
	public String insertCreditCard(CreditCard creditCard);
	public List<CreditCard> getAllCards();
	public List<CreditCard> getCreditCardsUserHas(String accountId);
	public Boolean updateCreditCardById(String creditCardId, CreditCard card);
	public Boolean deleteCreditCardById(String creditCardId);
}
