/*    */ package com.senso_lab.rfid.entity;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Basic;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.NamedQueries;
/*    */ import javax.persistence.Table;
/*    */ import javax.validation.constraints.NotNull;
/*    */ import javax.validation.constraints.Size;
/*    */ import javax.xml.bind.annotation.XmlRootElement;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="event")
/*    */ @XmlRootElement
/*    */ @NamedQueries({@javax.persistence.NamedQuery(name="Event.findAll", query="SELECT e FROM Event e"), @javax.persistence.NamedQuery(name="Event.findById", query="SELECT e FROM Event e WHERE e.id = :id"), @javax.persistence.NamedQuery(name="Event.findByEventName", query="SELECT e FROM Event e WHERE e.eventName = :eventName")})
/*    */ public class Event
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   @Id
/*    */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*    */   @Basic(optional=false)
/*    */   @Column(name="id")
/*    */   private Integer id;
/*    */   @Basic(optional=false)
/*    */   @NotNull
/*    */   @Size(min=1, max=50)
/*    */   @Column(name="event_name")
/*    */   private String eventName;
/*    */   
/*    */   public Event() {}
/*    */   
/*    */   public Event(Integer id)
/*    */   {
/* 51 */     this.id = id;
/*    */   }
/*    */   
/*    */   public Event(Integer id, String eventName) {
/* 55 */     this.id = id;
/* 56 */     this.eventName = eventName;
/*    */   }
/*    */   
/*    */   public Integer getId() {
/* 60 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Integer id) {
/* 64 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getEventName() {
/* 68 */     return this.eventName;
/*    */   }
/*    */   
/*    */   public void setEventName(String eventName) {
/* 72 */     this.eventName = eventName;
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 77 */     int hash = 0;
/* 78 */     hash += (this.id != null ? this.id.hashCode() : 0);
/* 79 */     return hash;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean equals(Object object)
/*    */   {
/* 85 */     if (!(object instanceof Event)) {
/* 86 */       return false;
/*    */     }
/* 88 */     Event other = (Event)object;
/* 89 */     if (((this.id == null) && (other.id != null)) || ((this.id != null) && (!this.id.equals(other.id)))) {
/* 90 */       return false;
/*    */     }
/* 92 */     return true;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 97 */     return "com.senso_lab.rfid.entity.Event[ id=" + this.id + " ]";
/*    */   }
/*    */ }


/* Location:              /Users/FerCho/Github/SensoConnect/RFIDSenso-ejb/dist/RFIDSenso-ejb.jar!/com/senso_lab/rfid/entity/Event.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */