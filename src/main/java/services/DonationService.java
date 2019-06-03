package services;

import model.Donation;
import services.exceptions.ObjectNotFoundException;

import java.util.List;

public interface DonationService {
    List<Donation> getDonationList(Long campaignId);

    void addDonation(Long campaignId, Donation donation);

    void transferDonations();

    List<Donation> getDonationListPublic(Long campaignId) throws ObjectNotFoundException;
}
