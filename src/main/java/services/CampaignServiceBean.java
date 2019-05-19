package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Campaign;

@Stateless
public class CampaignServiceBean implements CampaignService {

	@Override
	public List<Campaign> getAllCampaigns() {
		
		TypedQuery<Campaign> query = entityManager.createNamedQuery(Campaign.findAll, Campaign.class);
		List<Campaign> campaigns = query.getResultList();
		campaigns.forEach(campaign -> campaign.setAmountDonatedSoFar(getAmountDonatedSoFar(campaign)));
		return campaigns;
	}
	
	@Inject
	EntityManager entityManager;

	@Override
	public void addCampaign(Campaign campaign) {
		entityManager.persist(campaign);	
	}

	@Override
	public void deleteCampaign(Campaign campaign) {
		Campaign managedCampaign = entityManager.find(Campaign.class, campaign.getId());
		entityManager.remove(managedCampaign);
	}

	@Override
	public void updateCampaign(Campaign campaign) {
		entityManager.merge(campaign);
	}

	private Double getAmountDonatedSoFar(Campaign campaign) {
		TypedQuery<Double> query = entityManager.createNamedQuery(Campaign.getAmountDonatedSoFar, Double.class);
		query.setParameter("campaign", campaign);
		Double result = query.getSingleResult();
		if(result==null) {
			result = 0d;
		}
		
		return result;
	}
	
}
