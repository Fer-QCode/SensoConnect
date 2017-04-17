/*    */ package com.senso_lab.rfid.ejb;
/*    */ 
/*    */ import com.senso_lab.rfid.dao.GenericDAO;
/*    */ import com.senso_lab.rfid.entity.EventDetail;
/*    */ import com.senso_lab.rfid.local.IEventDetail;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.TypedQuery;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Stateless
/*    */ public class EventDetailBean
/*    */   extends GenericDAO<EventDetail>
/*    */   implements IEventDetail
/*    */ {
/* 19 */   private static final Logger log = Logger.getLogger(EventDetailBean.class.getName());
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
/*    */   public EventDetailBean()
/*    */   {
/* 35 */     super(EventDetail.class);
/* 36 */     log.log(Level.INFO, "EventDetailBean ");
/* 37 */     this.entityManager = getEntityManager();
/*    */   }
/*    */   
/*    */   public EventDetail findActiveEvent(int eventId, int status)
/*    */   {
/*    */     try
/*    */     {
/* 44 */       if (this.entityManager != null) {
/* 45 */         log.log(Level.INFO, "findActiveEvent try ");
/*    */         
/*    */ 
/*    */ 
/*    */ 
/* 50 */         return (EventDetail)this.entityManager.createQuery("SELECT e FROM EventDetail e WHERE e.idEvent=:eventId AND e.status=:status", EventDetail.class).setParameter("eventId", Integer.valueOf(eventId)).setParameter("status", Integer.valueOf(status)).getSingleResult();
/*    */       }
/* 52 */       log.log(Level.SEVERE, "em is null... ");
/* 53 */       return null;
/*    */     }
/*    */     catch (Exception e) {
/* 56 */       e.printStackTrace();
/* 57 */       String msg = "Error findActiveEvent " + e.getMessage() + "\n" + e.getLocalizedMessage();
/* 58 */       log.log(Level.SEVERE, msg); }
/* 59 */     return null;
/*    */   }
/*    */ }


/* Location:              /Users/FerCho/Github/SensoConnect/RFIDSenso-ejb/dist/RFIDSenso-ejb.jar!/com/senso_lab/rfid/ejb/EventDetailBean.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */