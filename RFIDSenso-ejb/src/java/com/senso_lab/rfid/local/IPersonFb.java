package com.senso_lab.rfid.local;

import com.senso_lab.rfid.dao.IGenericDAO;
import com.senso_lab.rfid.entity.PersonFb;
import javax.ejb.Local;

@Local
public abstract interface IPersonFb
  extends IGenericDAO<PersonFb>
{
  public abstract boolean findByIdUser(String paramString, int paramInt);
  
  public abstract PersonFb getPersonByTag(String paramString);
}


/* Location:              /Users/FerCho/Github/SensoConnect/RFIDSenso-ejb/dist/RFIDSenso-ejb.jar!/com/senso_lab/rfid/local/IPersonFb.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */