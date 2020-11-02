/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Login;
import pojo.NewHibernateUtil;

/**
 *
 * @author Nicolaas'
 */
public class login {
    public void addLogin(Login login)
    {
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.save(login);
            trans.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public void deleteLogin(int id)
    {
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Login prod=(Login)session.load(Login.class, new Integer(id));
            session.delete(prod);
            trans.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public List<Login> getbyID(int id)
    {
        List<Login> login1=new ArrayList();
       
         Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Login where id= :id");
            query.setInteger("id", id);
            login1=query.list();
            
            trans.commit();
        }
        catch(Exception e)
        {
            
        }
        return login1;
    }
    
    public List<Login> retrieveLogin()
    {
       
        List prod=new ArrayList();
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Login");
            prod=query.list();
         
            trans.commit();
            
        }
        catch(Exception e)
        {

        }
        return prod;
    }
    
    public void updateLogin(Login login)
    {
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.update(login);
            trans.commit();
        }
        catch(Exception e)
        {
            
        }   
    }   
    
    public List<Login> validateLogin(String email, String password)
    {
        List<Login> login1=new ArrayList();
       
         Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Login where email= :email and password= :password");
            query.setString("email", email);
            query.setString("password", password);
            login1=query.list();
            
            trans.commit();
        }
        catch(Exception e)
        {
            
        }
        return login1;
    }
}

