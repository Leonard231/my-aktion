package services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Campaign;
import model.Donation;
import model.Donation.Status;

@Stateless
public class DonationServiceBean implements DonationService {

	@Inject
	private Logger logger;
	
	@Inject
	private EntityManager entityManager;

	@Override
	@RolesAllowed("Organizer")
	public List<Donation> getDonationList(Long campaignId) {
		Campaign managedCampaign = entityManager.find(Campaign.class, campaignId);
		List<Donation> donations = managedCampaign.getDonations();
		donations.size();
		return donations;
	}

	@Override
	@PermitAll
	public void addDonation(Long campaignId, Donation donation) {
		Campaign managedCampaign = entityManager.find(Campaign.class, campaignId);
		donation.setCampaign(managedCampaign);
		entityManager.persist(donation);
	}

	@Override
	@PermitAll
	public void transferDonations() {
		logger.log(Level.INFO, "log.transferDonation.start");
		TypedQuery<Donation> query = entityManager.createNamedQuery(Donation.findByStatus, Donation.class);
		query.setParameter("status", Status.IN_PROCESS);
		List<Donation> donations = query.getResultList();
		donations.forEach(donation -> donation.setStatus(Status.TRANSFERRED));
		logger.log(Level.INFO, "log.transferDonation.done", new Object[] {donations.size()});
	}
	
}
