package com.springboot.hospitalserchapi.parser;

public interface Parser<T> {
    T parse(String str);
}
