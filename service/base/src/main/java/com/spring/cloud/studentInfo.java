package com.spring.cloud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：vivaciousis
 * @date ：Created in 2019/9/11 22:12
 * @description：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class studentInfo {
    private Long id;
    private String username;
    private String email;

    public static studentInfo invalid(){
        return new studentInfo(-1L,"","");
    }
}
