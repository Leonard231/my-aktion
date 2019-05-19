package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import model.Campaign;
import model.Donation;

@Stateless
public class DonationServiceBean implements DonationService {

	
	@Inject
	private EntityManager entityManager;

	@Override
	public List<Donation> getDonationList(Long campaignnId) {
		Campaign managedCampaign = entityManager.find(Campaign.class, campaignnId);
		List<Donation> donations = managedCampaign.getDonations();
		donations.size();
		return donations;
	}

	@Override
	public void addDonation(Long campaignId, Donation donation) {
		Campaign managedCampaign = entityManager.find(Campaign.class, campaignId);
		donation.setCampaign(managedCampaign);
		entityManager.persist(donation);
	}
	
}
