package com.lyx.lab.core.util;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Description LabDigestUtilsTest
 * @Author liyuxing
 * @Date 2019-12-14
 */
class LabDigestUtilsTest {

    @Test
    void getMD5() throws NoSuchAlgorithmException {
        assertThat(LabDigestUtils.getMD5("lyx")).isEqualTo("20f7114835d2000492757988997ea8a2");
    }

    @Test
    void getSHA1() throws NoSuchAlgorithmException {
        assertThat(LabDigestUtils.getSHA1("lyx")).isEqualTo("de430d3681034599cb30993a98a5b60f702ce274");
    }

    @Test
    void getSHA256() throws NoSuchAlgorithmException {
        assertThat(LabDigestUtils.getSHA256("lyx")).isEqualTo("4418f43f6941c1f7837952c05b9287d31132ef017034a8bc43eda45ba9e1e1d7");
    }

    @Test
    void getMD5WithSpringUtil() {
        assertThat(LabDigestUtils.getMD5WithSpringUtil("lyx")).isEqualTo("20f7114835d2000492757988997ea8a2");
    }
}