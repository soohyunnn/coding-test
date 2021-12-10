package com.test.coding;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestInterfaceDemo extends TimeExecutingLogger implements TestLifecycleLogger
         {

    @Test
    @DisplayName("동일 테스트")
    void isEqualValue() {
        Assertions.assertEquals(1, "a".length(), "항상 같음");
    }
}