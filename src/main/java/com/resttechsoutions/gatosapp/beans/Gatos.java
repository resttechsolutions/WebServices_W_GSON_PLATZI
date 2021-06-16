/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resttechsoutions.gatosapp.beans;

import java.util.Objects;

/**
 *
 * @author Rafael Estrella
 */
public class Gatos {
    
    private String id;
    private String url;
    private final String APIKEY;
    private String image;

    public Gatos() {
        this.APIKEY = "496e99c4-98dd-4807-9c09-f341eef838e7";
    }

    public Gatos(String id) {
        this();
        this.id = id;
    }

    public Gatos(String id, String url) {
        this(id);
        this.url = url;
    }

    public Gatos(String id, String url, String image) {
        this(id, url);
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAPIKEY() {
        return APIKEY;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.url);
        hash = 37 * hash + Objects.hashCode(this.APIKEY);
        hash = 37 * hash + Objects.hashCode(this.image);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Gatos other = (Gatos) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        if (!Objects.equals(this.APIKEY, other.APIKEY)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gatos{id=").append(id);
        sb.append(", url=").append(url);
        sb.append(", APIKEY=").append(APIKEY);
        sb.append(", image=").append(image);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
    
}
