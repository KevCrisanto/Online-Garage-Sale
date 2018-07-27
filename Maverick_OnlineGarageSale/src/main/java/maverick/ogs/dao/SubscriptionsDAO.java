package maverick.ogs.dao;

import java.util.List;

import maverick.ogs.beans.Subscriptions;

public interface SubscriptionsDAO {
	public Integer addSubscriptions(Subscriptions subscriptions);
	public List<Subscriptions> getAllSubscriptions();
	public Subscriptions updateSubscriptions(Subscriptions subscriptions);
	public Boolean deleteSubscriptionsById(String id);
	public Boolean deleteSubscriptions(Subscriptions subscriptions);
}
