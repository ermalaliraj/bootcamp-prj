package com.bootcamp.ms.profile.queryparam;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserQueryParam extends BaseQueryParam {
    private String name;
    private String gender;
}
