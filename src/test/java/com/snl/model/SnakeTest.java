package com.snl.model;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class SnakeTest {

    @Test(expected = Exception.class)
    public void test_SnakeValidationFail() throws Exception {
        Snake  ladder=new Snake(10,30);
    }

    @Test
    public void test_SnakeValidationPass() throws Exception {
        Snake  ladder=new Snake(30,10);
    }
}
