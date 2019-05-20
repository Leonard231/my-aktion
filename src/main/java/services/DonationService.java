package services;

import java.util.List;

import model.Donation;

public interface DonationService {
	
	List<Donation> getDonationList(Long campaignnId);
	
	void addDonation(Long campaignId, Donation donation);
	
	void transferDonations();

}
