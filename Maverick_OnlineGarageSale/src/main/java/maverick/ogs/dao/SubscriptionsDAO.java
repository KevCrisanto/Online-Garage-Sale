package maverick.ogs.dao;

import java.util.List;

import maverick.ogs.beans.Subscriptions;
import maverick.ogs.beans.Tier;

public interface SubscriptionsDAO {
	public Integer addSubscriptions(Subscriptions subscriptions);
	public Subscriptions addTier(Subscriptions subscriptions, Tier tier);
	public List<Subscriptions> getAllSubscriptions();
	public Subscriptions updateSubscriptions(Subscriptions subscriptions);
	public Subscriptions getSubscriptionById(Integer id);
	public Boolean deleteSubscriptionsById(Integer id);
	public Boolean deleteSubscriptions(Subscriptions subscriptions);
}
