package services;

import java.util.List;
import model.Campaign;

public interface CampaignService {
	List<Campaign> getAllCampaigns();
	
	void addCampaign(Campaign campaign);
	
	void deleteCampaign(Campaign campaign);
	
	void updateCampaign(Campaign campaign);
}
