package com.ht.meditor.mode;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class MapData {

    //private Integer level;
    private List<Material> materials;

//    public void reset(){
//        materials.clear();;
//    }

}
