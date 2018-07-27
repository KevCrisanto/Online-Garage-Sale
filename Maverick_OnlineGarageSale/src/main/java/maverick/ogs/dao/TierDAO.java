package maverick.ogs.dao;

import java.util.List;

import maverick.ogs.beans.Tier;

public interface TierDAO {
	public Integer addTier(Tier tier);
	public List<Tier> getAllTiers();
	public Boolean updateTier(Tier tier);
	public Tier getTierById(Integer id);
	public Boolean deleteTierById(Integer id);
}
