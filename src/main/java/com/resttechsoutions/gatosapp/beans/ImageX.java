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
public class ImageX {
    private String Id;
    private String url;

    public ImageX() {
        super();
    }

    public ImageX(String Id) {
        this();
        this.Id = Id;
    }

    public ImageX(String Id, String url) {
        this(Id);
        this.url = url;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.Id);
        hash = 37 * hash + Objects.hashCode(this.url);
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
        final ImageX other = (ImageX) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImageX{Id=").append(Id);
        sb.append(", url=").append(url);
        sb.append('}');
        return sb.toString();
    }
    
    
}
