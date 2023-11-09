package com.ht.meditor.mode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HeroSprite {

    private int col = 0;
    private int row = 0;
    private MaterialType materialType;


    public boolean isIn(int x,int y){
        return this.col==x&& row==y;
    }





}

