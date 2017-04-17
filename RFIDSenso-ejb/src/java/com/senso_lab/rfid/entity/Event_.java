package com.senso_lab.rfid.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Event.class)
public class Event_
{
  public static volatile SingularAttribute<Event, String> eventName;
  public static volatile SingularAttribute<Event, Integer> id;
}


/* Location:              /Users/FerCho/Github/SensoConnect/RFIDSenso-ejb/dist/RFIDSenso-ejb.jar!/com/senso_lab/rfid/entity/Event_.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */