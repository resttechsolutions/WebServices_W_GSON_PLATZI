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
public class GatosFav {
    private String id;
    private String image_id;
    private final String APIKEY;
    private ImageX image;

    public GatosFav() {
        super();
        this.APIKEY = "496e99c4-98dd-4807-9c09-f341eef838e7";
    }

    public GatosFav(String id) {
        this();
        this.id = id;
    }

    public GatosFav(String id, String image_id) {
        this(id);
        this.image_id = image_id;
    }

    public GatosFav(String id, String image_id, ImageX image) {
        this(id, image_id);
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public ImageX getImage() {
        return image;
    }

    public void setImage(ImageX image) {
        this.image = image;
    }

    public String getAPIKEY() {
        return APIKEY;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.image_id);
        hash = 89 * hash + Objects.hashCode(this.APIKEY);
        hash = 89 * hash + Objects.hashCode(this.image);
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
        final GatosFav other = (GatosFav) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.image_id, other.image_id)) {
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
        sb.append("GatosFav{id=").append(id);
        sb.append(", image_id=").append(image_id);
        sb.append(", APIKEY=").append(APIKEY);
        sb.append(", image=").append(image);
        sb.append('}');
        return sb.toString();
    }
    
    
}
