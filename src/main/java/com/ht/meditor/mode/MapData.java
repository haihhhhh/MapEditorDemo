package com.ht.meditor.mode;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Haitian
 * @create 2023/11/9
 */
@Builder
@Getter
@Setter
public class MapData {

    private List<Material> materials;

}
