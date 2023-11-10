package com.ht.meditor.mode;

public enum MaterialType {

    stone("stone",1),//石头
    grass("grass",2);//草丛

    private String name;
    private int type ;// 1 阻挡 2遮盖

    MaterialType(String name,int type ){
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public static MaterialType fromString(String name) {
        for (MaterialType type : values()) {
            if (type.name.equalsIgnoreCase(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid day: " + name);
    }

}
