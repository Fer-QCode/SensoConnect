package com.senso_lab.rfid.local;

import com.senso_lab.rfid.dao.IGenericDAO;
import com.senso_lab.rfid.entity.TagCard;
import javax.ejb.Local;

@Local
public abstract interface ITagCard
  extends IGenericDAO<TagCard>
{
  public static final int TAG_CARD_AVAILABLE = 0;
  public static final int TAG_CARD_UNAVAILABLE = 1;
  
  public abstract boolean findTagByRfid(String paramString);
}


/* Location:              /Users/FerCho/Github/SensoConnect/RFIDSenso-ejb/dist/RFIDSenso-ejb.jar!/com/senso_lab/rfid/local/ITagCard.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */