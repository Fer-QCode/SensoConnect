package com.senso_lab.rfid.web;

import com.senso_lab.rfid.entity.EventDetail;
import com.senso_lab.rfid.entity.PersonFb;
import com.senso_lab.rfid.local.IEventDetail;
import com.senso_lab.rfid.local.IPersonFb;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CaptureEvent;

/**
 * @author qcode
 */
@ManagedBean(name="postToFacebook")
@SessionScoped
public class PostToFacebook implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EJB
    private IPersonFb personBean;
    @EJB
    private IEventDetail eventDetailBean;

    private String tagId = "";
    //App Detail
    private String app_id;
    private String app_secret;
    private String app_objUrl;
    private String app_privacy;
    private String app_scopes;

    //User Detail
    private PersonFb person;

    public PostToFacebook() {
    }

    @PostConstruct
    public void loadData() {
        
        EventDetail eventDetail = eventDetailBean.findActiveEvent(1, 0);
        this.app_id = eventDetail.getFbAppId();
        this.app_secret = eventDetail.getFbAppSecret();
        this.app_objUrl = eventDetail.getObjectUrl();
        this.app_privacy = eventDetail.getPrivacy();
        this.app_scopes = eventDetail.getScopes();
        
        person  = new PersonFb();
    }
    
    public void getPersonDetail() {

        Map<String, String> requestParamMap
                = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        if (requestParamMap.containsKey("tagId")) {
            String _tagId = requestParamMap.get("tagId");
            if(_tagId!= null && !_tagId.equals("")){
                this.person = personBean.getPersonByTag(_tagId);
            }
        }

    }
    
    public void savePhoto(CaptureEvent captureEvent){        
        
        byte[] data = captureEvent.getData();
        
        System.out.println("data");
        System.out.println(data);
        
        
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getApp_secret() {
        return app_secret;
    }

    public void setApp_secret(String app_secret) {
        this.app_secret = app_secret;
    }

    public String getApp_objUrl() {
        return app_objUrl;
    }

    public void setApp_objUrl(String app_objUrl) {
        this.app_objUrl = app_objUrl;
    }

    public String getApp_privacy() {
        return app_privacy;
    }

    public void setApp_privacy(String app_privacy) {
        this.app_privacy = app_privacy;
    }

    public String getApp_scopes() {
        return app_scopes;
    }

    public void setApp_scopes(String app_scopes) {
        this.app_scopes = app_scopes;
    }

    public PersonFb getPerson() {
        return person;
    }

    public void setPerson(PersonFb person) {
        this.person = person;
    }

}
