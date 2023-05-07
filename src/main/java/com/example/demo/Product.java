package com.example.demo;

import java.util.ArrayList;
import java.util.Date;

public class Product{
    public String type;
    public Category category;
    public Data data;
    public String list_layer_check;
}
class Category{
    public int id;
    public String name;
    public String slug;
    public Object parent;
    public String type;
    public Object image;
    public Object meta_title;
    public Object description;
    public Object keyword;
    public Date created_at;
    public Date updated_at;
}

class Data{
    public int id;
    public String name;
    public String slug;
    public int price;
    public int sale_price;
    public Object content;
    public Object desc;
    public Object sale;
    public Object related_packages;
    public int status;
    public String type;
    public int sold;
    public String image;
    public String thumn;
    public int user_id;
    public int product_id;
    public String note_admin;
    public Date created_at;
    public Object updated_at;
    public int views;
    public int favorites;
    public int category_id;
    public String thumbnail;
    public String link_open_app;
    public ArrayList<ProductDetail> productDetail;
}

class ProductDetail{
    public int id;
    public int products_id;
    public String name;
    public String content;
    public int wight;
    public int height;
    public int sort;
    public Object postion_x;
    public Object postion_y;
    public Object type;
    public int status;
    public Object banner;
    public Date created_at;
    public Object updated_at;
    public Object text;
    public Object size;
    public Object font;
    public Object color;
    public Object gachchan;
    public Object innghieng;
    public Object gianchu;
    public Object brightness;
    public Object contrast;
    public Object saturate;
    public Object sepia;
    public Object invert;
    public Object grayscale;
    public Object blur;
    public Object vien;
    public int opacity;
    public Object linear_position;
    public Object gradient_color1;
    public Object gradient_color2;
    public int gradient;
    public int rotate;
    public Object deleted_at;
}

