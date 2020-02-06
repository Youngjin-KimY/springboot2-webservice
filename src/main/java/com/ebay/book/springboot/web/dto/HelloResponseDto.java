package com.ebay.book.springboot.web.dto;

public class HelloResponseDto {

    public HelloResponseDto(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    private final String name;
    private final int amount;

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}
