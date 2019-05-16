package controller;

import data.CampaignListProducer;
import model.Campaign;
import util.Events.Added;
import data.CampaignProducer;

import javax.enterprise.event.Event;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named
public class EditCampaignController implements Serializable {

	private static final long serialVersionUID = 3057178380756147587L;

	@Inject
	private CampaignProducer campaignProducer;
	
	@Inject
	@Added
	private Event<Campaign> campaignAddEvent;
	
	
	public String doSave() {
		if(campaignProducer.isAddMode()) {
			campaignAddEvent.fire(campaignProducer.getSelectedCampaign());
		}
		return Pages.LIST_CAMPAIGNS;
	}
	
	public String doCancel() {
		return Pages.LIST_CAMPAIGNS;
	}
	
}
