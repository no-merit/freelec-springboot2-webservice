package com.jojoldu.book.springboot.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
//JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들도 칼럼으로 인식하도록
@EntityListeners(AuditingEntityListener.class)
//클래스에 Auditing 기능을 포함
public class BaseTimeEntity {
    @CreatedDate
    private LocalDateTime createDate;
    //Entity가 생성되어 저장될 때 시간이 자동으로 저장
    @LastModifiedDate
    private LocalDateTime modifiedDate;
    //Entity의 값을 변경할 때 시간이 자동 저장
}
