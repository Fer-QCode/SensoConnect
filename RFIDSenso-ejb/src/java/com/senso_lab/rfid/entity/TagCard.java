/*     */ package com.senso_lab.rfid.entity;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.NamedQueries;
/*     */ import javax.persistence.Table;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import javax.validation.constraints.Size;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="tag_card")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@javax.persistence.NamedQuery(name="TagCard.findAll", query="SELECT t FROM TagCard t"), @javax.persistence.NamedQuery(name="TagCard.findById", query="SELECT t FROM TagCard t WHERE t.id = :id"), @javax.persistence.NamedQuery(name="TagCard.findByRfidTag", query="SELECT t FROM TagCard t WHERE t.rfidTag = :rfidTag"), @javax.persistence.NamedQuery(name="TagCard.findByStatus", query="SELECT t FROM TagCard t WHERE t.status = :status")})
/*     */ public class TagCard
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Basic(optional=false)
/*     */   @Column(name="id")
/*     */   private Integer id;
/*     */   @Basic(optional=false)
/*     */   @NotNull
/*     */   @Size(min=1, max=10)
/*     */   @Column(name="rfid_tag")
/*     */   private String rfidTag;
/*     */   @Basic(optional=false)
/*     */   @NotNull
/*     */   @Column(name="status")
/*     */   private int status;
/*     */   
/*     */   public TagCard() {}
/*     */   
/*     */   public TagCard(Integer id)
/*     */   {
/*  56 */     this.id = id;
/*     */   }
/*     */   
/*     */   public TagCard(String rfidTag, int status) {
/*  60 */     this.rfidTag = rfidTag;
/*  61 */     this.status = status;
/*     */   }
/*     */   
/*     */   public TagCard(Integer id, String rfidTag, int status) {
/*  65 */     this.id = id;
/*  66 */     this.rfidTag = rfidTag;
/*  67 */     this.status = status;
/*     */   }
/*     */   
/*     */   public Integer getId() {
/*  71 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/*  75 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getRfidTag() {
/*  79 */     return this.rfidTag;
/*     */   }
/*     */   
/*     */   public void setRfidTag(String rfidTag) {
/*  83 */     this.rfidTag = rfidTag;
/*     */   }
/*     */   
/*     */   public int getStatus() {
/*  87 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(int status) {
/*  91 */     this.status = status;
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/*  96 */     int hash = 0;
/*  97 */     hash += (this.id != null ? this.id.hashCode() : 0);
/*  98 */     return hash;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean equals(Object object)
/*     */   {
/* 104 */     if (!(object instanceof TagCard)) {
/* 105 */       return false;
/*     */     }
/* 107 */     TagCard other = (TagCard)object;
/* 108 */     if (((this.id == null) && (other.id != null)) || ((this.id != null) && (!this.id.equals(other.id)))) {
/* 109 */       return false;
/*     */     }
/* 111 */     return true;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 116 */     return "com.senso_lab.rfid.entity.TagCard[ id=" + this.id + " ]";
/*     */   }
/*     */ }


/* Location:              /Users/FerCho/Github/SensoConnect/RFIDSenso-ejb/dist/RFIDSenso-ejb.jar!/com/senso_lab/rfid/entity/TagCard.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */