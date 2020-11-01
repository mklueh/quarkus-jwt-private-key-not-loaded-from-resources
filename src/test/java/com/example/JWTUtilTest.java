package com.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class JWTUtilTest {

    private JWTUtil jwtUtil;

    @BeforeEach
    void setUp() {
        jwtUtil = new JWTUtil();
    }

    @Test
    void createJWT1() {
        createToken("privateKey.pem");
    }

    @Test
    void createJWT2() {
        createToken("/privateKey.pem");
    }

    @Test
    void createJWT3() {
        createToken("META-INF/resources/privateKey.pem");
    }

    @Test
    void createJWT4() {
        createToken("/META-INF/resources/privateKey.pem");
    }

    @Test
    void createJWT5() {
        createToken("/target/classes/privateKey.pem");
    }

    @Test
    void createJWT6() {
        createToken("resources/privateKey.pem");
    }

    @Test
    void createJWT7() {
        createToken("/resources/privateKey.pem");
    }

    private void createToken(String privateKeyLocation) {
        UUID uuid = UUID.randomUUID();
        assertNotNull(jwtUtil.createToken(new HashMap<>(), uuid.toString(), privateKeyLocation));
    }
}