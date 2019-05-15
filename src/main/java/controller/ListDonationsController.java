package controller;

import model.Donation.Status;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class ListDonationsController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3311426652088829383L;
	
	public String doOk() {
		return Pages.LIST_CAMPAIGNS;
	}
}
