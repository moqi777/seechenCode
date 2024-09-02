package com.sc.kuaizilive.server.impl;

import com.sc.kuaizilive.util.GenerateUsername;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class KUserServerImplTest {
    @Test
    public void codeLogin(){
        for (int i = 0; i < 999; i++) {
            String username = GenerateUsername.getUsername();
            System.out.println(username);
        }
    }
}