package maverick.ogs.dao;

import java.util.List;

import maverick.ogs.beans.Subscriptions;

public interface SubscriptionsDAO {
	public Integer addSubscriptions(Subscriptions subscriptions);
	public List<Subscriptions> getAllSubscriptions();
	public Subscriptions updateSubscriptions(String userId, Subscriptions subscriptions);
	public Boolean deleteSubscriptionById(String userId, String id);
}
