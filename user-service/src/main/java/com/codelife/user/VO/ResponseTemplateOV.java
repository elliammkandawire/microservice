package com.codelife.user.VO;

import com.codelife.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateOV {
    private User user;
    private Department department;
}
