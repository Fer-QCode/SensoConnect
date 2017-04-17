/*     */ package com.senso_lab.rfid.entity;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import javax.validation.constraints.Size;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="event_detail")
/*     */ public class EventDetail
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
/*     */   @Column(name="id_event")
/*     */   private int idEvent;
/*     */   @Basic(optional=false)
/*     */   @NotNull
/*     */   @Size(min=1, max=20)
/*     */   @Column(name="fb_app_id")
/*     */   private String fbAppId;
/*     */   @Basic(optional=false)
/*     */   @NotNull
/*     */   @Size(min=1, max=40)
/*     */   @Column(name="fb_app_secret")
/*     */   private String fbAppSecret;
/*     */   @Basic(optional=false)
/*     */   @NotNull
/*     */   @Size(min=1, max=200)
/*     */   @Column(name="object_url")
/*     */   private String objectUrl;
/*     */   @Basic(optional=false)
/*     */   @NotNull
/*     */   @Size(min=1, max=200)
/*     */   @Column(name="scopes")
/*     */   private String scopes;
/*     */   @Basic(optional=false)
/*     */   @NotNull
/*     */   @Size(min=1, max=20)
/*     */   @Column(name="privacy")
/*     */   private String privacy;
/*     */   @Basic(optional=false)
/*     */   @NotNull
/*     */   @Column(name="status")
/*     */   private int status;
/*     */   
/*     */   public EventDetail() {}
/*     */   
/*     */   public EventDetail(Integer id)
/*     */   {
/*  68 */     this.id = id;
/*     */   }
/*     */   
/*     */   public EventDetail(Integer id, int idEvent, String fbAppId, String fbAppSecret, String objectUrl, String scopes, String privacy, int status) {
/*  72 */     this.id = id;
/*  73 */     this.idEvent = idEvent;
/*  74 */     this.fbAppId = fbAppId;
/*  75 */     this.fbAppSecret = fbAppSecret;
/*  76 */     this.objectUrl = objectUrl;
/*  77 */     this.scopes = scopes;
/*  78 */     this.privacy = privacy;
/*  79 */     this.status = status;
/*     */   }
/*     */   
/*     */   public Integer getId() {
/*  83 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/*  87 */     this.id = id;
/*     */   }
/*     */   
/*     */   public int getIdEvent() {
/*  91 */     return this.idEvent;
/*     */   }
/*     */   
/*     */   public void setIdEvent(int idEvent) {
/*  95 */     this.idEvent = idEvent;
/*     */   }
/*     */   
/*     */   public String getFbAppId() {
/*  99 */     return this.fbAppId;
/*     */   }
/*     */   
/*     */   public void setFbAppId(String fbAppId) {
/* 103 */     this.fbAppId = fbAppId;
/*     */   }
/*     */   
/*     */   public String getFbAppSecret() {
/* 107 */     return this.fbAppSecret;
/*     */   }
/*     */   
/*     */   public void setFbAppSecret(String fbAppSecret) {
/* 111 */     this.fbAppSecret = fbAppSecret;
/*     */   }
/*     */   
/*     */   public String getObjectUrl() {
/* 115 */     return this.objectUrl;
/*     */   }
/*     */   
/*     */   public void setObjectUrl(String objectUrl) {
/* 119 */     this.objectUrl = objectUrl;
/*     */   }
/*     */   
/*     */   public String getScopes() {
/* 123 */     return this.scopes;
/*     */   }
/*     */   
/*     */   public void setScopes(String scopes) {
/* 127 */     this.scopes = scopes;
/*     */   }
/*     */   
/*     */   public String getPrivacy() {
/* 131 */     return this.privacy;
/*     */   }
/*     */   
/*     */   public void setPrivacy(String privacy) {
/* 135 */     this.privacy = privacy;
/*     */   }
/*     */   
/*     */   public int getStatus() {
/* 139 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(int status) {
/* 143 */     this.status = status;
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 148 */     int hash = 0;
/* 149 */     hash += (this.id != null ? this.id.hashCode() : 0);
/* 150 */     return hash;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean equals(Object object)
/*     */   {
/* 156 */     if (!(object instanceof EventDetail)) {
/* 157 */       return false;
/*     */     }
/* 159 */     EventDetail other = (EventDetail)object;
/* 160 */     if (((this.id == null) && (other.id != null)) || ((this.id != null) && (!this.id.equals(other.id)))) {
/* 161 */       return false;
/*     */     }
/* 163 */     return true;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 168 */     return "com.senso_lab.rfid.entity.EventDetail[ id=" + this.id + " ]";
/*     */   }
/*     */ }


/* Location:              /Users/FerCho/Github/SensoConnect/RFIDSenso-ejb/dist/RFIDSenso-ejb.jar!/com/senso_lab/rfid/entity/EventDetail.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */