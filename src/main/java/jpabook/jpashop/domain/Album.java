package jpabook.jpashop.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Album extends Item {
    
    private String artist;
    private String ect;
    
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getEct() {
        return ect;
    }
    public void setEct(String ect) {
        this.ect = ect;
    }

    
}
