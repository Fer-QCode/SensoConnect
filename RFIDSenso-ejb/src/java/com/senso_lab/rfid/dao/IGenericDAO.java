package com.senso_lab.rfid.dao;

import java.util.List;

public abstract interface IGenericDAO<E>
{
  public abstract void create(E paramE);
  
  public abstract List<E> readAll();
  
  public abstract boolean update(E paramE);
  
  public abstract void delete(E paramE);
}


/* Location:              /Users/FerCho/Github/SensoConnect/RFIDSenso-ejb/dist/RFIDSenso-ejb.jar!/com/senso_lab/rfid/dao/IGenericDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */