/*    */ package com.senso_lab.rfid.dao;
/*    */ 
/*    */ import java.util.List;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.EntityManagerFactory;
/*    */ import javax.persistence.Persistence;
/*    */ import javax.persistence.PersistenceContext;
/*    */ import javax.persistence.TypedQuery;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GenericDAO<E>
/*    */   implements IGenericDAO<E>
/*    */ {
/*    */   private Class<E> entityClass;
/*    */   @PersistenceContext(unitName="RFIDSenso-ejbPU")
/*    */   protected EntityManager em;
/*    */   private EntityManagerFactory emf;
/*    */   
/*    */   public EntityManager getEntityManager()
/*    */   {
/* 28 */     if (this.em == null) {
/* 29 */       this.emf = Persistence.createEntityManagerFactory("RFIDSenso-ejbPU");
/* 30 */       return this.emf.createEntityManager();
/*    */     }
/* 32 */     return this.em;
/*    */   }
/*    */   
/*    */   public GenericDAO(Class<E> entityClass)
/*    */   {
/* 37 */     this.entityClass = entityClass;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void create(E e)
/*    */   {
/* 47 */     if (e != null) {
/* 48 */       this.em.persist(e);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<E> readAll()
/*    */   {
/* 57 */     return this.em.createQuery("SELECT p FROM" + this.entityClass.getName() + " p", this.entityClass).getResultList();
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update(E e)
/*    */   {
/* 63 */     if (e != null) {
/* 64 */       this.em.merge(e);
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public void delete(E e)
/*    */   {
/* 72 */     this.em.remove(e);
/*    */   }
/*    */ }


/* Location:              /Users/FerCho/Github/SensoConnect/RFIDSenso-ejb/dist/RFIDSenso-ejb.jar!/com/senso_lab/rfid/dao/GenericDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */