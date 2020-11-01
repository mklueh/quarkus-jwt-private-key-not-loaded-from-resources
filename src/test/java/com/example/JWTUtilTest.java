package com.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @Test
    void createJWT8() {
        UUID uuid = UUID.randomUUID();
        assertNotNull(jwtUtil.createToken(new HashMap<>(), uuid.toString()));
    }

    @Test
    void createJWT9() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("privateKey.pem");

        UUID uuid = UUID.randomUUID();

        String privateKey = new BufferedReader(
                new InputStreamReader(is, StandardCharsets.UTF_8)).lines()
                .collect(Collectors.joining("\n"));

        assertNotNull(jwtUtil.createTokenWithSecret(new HashMap<>(), uuid.toString(), privateKey));
    }


    @Test
    void createJWT10() {
        createToken("classpath:/privateKey.pem");
    }


    @Test
    void createJWT11() {
        createToken("classpath:privateKey.pem");
    }


    @Test
    void createJWT12() {
        createToken("classpath:META-INF/resources/privateKey.pem");
    }


    @Test
    void createJWT13() {
        createToken("file:META-INF/resources/privateKey.pem");
    }


    @Test
    void createJWT14() {
        createToken("classpath:resources/privateKey.pem");
    }


    @Test
    void createJWT15() {
        createToken("classpath:target/resources/privateKey.pem");
    }

    @Test
    void createJWT16() {
        createToken("classpath:/resources/privateKey.pem");
    }

    private void createToken(String privateKeyLocation) {
        UUID uuid = UUID.randomUUID();
        assertNotNull(jwtUtil.createToken(new HashMap<>(), uuid.toString(), privateKeyLocation));
    }
}