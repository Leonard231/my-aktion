package controller;

import model.Campaign;
import model.Donation;
import services.DonationService;
import util.Events.Deleted;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import data.CampaignProducer;

import java.io.Serializable;
import java.util.List;


@SessionScoped
@Named
public class ListCampaignsController implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1461895254521475653L;

    @Inject
    private CampaignProducer campaignProducer;
    
    @Inject
    private Event<Campaign> campaignDeleteEvent;
    
    @Inject
    private DonationService donationService;
    
    @Deleted
    private Campaign campaignToDelete;
    
    public String doAddCampaign() {
        campaignProducer.prepareAddCampaign();
        return Pages.EDIT_CAMPAIGN;
    }
    
    public String doEditCampaign(Campaign campaign) {
        campaignProducer.prepareEditCampaign(campaign);
        return Pages.EDIT_CAMPAIGN;
    }
    
    public String doEditDonationForm(Campaign campaign) {
        campaignProducer.setSelectedCampaign(campaign);
        return Pages.EDIT_DONATION_FORM;
    }
    
    public String doListDonations(Campaign campaign) {
    	final List<Donation> donations = donationService.getDonationList(campaign.getId());
    	campaign.setDonations(donations);
        campaignProducer.setSelectedCampaign(campaign);
        return Pages.LIST_DONATIONS;
    }
    
    public void doDeleteCampaign(Campaign campaign) {
        this.campaignToDelete = campaign;
        System.out.println("Aktion zum löschen vorgemerkt");
    }
    
    public void commitDeleteCampaign() {
    	campaignDeleteEvent.fire(campaignToDelete);
    }
}
