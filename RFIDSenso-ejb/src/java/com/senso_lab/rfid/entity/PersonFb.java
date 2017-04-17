/*     */ package com.senso_lab.rfid.entity;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.NamedQueries;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="person_fb")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@javax.persistence.NamedQuery(name="PersonFb.findAll", query="SELECT p FROM PersonFb p"), @javax.persistence.NamedQuery(name="PersonFb.findByIdTag", query="SELECT p FROM PersonFb p WHERE p.idTag = :idTag"), @javax.persistence.NamedQuery(name="PersonFb.findByFbuserID", query="SELECT p FROM PersonFb p WHERE p.fbuserID = :fbuserID"), @javax.persistence.NamedQuery(name="PersonFb.findByFbFisrtName", query="SELECT p FROM PersonFb p WHERE p.fbFisrtName = :fbFisrtName"), @javax.persistence.NamedQuery(name="PersonFb.findByFbLastName", query="SELECT p FROM PersonFb p WHERE p.fbLastName = :fbLastName"), @javax.persistence.NamedQuery(name="PersonFb.findByGender", query="SELECT p FROM PersonFb p WHERE p.gender = :gender"), @javax.persistence.NamedQuery(name="PersonFb.findByFbName", query="SELECT p FROM PersonFb p WHERE p.fbName = :fbName"), @javax.persistence.NamedQuery(name="PersonFb.findByFbAccessTokenShort", query="SELECT p FROM PersonFb p WHERE p.fbAccessTokenShort = :fbAccessTokenShort"), @javax.persistence.NamedQuery(name="PersonFb.findByFbAccessTokenLong", query="SELECT p FROM PersonFb p WHERE p.fbAccessTokenLong = :fbAccessTokenLong"), @javax.persistence.NamedQuery(name="PersonFb.findByRegisterTime", query="SELECT p FROM PersonFb p WHERE p.registerTime = :registerTime"), @javax.persistence.NamedQuery(name="PersonFb.findByIdEvent", query="SELECT p FROM PersonFb p WHERE p.idEvent = :idEvent")})
/*     */ public class PersonFb
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional=false)
/*     */   @NotNull
/*     */   @Size(min=1, max=10)
/*     */   @Column(name="id_tag")
/*     */   private String idTag;
/*     */   @Size(max=20)
/*     */   @Column(name="fb_userID")
/*     */   private String fbuserID;
/*     */   @Size(max=50)
/*     */   @Column(name="fb_fisrt_name")
/*     */   private String fbFisrtName;
/*     */   @Size(max=50)
/*     */   @Column(name="fb_last_name")
/*     */   private String fbLastName;
/*     */   @Size(max=10)
/*     */   @Column(name="gender")
/*     */   private String gender;
/*     */   @Size(max=100)
/*     */   @Column(name="fb_name")
/*     */   private String fbName;
/*     */   @Size(max=255)
/*     */   @Column(name="fb_access_token_short")
/*     */   private String fbAccessTokenShort;
/*     */   @Size(max=255)
/*     */   @Column(name="fb_access_token_long")
/*     */   private String fbAccessTokenLong;
/*     */   @Column(name="register_time")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date registerTime;
/*     */   @Column(name="id_event")
/*     */   private Integer idEvent;
/*     */   
/*     */   public PersonFb() {}
/*     */   
/*     */   public PersonFb(String idTag, String fbuserID, String fbFisrtName, String fbLastName, String gender, String fbName, String fbAccessTokenShort, String fbAccessTokenLong, Date registerTime, Integer idEvent)
/*     */   {
/*  82 */     this.idTag = idTag;
/*  83 */     this.fbuserID = fbuserID;
/*  84 */     this.fbFisrtName = fbFisrtName;
/*  85 */     this.fbLastName = fbLastName;
/*  86 */     this.gender = gender;
/*  87 */     this.fbName = fbName;
/*  88 */     this.fbAccessTokenShort = fbAccessTokenShort;
/*  89 */     this.fbAccessTokenLong = fbAccessTokenLong;
/*  90 */     this.registerTime = registerTime;
/*  91 */     this.idEvent = idEvent;
/*     */   }
/*     */   
/*     */   public PersonFb(String idTag) {
/*  95 */     this.idTag = idTag;
/*     */   }
/*     */   
/*     */   public String getIdTag() {
/*  99 */     return this.idTag;
/*     */   }
/*     */   
/*     */   public void setIdTag(String idTag) {
/* 103 */     this.idTag = idTag;
/*     */   }
/*     */   
/*     */   public String getFbuserID() {
/* 107 */     return this.fbuserID;
/*     */   }
/*     */   
/*     */   public void setFbuserID(String fbuserID) {
/* 111 */     this.fbuserID = fbuserID;
/*     */   }
/*     */   
/*     */   public String getFbFisrtName() {
/* 115 */     return this.fbFisrtName;
/*     */   }
/*     */   
/*     */   public void setFbFisrtName(String fbFisrtName) {
/* 119 */     this.fbFisrtName = fbFisrtName;
/*     */   }
/*     */   
/*     */   public String getFbLastName() {
/* 123 */     return this.fbLastName;
/*     */   }
/*     */   
/*     */   public void setFbLastName(String fbLastName) {
/* 127 */     this.fbLastName = fbLastName;
/*     */   }
/*     */   
/*     */   public String getGender() {
/* 131 */     return this.gender;
/*     */   }
/*     */   
/*     */   public void setGender(String gender) {
/* 135 */     this.gender = gender;
/*     */   }
/*     */   
/*     */   public String getFbName() {
/* 139 */     return this.fbName;
/*     */   }
/*     */   
/*     */   public void setFbName(String fbName) {
/* 143 */     this.fbName = fbName;
/*     */   }
/*     */   
/*     */   public String getFbAccessTokenShort() {
/* 147 */     return this.fbAccessTokenShort;
/*     */   }
/*     */   
/*     */   public void setFbAccessTokenShort(String fbAccessTokenShort) {
/* 151 */     this.fbAccessTokenShort = fbAccessTokenShort;
/*     */   }
/*     */   
/*     */   public String getFbAccessTokenLong() {
/* 155 */     return this.fbAccessTokenLong;
/*     */   }
/*     */   
/*     */   public void setFbAccessTokenLong(String fbAccessTokenLong) {
/* 159 */     this.fbAccessTokenLong = fbAccessTokenLong;
/*     */   }
/*     */   
/*     */   public Date getRegisterTime() {
/* 163 */     return this.registerTime;
/*     */   }
/*     */   
/*     */   public void setRegisterTime(Date registerTime) {
/* 167 */     this.registerTime = registerTime;
/*     */   }
/*     */   
/*     */   public Integer getIdEvent() {
/* 171 */     return this.idEvent;
/*     */   }
/*     */   
/*     */   public void setIdEvent(Integer idEvent) {
/* 175 */     this.idEvent = idEvent;
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 180 */     int hash = 0;
/* 181 */     hash += (this.idTag != null ? this.idTag.hashCode() : 0);
/* 182 */     return hash;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean equals(Object object)
/*     */   {
/* 188 */     if (!(object instanceof PersonFb)) {
/* 189 */       return false;
/*     */     }
/* 191 */     PersonFb other = (PersonFb)object;
/* 192 */     if (((this.idTag == null) && (other.idTag != null)) || ((this.idTag != null) && (!this.idTag.equals(other.idTag)))) {
/* 193 */       return false;
/*     */     }
/* 195 */     return true;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 200 */     return "com.senso_lab.rfid.entity.PersonFb[ idTag=" + this.idTag + " ]";
/*     */   }
/*     */ }


/* Location:              /Users/FerCho/Github/SensoConnect/RFIDSenso-ejb/dist/RFIDSenso-ejb.jar!/com/senso_lab/rfid/entity/PersonFb.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */