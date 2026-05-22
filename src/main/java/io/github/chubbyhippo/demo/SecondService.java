package io.github.chubbyhippo.demo;

import org.springframework.stereotype.Service;

@Service
public class SecondService {
    public String getText() {
        return "First Service";
    }
}
