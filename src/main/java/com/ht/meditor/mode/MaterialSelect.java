package com.ht.meditor.mode;

public class MaterialSelect {

    private static MaterialType materialType = MaterialType.stone;

    public static void selectMaterialType(MaterialType materialType){
        MaterialSelect.materialType = materialType;
    }

    public static MaterialType currentMaterialType(){
        return materialType;
    }
}
