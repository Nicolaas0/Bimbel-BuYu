package pojo;
// Generated Oct 26, 2020 2:22:11 AM by Hibernate Tools 4.3.1


import dao.jadwal;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 * Jadwal generated by hbm2java
 */
@ManagedBean
public class Jadwal  implements java.io.Serializable {


     private Integer id;
     private String hari;
     private String jam;
     private String media;

    public Jadwal() {
    }

    public Jadwal(String hari, String jam, String media) {
       this.hari = hari;
       this.jam = jam;
       this.media = media;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getHari() {
        return this.hari;
    }
    
    public void setHari(String hari) {
        this.hari = hari;
    }
    public String getJam() {
        return this.jam;
    }
    
    public void setJam(String jam) {
        this.jam = jam;
    }
    public String getMedia() {
        return this.media;
    }
    
    public void setMedia(String media) {
        this.media = media;
    }

    public void save()
    {
        jadwal pdao=new jadwal();
        pdao.addJadwal(this);
    }

    public void delete()
    {    
        jadwal pdao=new jadwal();
        pdao.deleteJadwal(id);
    }

    public List<Jadwal> getbyid()
    { 
        jadwal pdao=new jadwal();
        List<Jadwal> prod=pdao.getbyID(id);
        hari=prod.get(0).hari;
        jam=prod.get(0).jam;
        media=prod.get(0).media;
        return prod;
    }

    public List<Jadwal> getallrecords()
    {
        jadwal pdao=new jadwal();
        List<Jadwal> prod=pdao.retrieveJadwal();
        return prod;
    }

    public void update()
    {
        jadwal pdao=new jadwal();
        pdao.updateJadwal(this);
    }



}


