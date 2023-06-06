package com.example.gongguhaejo;

import java.time.LocalDateTime;

public class GongguList {
    private String rest_name; // 식당 이름
    private String food_cate; // 음식 카테고리
    private String food_cate_image;// 음식 카테고리 이미지
    private String choice_food; // 고른 음식 메뉴
    private int food_price; // 메뉴 가격
    private int food_deliveryprice; // 배달비
    private String location; // 사용자 위치
    private String receive; // 수령 장소
    private LocalDateTime time_limit; // 제한 시간

    public GongguList() {}

    public String getRest_name() {
        return rest_name;
    }

    public void setRest_name(String rest_name) {
        this.rest_name = rest_name;
    }

    public String getFood_cate() {
        return food_cate;
    }

    public void setFood_cate(String food_cate) {
        this.food_cate = food_cate;
    }

    public String getFood_cate_image() {
        return food_cate_image;
    }

    public void setFood_cate_image(String food_cate_image) {
        this.food_cate_image = food_cate_image;
    }

    public String getChoice_food() {
        return choice_food;
    }

    public void setChoice_food(String choice_food) {
        this.choice_food = choice_food;
    }

    public int getFood_price() {
        return food_price;
    }

    public void setFood_price(int food_price) {
        this.food_price = food_price;
    }

    public int getFood_deliveryprice() {
        return food_deliveryprice;
    }

    public void setFood_deliveryprice(int food_deliveryprice) {
        this.food_deliveryprice = food_deliveryprice;
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getTime_limit() {
        return time_limit;
    }

    public void setTime_limit(LocalDateTime time_limit) {
        this.time_limit = time_limit;
    }
}