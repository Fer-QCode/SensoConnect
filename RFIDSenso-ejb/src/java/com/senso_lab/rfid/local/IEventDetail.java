package com.senso_lab.rfid.local;

import com.senso_lab.rfid.dao.IGenericDAO;
import com.senso_lab.rfid.entity.EventDetail;
import javax.ejb.Local;

@Local
public abstract interface IEventDetail
  extends IGenericDAO<EventDetail>
{
  public abstract EventDetail findActiveEvent(int paramInt1, int paramInt2);
}


/* Location:              /Users/FerCho/Github/SensoConnect/RFIDSenso-ejb/dist/RFIDSenso-ejb.jar!/com/senso_lab/rfid/local/IEventDetail.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */