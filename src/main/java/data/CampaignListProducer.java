package data;

import model.Campaign;
import services.CampaignService;
import util.Events.Added;
import util.Events.Deleted;
import util.Events.Updated;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@RequestScoped
public class CampaignListProducer {

    private List<Campaign> campaigns;
    
    @Inject
    private CampaignService campaignService;
    
    @PostConstruct
    public void init() {
        campaigns = campaignService.getAllCampaigns();
    }
    
    @Produces
    @Named
    public List<Campaign> getCampaigns() {
        return this.campaigns;
    }
    
    public void onCampaignAdded(@Observes @Added Campaign campaign) {
    	campaignService.addCampaign(campaign);
    	init();
    }
    
    public void onCampaignUpdated(@Observes @Updated Campaign campaign) {
    	campaignService.updateCampaign(campaign);
    	init();
    }
    
    public void onCampaignDeleted(@Observes @Deleted Campaign campaign) {
    	campaignService.deleteCampaign(campaign);
    	init();
    }
    
}
