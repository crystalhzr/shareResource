package com.jaovo.msg.dao;

import java.util.List;

import com.jaovo.msg.model.Message;

public interface IMessageDao {
   
   	  public void add(Message message);
//
//    public void delete(int id);
//
//    public void update(Message message);
//
//    public Message load(int id);
//
//    public Message loadByMsgTitle(String msgTitle);

      public List<Message> loadAll(); 
}