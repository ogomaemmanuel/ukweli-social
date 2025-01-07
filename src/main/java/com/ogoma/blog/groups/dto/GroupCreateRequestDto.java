package com.ogoma.blog.groups.dto;

import com.ogoma.blog.groups.entities.GroupPrivacy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupCreateRequestDto {
    private String name;
    private GroupPrivacy privacy;
    private String description;
    private boolean viewOnly;
}
