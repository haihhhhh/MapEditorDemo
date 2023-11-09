package com.ht.meditor.mode;

public class HeroSelectContextHolder {

    private static MaterialType materialType = MaterialType.HERO_TYPE_1;

    public static void selectHeroType(MaterialType materialType){
        HeroSelectContextHolder.materialType = materialType;
    }

    public static MaterialType currentHeroType(){
        return materialType;
    }
}
