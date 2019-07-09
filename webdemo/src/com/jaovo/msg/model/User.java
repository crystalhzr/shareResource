package com.jaovo.msg.model;

public class User 
{
    private int id;
    private String username;
    private String password;
    private String email;
    public String school;
    public String college;
    public String profession;
    
    public int getId() 
    {
        return id;
    }
    public void setId(int id) 
    {
        this.id = id;
    }
    public String getUsername() 
    {
        return username;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }
    public String getEmail() 
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getPassword() 
    {
        return password;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }
}