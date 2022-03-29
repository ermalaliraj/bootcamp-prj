package com.bootcamp.ms.profile.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
//@EntityListeners({AuditingEntityListener.class, UUIDEntityListener.class})
@EntityListeners({AuditingEntityListener.class})
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class BaseEntity {

    @Id
    @Setter
    @Column(name = "id")
    @ToString.Include
    @EqualsAndHashCode.Include
    private String id;

    @Override
    public String toString() {
        ReflectionToStringBuilder sb = new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        sb.setExcludeNullValues(true);
        return sb.toString();
    }

}
