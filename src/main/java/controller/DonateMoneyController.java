package controller;

import java.io.Serializable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Donation;
import model.Donation.Status;
import services.DonationService;

@ViewScoped
@Named
public class DonateMoneyController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6597051581466639894L;

	private String textColor = "000000";
	private String bgColor = "ffffff";
	private Long campaignId;
	private Donation donation;
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private Logger logger;
	
	@Inject
	private DonationService donationService;
	
	@PostConstruct
	public void init() {
		this.donation = new Donation();
	}
	
	public String doDonation() {
		getDonation().setStatus(Status.IN_PROCESS);
		donationService.addDonation(getCampaignId(), getDonation());
		logger.log(Level.INFO, "log.donateMoney.thank_you", new Object[] {getDonation().getDonorName(), getDonation().getAmount()});
		final ResourceBundle resourceBundle = facesContext.getApplication().getResourceBundle(facesContext, "msg");
		final String msg = resourceBundle.getString("donateMoney.thank_you");
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
		init();	
		return Pages.DONATE_MONEY;
	}
	

	public String getTextColor() {
		return textColor;
	}
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}
	public String getBgColor() {
		return bgColor;
	}
	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}
	public Long getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(Long campaignId) {
		this.campaignId = campaignId;
	}
	public Donation getDonation() {
		return donation;
	}
	public void setDonation(Donation donation) {
		this.donation = donation;
	}
}
