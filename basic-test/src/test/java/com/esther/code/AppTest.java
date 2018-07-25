package com.esther.code;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    public static void main(String[] args) {
//        try {
            print();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
    }

    public static void print()   {
        try {
            throw new Exception("error");
        } catch (Exception e) {
            System.out.println(1111111);
            e.printStackTrace();
        }
    }
}
