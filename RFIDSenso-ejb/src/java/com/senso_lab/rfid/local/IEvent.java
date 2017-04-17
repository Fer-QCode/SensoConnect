package com.senso_lab.rfid.local;

import com.senso_lab.rfid.dao.IGenericDAO;
import com.senso_lab.rfid.entity.Event;
import javax.ejb.Local;

@Local
public abstract interface IEvent
  extends IGenericDAO<Event>
{}


/* Location:              /Users/FerCho/Github/SensoConnect/RFIDSenso-ejb/dist/RFIDSenso-ejb.jar!/com/senso_lab/rfid/local/IEvent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */