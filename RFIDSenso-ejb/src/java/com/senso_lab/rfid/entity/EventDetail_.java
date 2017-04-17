package com.senso_lab.rfid.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(EventDetail.class)
public class EventDetail_
{
  public static volatile SingularAttribute<EventDetail, String> objectUrl;
  public static volatile SingularAttribute<EventDetail, Integer> idEvent;
  public static volatile SingularAttribute<EventDetail, String> privacy;
  public static volatile SingularAttribute<EventDetail, Integer> id;
  public static volatile SingularAttribute<EventDetail, String> scopes;
  public static volatile SingularAttribute<EventDetail, String> fbAppId;
  public static volatile SingularAttribute<EventDetail, String> fbAppSecret;
  public static volatile SingularAttribute<EventDetail, Integer> status;
}


/* Location:              /Users/FerCho/Github/SensoConnect/RFIDSenso-ejb/dist/RFIDSenso-ejb.jar!/com/senso_lab/rfid/entity/EventDetail_.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */