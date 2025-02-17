package com.jojoldu.book.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("ROLE_GUEST","GUEST"),
    USER("ROLE_USER","USER");
    //스프링 시큐리티에서 권한 코드는 항상 ROLE이 앞에 있어야 함
    private final String key;
    private final String title;
}
