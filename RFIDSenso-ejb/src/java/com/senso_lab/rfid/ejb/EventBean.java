/*    */ package com.senso_lab.rfid.ejb;
/*    */ 
/*    */ import com.senso_lab.rfid.dao.GenericDAO;
/*    */ import com.senso_lab.rfid.entity.Event;
/*    */ import com.senso_lab.rfid.local.IEvent;
/*    */ import java.util.logging.Logger;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Stateless
/*    */ public class EventBean
/*    */   extends GenericDAO<Event>
/*    */   implements IEvent
/*    */ {
/* 17 */   private static final Logger log = Logger.getLogger(EventDetailBean.class.getName());
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
/*    */   public EventBean()
/*    */   {
/* 33 */     super(Event.class);
/* 34 */     this.entityManager = getEntityManager();
/*    */   }
/*    */ }


/* Location:              /Users/FerCho/Github/SensoConnect/RFIDSenso-ejb/dist/RFIDSenso-ejb.jar!/com/senso_lab/rfid/ejb/EventBean.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */