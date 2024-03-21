package com.example.emsbackend.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddDepRequest {
    private Long orgId;
    private Long deptId;
}
