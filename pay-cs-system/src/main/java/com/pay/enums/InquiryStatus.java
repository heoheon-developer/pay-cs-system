package com.pay.enums;

public enum InquiryStatus {

    WATTING(0),
    PROGRESS(1),
    COMPLETE(2);

    private final int value;
    private InquiryStatus(int value) {
        this.value = value;
    }

    private int getValue(){
        return value;
    }

}
