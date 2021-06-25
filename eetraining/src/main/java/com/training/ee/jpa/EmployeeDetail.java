package com.training.ee.jpa;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class EmployeeDetail implements Serializable {

    private static final long serialVersionUID = -3345354022881441867L;
    private String            nickName;
    @Enumerated(EnumType.STRING)
    private EStatus           status;

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(final String nickNameParam) {
        this.nickName = nickNameParam;
    }

    public EStatus getStatus() {
        return this.status;
    }

    public void setStatus(final EStatus statusParam) {
        this.status = statusParam;
    }


}
