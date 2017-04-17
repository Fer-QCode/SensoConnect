package com.senso_lab.rfid.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(TagCard.class)
public class TagCard_
{
  public static volatile SingularAttribute<TagCard, String> rfidTag;
  public static volatile SingularAttribute<TagCard, Integer> id;
  public static volatile SingularAttribute<TagCard, Integer> status;
}


/* Location:              /Users/FerCho/Github/SensoConnect/RFIDSenso-ejb/dist/RFIDSenso-ejb.jar!/com/senso_lab/rfid/entity/TagCard_.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */