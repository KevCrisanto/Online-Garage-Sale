package maverick.ogs.dao;

import java.util.List;

import maverick.ogs.beans.CreditCard;

public interface CreditCardDAO {
	public Integer insertCreditCard(CreditCard creditCard);
	public List<CreditCard> getAllCards();
	public List<CreditCard> getCreditCardsUserHas(String accountId);
	public CreditCard updateCreditCardById(String creditCardId, CreditCard card);
	public CreditCard deleteCreditCardById(String creditCardId);
	
}
