package com.example.tvstore;

public class Television {
    public int id;
    public String name;
    public String brand;
    public int quantity;
    public String high_resolution;
    public String image;
    public String size;
    public float price;


//    public Television(String text, String tfBrandText, int tfQuantityText, String tfHigh_resolutionText, String tfImageText, String tfSizeText, float tfPriceText) {
//    }
    public Television(int id,String name, String brand, int quantity, String high_resolution, String image, String size, float price) {
        this.id=id;
        this.name=name;
        this.brand=brand;
        this.quantity=quantity;
        this.high_resolution=high_resolution;
        this.image=image;
        this.size=size;
        this.price=price;
    };
    public Television(String name, String brand, int quantity, String high_resolution, String image, String size, float price) {
        this.name=name;
        this.brand=brand;
        this.quantity=quantity;
        this.high_resolution=high_resolution;
        this.image=image;
        this.size=size;
        this.price=price;
    }
}
//    public int getId(){
//        return id;
//    }
//    public void setId(int name){
//    this.id=id;
//    }
//    public String getName(){
//        return name;
//    }
//    public void setName(String name){
//        this.name=name;
//    }
//    public String getBrand(){
//        return brand;
//    }
//    public void setBrand(String brand){
//        this.brand=brand;
//    }
//    public int getQuantity(){
//        return quantity;
//    }
//    public void setQuantity(int quantity){
//        this.quantity=quantity;
//    }
//    public String getHigh_resolution(){
//        return high_resolution;
//    }
//    public void setHigh_resolution(String high_resolution){
//        this.high_resolution=high_resolution;
//    }
//
//    public String getImage(){
//        return image;
//    }
//    public void setImage(String image){
//        this.image=image;
//    }
//    public String getSize(){
//        return size;
//    }
//    public void setSize(String size){
//        this.size=size;
//    }
//    public Float getFrice(){
//        return price;
//    }
//    public void setFrice(Float frice){
//        this.price=price;
//    }
//
//}

