package com.jaovo.msg.model;

public class Resource {
	
    private int id;
    private String resoceName;
    private String resoceLoc;
    private String resoceAuthor;
    private String type;
    private String title;
    private String describe;
    private String date;
    
    public int getId() 
    {
        return id;
    }
    public void setId(int id) 
    {
        this.id = id;
    }
    public String getResoceName() 
    {
        return resoceName;
    }
    public void setResoceName(String resoceName) 
    {
        this.resoceName = resoceName;
    }
    public String getResoceLoc() 
    {
        return resoceLoc;
    }
    public void setResoceLoc(String resoceLoc)
    {
        this.resoceLoc = resoceLoc;
    }
    public String getResoceAuthor() 
    {
        return resoceAuthor;
    }
    public void setResoceAuthor(String resoceAuthor) 
    {
        this.resoceAuthor = resoceAuthor;
    }
    public String getType() 
    {
        return type;
    }
    public void setType(String type) 
    {
        this.type = type;
    }
    public String getTitle() 
    {
        return title;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }
    public String getDescribe() 
    {
        return describe;
    }
    public void setDescribe(String describe) 
    {
        this.describe = describe;
    }
    public String getDate() 
    {
        return date;
    }
    public void setDate(String date) 
    {
        this.date = date;
    }
}