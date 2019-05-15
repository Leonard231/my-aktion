package controller;

import model.Campaign;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import data.CampaignProducer;

import java.io.Serializable;


@SessionScoped
@Named
public class ListCampaignsController implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1461895254521475653L;

    @Inject
    private CampaignProducer campaignProducer;
    
    public String doAddCampaign() {
        campaignProducer.prepareAddCampaign();
        return Pages.EDIT_CAMPAIGN;
    }
    
    public String doEditCampaign(Campaign campaign) {
        campaignProducer.prepareEditCampaign(campaign);
        return Pages.EDIT_CAMPAIGN;
    }
    
    public String doEditDonationForm(Campaign campaign) {
        System.out.println("Edit Donation Form of Campaign" + campaign);
        return Pages.EDIT_DONATION_FORM;
    }
    
    public String doListDonations(Campaign campaign) {
        System.out.println("List Donations of Campaign" + campaign);
        return Pages.LIST_CAMPAIGNS;
    }
    
    public void doDeleteCampaign(Campaign campaign) {
        System.out.println("Deletion not implemented, yet!");
    }
}
