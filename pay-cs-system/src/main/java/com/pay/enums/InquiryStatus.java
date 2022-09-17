package com.pay.enums;

public enum InquiryStatus {

    INQUIRY_WATTING(0),
    INQUIRY_COMPLETE(1);

    private final int value;
    private InquiryStatus(int value) {
        this.value = value;
    }

    private int getValue(){
        return value;
    }

}
