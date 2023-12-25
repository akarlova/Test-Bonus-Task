package org.example.app.service;

import org.example.app.utils.Rounder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    private BonusService service;

    @BeforeEach
    void setUp() {
        service = new BonusService();
    }

    @Test
    void test_Bonus_Service_With_Expected_Result() {

        double sales = 2000;
        String expectedBonusServ = Rounder.roundValue(sales * 0.1);
        String actualBonusServ = service.getRes(sales);

        assertEquals(expectedBonusServ, actualBonusServ);
    }

    @Test
    void test_Bonus_Service_With_Unexpected_Result() {

        double sales = -2000;

        String unexpectedBonusServ = Rounder.roundValue(sales * 0.1);
        String actualBonusServ = service.getRes(sales);

        assertNotEquals(unexpectedBonusServ, actualBonusServ);
    }

    @Test
    void test_Calculation_Bonus_With_Expected_Sales() {
        double sales = 2000;
        double expectedBonus = sales * 0.1;
        double actualBonus = service.calcBonus(sales);

        assertEquals(expectedBonus, actualBonus);
    }

    @Test
    void test_Calculation_Bonus_With_Unexpected_Sales() {

        double sales = -2000;
        double unexpectedBonus = 0.0;
        double actualBonus = service.calcBonus(sales);

        assertNotEquals(unexpectedBonus, actualBonus);
    }

    @AfterEach
    void tearDown() {
        service = null;
    }
}