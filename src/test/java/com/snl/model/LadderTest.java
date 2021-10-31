package com.snl.model;

import org.junit.Test;

public class LadderTest {

        @Test
        public void test_LadderValidationPass() throws Exception {
            Ladder  ladder=new Ladder(10,30);
        }

        @Test(expected = Exception.class)
        public void test_LadderValidationFail() throws Exception {
            Ladder  ladder=new Ladder(30,10);
        }
    }

