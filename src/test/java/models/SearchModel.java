package models;

import java.util.ArrayList;

public class SearchModel {
    ArrayList<String> categories;
    ArrayList<String> addressProvince;
    ArrayList<String> addressDistrict;
    Boolean isVideo, isPhoto, isMegaPhoto;

    public SearchModel(ArrayList<String> categories, ArrayList<String> addressProvince, ArrayList<String> addressDistrict, boolean isVideo, boolean isPhoto, boolean isMegaPhoto) {
        this.categories = categories;
        this.addressProvince = addressProvince;
        this.addressDistrict = addressDistrict;
        this.isVideo = isVideo;
        this.isPhoto = isPhoto;
        this.isMegaPhoto = isMegaPhoto;

    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public ArrayList<String> getAddressProvince() {
        return addressProvince;
    }

    public void setAddressProvince(ArrayList<String> addressProvince) {
        this.addressProvince = addressProvince;
    }

    public ArrayList<String> getAddressDistrict() {
        return addressDistrict;
    }

    public void setAddressDistrict(ArrayList<String> addressDistrict) {
        this.addressDistrict = addressDistrict;
    }

    public Boolean getVideo() {
        return isVideo;
    }

    public void setVideo(Boolean video) {
        isVideo = video;
    }

    public Boolean getPhoto() {
        return isPhoto;
    }

    public void setPhoto(Boolean photo) {
        isPhoto = photo;
    }

    public Boolean getMegaPhoto() {
        return isMegaPhoto;
    }

    public void setMegaPhoto(Boolean megaPhoto) {
        isMegaPhoto = megaPhoto;
    }
}
