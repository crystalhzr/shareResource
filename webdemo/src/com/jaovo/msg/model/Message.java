package com.jaovo.msg.model;

public class Message {
    private int id;
    private String msgPoster;
    private String msgTitle;
    private String msgContent;
    private String msgDate;
    
    public int getId() 
    {
        return id;
    }
    public void setId(int id) 
    {
        this.id = id;
    }
    public String getmsgPoster() 
    {
        return msgPoster;
    }
    public void setmsgPoster(String msgPoster) 
    {
        this.msgPoster = msgPoster;
    }
    public String getmsgTitle() 
    {
        return msgTitle;
    }
    public void setmsgTitle(String msgTitle)
    {
        this.msgTitle = msgTitle;
    }
    public String getmsgContent() 
    {
        return msgContent;
    }
    public void setmsgContent(String msgContent) 
    {
        this.msgContent = msgContent;
    }
    public String getmsgDate() 
    {
        return msgDate;
    }
    public void setmsgDate(String msgDate) 
    {
        this.msgDate = msgDate;
    }
}
