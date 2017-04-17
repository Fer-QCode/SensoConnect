/*    */ package com.senso_lab.rfid.ejb;
/*    */ 
/*    */ import com.senso_lab.rfid.dao.GenericDAO;
/*    */ import com.senso_lab.rfid.entity.PersonFb;
/*    */ import com.senso_lab.rfid.local.IPersonFb;
/*    */ import java.util.List;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.TypedQuery;
/*    */ 
/*    */ 
/*    */ @Stateless
/*    */ public class PersonFbBean
/*    */   extends GenericDAO<PersonFb>
/*    */   implements IPersonFb
/*    */ {
/* 19 */   private static final Logger log = Logger.getLogger(PersonFbBean.class.getName());
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private EntityManager entityManager;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public PersonFbBean()
/*    */   {
/* 35 */     super(PersonFb.class);
/* 36 */     this.entityManager = getEntityManager();
/*    */   }
/*    */   
/*    */   public boolean findByIdUser(String userid, int eventid)
/*    */   {
/* 41 */     boolean resp = false;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 47 */     List<PersonFb> person = this.entityManager.createQuery("SELECT p FROM PersonFb p WHERE p.fbuserID=:userid AND p.idEvent=:eventid", PersonFb.class).setParameter("userid", userid).setParameter("eventid", Integer.valueOf(eventid)).getResultList();
/*    */     
/* 49 */     if (person.size() > 0) {
/* 50 */       for (PersonFb p : person) {
/* 51 */         String msg = "id: " + p.getFbuserID() + ", user: " + p.getFbName() + ", event: " + p.getIdEvent();
/* 52 */         log.log(Level.INFO, msg);
/*    */       }
/*    */       
/* 55 */       resp = true;
/*    */     }
/*    */     
/*    */ 
/* 59 */     return resp;
/*    */   }
/*    */   
/*    */   public PersonFb getPersonByTag(String tag_rfid)
/*    */   {
/* 64 */     PersonFb person = null;
/*    */     
/*    */ 
/*    */     try
/*    */     {
/* 69 */       person = (PersonFb)this.em.createQuery("SELECT p FROM PersonFb p WHERE p.idTag=:tag_rfid", PersonFb.class).setParameter("tag_rfid", tag_rfid).getSingleResult();
/*    */     } catch (Exception e) {
/* 71 */       e.printStackTrace();
/* 72 */       String msg = "Error getPersonByTag " + e.getMessage() + "\n" + e.getLocalizedMessage();
/* 73 */       log.log(Level.INFO, msg);
/*    */     }
/*    */     
/*    */ 
/* 77 */     return person;
/*    */   }
/*    */ }


/* Location:              /Users/FerCho/Github/SensoConnect/RFIDSenso-ejb/dist/RFIDSenso-ejb.jar!/com/senso_lab/rfid/ejb/PersonFbBean.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */