package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class MathService {
    private static int counter = 0;

    public MathResponse addInts(int first, int second){
        counter++;
        return new MathResponse(first+second, counter);
    }

}
