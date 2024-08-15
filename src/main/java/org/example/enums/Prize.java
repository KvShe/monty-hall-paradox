package org.example.enums;

import lombok.Getter;
import lombok.Setter;

public enum Prize {
    CAR, GOAT;
    @Setter
    @Getter
    private Status status;

    Prize() {
        this.status = Status.CLOSED;
    }
}
