package com.example.demo;


public class MathResponse {
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public MathResponse(int value, int operationCount) {
        this.value = value;
        this.operationCount = operationCount;
    }

    public int getOperationCount() {
        return operationCount;
    }

    public void setOperationCount(int operationCount) {
        this.operationCount = operationCount;
    }

    int value;
    int operationCount;
}
