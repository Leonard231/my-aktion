package services;

import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;

import model.Account;
import model.Campaign;
import model.Donation;
import model.Donation.Status;

@RequestScoped
@Alternative
public class MockCampaignServiceBean implements CampaignService {

	@Override
	public List<Campaign> getAllCampaigns() {
        Donation donation1 = new Donation();
        donation1.setDonorName("Calvin Klein");
        donation1.setAmount(20d);
        donation1.setReceiptRequested(true);
        donation1.setStatus(Status.TRANSFERRED);
        donation1.setAccount(new Account(donation1.getDonorName(), "KSK GP", "DE12640512000230103401"));
        
        Donation donation2 = new Donation();
        donation2.setDonorName("Ruben Troyka");
        donation2.setAmount(30d);
        donation2.setReceiptRequested(false);
        donation2.setStatus(Status.IN_PROCESS);
        donation2.setAccount(new Account(donation1.getDonorName(), "VoBa S", "DE12640912000645454824"));
        
        List<Donation> spenden = new LinkedList<>();
        spenden.add(donation1);
        spenden.add(donation2);
        
        Campaign campaign1 = new Campaign();
        campaign1.setName("Latzhose für Calvin");
        campaign1.setTargetAmount(1000d);
        campaign1.setAmountDonatedSoFar(258d);
        campaign1.setDonationMinimum(20d);
        campaign1.setId(1L);
        campaign1.setAccount(new Account("Timo Strobel", "KSK TÜ", "DE87640523130542198247"));
        campaign1.setDonations(spenden);
        
        Campaign campaign2 = new Campaign();
        campaign2.setName("Freibier");
        campaign2.setTargetAmount(2500d);
        campaign2.setAmountDonatedSoFar(1200d);
        campaign2.setDonationMinimum(25d);
        campaign2.setId(2L);
        campaign2.setAccount(campaign1.getAccount());
        campaign2.setDonations(spenden);
        
        List<Campaign> ret = new LinkedList<>();
        ret.add(campaign1);
        ret.add(campaign2);
        
        return ret;
	}

	@Override
	public void addCampaign(Campaign campaign) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCampaign(Campaign campaign) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCampaign(Campaign campaign) {
		// TODO Auto-generated method stub
		
	}

}