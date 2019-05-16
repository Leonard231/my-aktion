package services;

import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import model.Campaign;

@RequestScoped
public class CampaignServiceBean implements CampaignService {

	@Override
	public List<Campaign> getAllCampaigns() {
		return new LinkedList<Campaign>();
	}

}
