package data;

import model.Campaign;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
public class CampaignProducer implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -8062118192633373233L;

    private enum Mode {
        EDIT, ADD
    }
    
    private Campaign campaign;
    private Mode mode;
    
    @Named
    @Produces
    public Campaign getSelectedCampaign() {
        return campaign;
    }
    
    public void setSelectedCampaign(Campaign campaign) {
        this.campaign = campaign;
    }
    
    @Named
    @Produces
    public boolean isAddMode() {
        return mode == Mode.ADD;
    }
    
    public void prepareAddCampaign() {
        this.campaign = new Campaign();
        this.mode = Mode.ADD;
    }
    
    public void prepareEditCampaign(Campaign campaign) {
        this.campaign = campaign;
        this.mode = Mode.EDIT;
    }
}
