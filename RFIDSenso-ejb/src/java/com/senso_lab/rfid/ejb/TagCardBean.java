/*    */ package com.senso_lab.rfid.ejb;
/*    */ 
/*    */ import com.senso_lab.rfid.dao.GenericDAO;
/*    */ import com.senso_lab.rfid.entity.TagCard;
/*    */ import com.senso_lab.rfid.local.ITagCard;
/*    */ import java.util.List;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.TypedQuery;
/*    */ 
/*    */ 
/*    */ @Stateless
/*    */ public class TagCardBean
/*    */   extends GenericDAO<TagCard>
/*    */   implements ITagCard
/*    */ {
/* 19 */   private static final Logger log = Logger.getLogger(TagCardBean.class.getName());
/*    */   
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
/*    */ 
/*    */   public TagCardBean()
/*    */   {
/* 37 */     super(TagCard.class);
/* 38 */     this.entityManager = getEntityManager();
/*    */   }
/*    */   
/*    */   public boolean findTagByRfid(String rfid)
/*    */   {
/* 43 */     boolean resp = false;
/* 44 */     String msg = "rfid " + rfid;
/* 45 */     log.log(Level.SEVERE, msg);
/*    */     
/*    */ 
/*    */ 
/* 49 */     List<TagCard> tag = this.entityManager.createQuery("SELECT t FROM TagCard t WHERE t.rfidTag = :rfidTag", TagCard.class).setParameter("rfidTag", rfid).getResultList();
/*    */     
/* 51 */     if (tag.size() > 0) {
/* 52 */       for (TagCard t : tag) {
/* 53 */         msg = "id: " + t.getId() + ", tag: " + t.getRfidTag() + ", status: " + t.getStatus();
/* 54 */         log.log(Level.SEVERE, msg);
/*    */       }
/* 56 */       resp = true;
/*    */     }
/*    */     
/*    */ 
/* 60 */     log.log(Level.SEVERE, "resp: " + resp);
/* 61 */     return resp;
/*    */   }
/*    */ }


/* Location:              /Users/FerCho/Github/SensoConnect/RFIDSenso-ejb/dist/RFIDSenso-ejb.jar!/com/senso_lab/rfid/ejb/TagCardBean.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */