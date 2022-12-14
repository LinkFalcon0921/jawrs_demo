package com.flincore.jawrs.jawrs_demo.embebbed;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class PhoneNumber {

    @Column(name = "phoneNumber")
    private String number;

    public PhoneNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number.replaceAll("(\\d{3})(\\d{3})(\\d+)","$1-$2-$3");
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
