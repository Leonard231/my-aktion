package controller;

import data.CampaignListProducer;
import data.CampaignProducer;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class EditCampaignController implements Serializable {

	private static final long serialVersionUID = 3057178380756147587L;

	@Inject
	private CampaignListProducer campaignListProducer;
	@Inject
	private CampaignProducer campaignProducer;
	
	
	public String doSave() {
		if(campaignProducer.isAddMode()) {
			campaignListProducer.getCampaigns().add(campaignProducer.getSelectedCampaign());
		}
		return Pages.LIST_CAMPAIGNS;
	}
	
	public String doCancel() {
		return Pages.LIST_CAMPAIGNS;
	}
	
}
