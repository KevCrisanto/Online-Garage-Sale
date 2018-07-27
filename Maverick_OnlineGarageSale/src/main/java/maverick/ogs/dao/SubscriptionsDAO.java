package maverick.ogs.dao;

import java.util.List;

import maverick.ogs.beans.Subscriptions;
import maverick.ogs.beans.Tier;

public interface SubscriptionsDAO {
	public Integer addSubscriptions(Subscriptions subscriptions);
	public Subscriptions addTier(Subscriptions subscriptions, Tier tier);
	public List<Subscriptions> getAllSubscriptions();
	public Boolean updateSubscriptions(Subscriptions subscriptions);
	public Boolean deleteSubscriptionsById(String id);
	public Boolean deleteSubscriptions(Subscriptions subscriptions);
}
