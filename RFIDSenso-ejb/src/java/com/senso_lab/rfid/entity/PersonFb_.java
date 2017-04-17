package com.senso_lab.rfid.entity;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(PersonFb.class)
public class PersonFb_
{
  public static volatile SingularAttribute<PersonFb, String> gender;
  public static volatile SingularAttribute<PersonFb, Date> registerTime;
  public static volatile SingularAttribute<PersonFb, String> fbuserID;
  public static volatile SingularAttribute<PersonFb, String> idTag;
  public static volatile SingularAttribute<PersonFb, String> fbAccessTokenShort;
  public static volatile SingularAttribute<PersonFb, Integer> idEvent;
  public static volatile SingularAttribute<PersonFb, String> fbFisrtName;
  public static volatile SingularAttribute<PersonFb, String> fbAccessTokenLong;
  public static volatile SingularAttribute<PersonFb, String> fbLastName;
  public static volatile SingularAttribute<PersonFb, String> fbName;
}


/* Location:              /Users/FerCho/Github/SensoConnect/RFIDSenso-ejb/dist/RFIDSenso-ejb.jar!/com/senso_lab/rfid/entity/PersonFb_.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */