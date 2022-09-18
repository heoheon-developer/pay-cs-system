package com.pay.enums;

public enum InquiryStatus {

    INQUIRY_WATTING(0),
    INQUIRY_PROGRESS(1),
    INQUIRY_COMPLETE(2);

    private final int value;
    private InquiryStatus(int value) {
        this.value = value;
    }

    private int getValue(){
        return value;
    }

}
