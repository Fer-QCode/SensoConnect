package com.senso_lab.rfid.web;

import com.senso_lab.rfid.ejb.EventDetailBean;
import com.senso_lab.rfid.entity.EventDetail;
import com.senso_lab.rfid.entity.PersonFb;
import com.senso_lab.rfid.entity.TagCard;
import com.senso_lab.rfid.local.IEventDetail;
import com.senso_lab.rfid.local.IPersonFb;
import com.senso_lab.rfid.local.ITagCard;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 * @author qcode
 * 
 */
@ManagedBean(name="rFIDEventDetail")
@SessionScoped
public class RFIDEventDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private static final Logger log = Logger.getLogger( RFIDEventDetail.class.getName() );
    
    @EJB 
    private ITagCard tagCardBean;
    @EJB
    private IEventDetail eventDetailBean;
    @EJB 
    private IPersonFb personFbBean;
    
    
    private List<EventDetail> eventDetails;
    private EventDetail event;
    private String app_id;
    private String app_secret;
    private String app_objUrl;
    private String app_privacy;
    private String app_scopes;
    
    //Registro de usuario
    private String rfid_tag;
    private String user_id;
    private String user_firstName;
    private String user_lastName;
    private String user_gender;
    private String user_name;
    private String user_token_short;
    private String user_token_long;
    //private String register_time;
    //private String id_event;
    
    public RFIDEventDetail() { }
    
    @PostConstruct
    public void init(){
        log.log(Level.INFO, "init()");
        
        try {
            
            eventDetailBean = new EventDetailBean();
            event = eventDetailBean.findActiveEvent(1, 0);
            app_id = event.getFbAppId();
            app_secret = event.getFbAppSecret();
            app_objUrl = event.getObjectUrl();
            app_privacy = event.getPrivacy();
            app_scopes = event.getScopes();
            
        } catch (Exception e) {
            String msg = "Exception init: " + e.getMessage();
            log.log(Level.SEVERE, msg);
            e.printStackTrace();
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/error.xhtml");
        }
        
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

    /* Registro Tag */
    public void registroTag(){
        System.out.println("registroTag");
        if(rfid_tag != null)
            if( !tagCardBean.findTagByRfid(rfid_tag) ){
                try {

                    //Registro de TAG si no existe
                    TagCard tagCard = new TagCard(
                        rfid_tag,
                        ITagCard.TAG_CARD_AVAILABLE
                    );
                    tagCardBean.create(tagCard);

                    System.out.println("Registro exitoso de tag: " + rfid_tag);

                } catch (Exception e) {
                    System.out.println("ERROR: " + e.getMessage());
                }

            } else {
                System.out.println("La tarjeta ya ha sido registrada... ");
            }
    }
    
    /* Registro de Usuario */    
    public void registroUsuario(){
        System.out.println("registroUsuario");
        
        if(rfid_tag != null){
            if( !personFbBean.findByIdUser(user_id, 1) ){
            
                try {
                    //Registro de USUARIO_FB
                    PersonFb person = new PersonFb(
                            rfid_tag,
                            user_id,
                            user_firstName,
                            user_lastName,
                            user_gender,
                            user_name,
                            user_token_short,
                            user_token_long,
                            new java.sql.Date( new Date().getTime() ),
                            1 //idEvent
                    );
                    
                    personFbBean.create(person);
                    
                    System.out.println("Registro exitoso de usuario: " + user_id);
                    
                    RequestContext.getCurrentInstance().execute("registroExitoso();");
                    
                } catch (Exception e) {
                    System.out.println("ERROR: " + e.getMessage());
                    RequestContext.getCurrentInstance().execute("registroFallido();");
                }
            }
        }
        
    }
    
    public String getRfid_tag() {
        //System.out.println("get rfid_tag: " + rfid_tag);
        return rfid_tag;
    }

    public void setRfid_tag(String rfid_tag) {
        this.rfid_tag = rfid_tag;
        //System.out.println("set rfid_tag: " + this.rfid_tag);
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
        //System.out.println("set user_id: " + this.user_id);
    }

    public String getUser_firstName() {
        //System.out.println("get user_id: " + this.user_firstName);
        return user_firstName;
    }

    public void setUser_firstName(String user_firstName) {
        this.user_firstName = user_firstName;
        //System.out.println("set user_firstName: " + this.user_firstName);
    }

    public String getUser_lastName() {
        //System.out.println("get getUser_lastName: " + this.user_lastName);
        return user_lastName;
    }

    public void setUser_lastName(String user_lastName) {
        this.user_lastName = user_lastName;
        //System.out.println("set user_lastName: " + this.user_lastName);
    }

    public String getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(String user_gender) {
        this.user_gender = user_gender;
        //System.out.println("get user_gender: " + this.user_gender);
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
        //System.out.println("get user_name: " + this.user_name);
    }

    public String getUser_token_short() {
        return user_token_short;
    }

    public void setUser_token_short(String user_token_short) {
        this.user_token_short = user_token_short;
        //System.out.println("get user_token_short: " + this.user_token_short);
    }

    public String getUser_token_long() {
        return user_token_long;
    }

    public void setUser_token_long(String user_token_long) {
        this.user_token_long = user_token_long;
    }
    
}
