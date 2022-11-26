package com.stefanpetcu.api.employeebonuses.application;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EmployeeBonusesCalculatorServiceImplTest {
    private final EmployeeBonusesCalculatorServiceImpl testSubject = new EmployeeBonusesCalculatorServiceImpl();

    @DataProvider(name = "bonuses-data-provider")
    public Object[][] bonusesDataProvider() {
        return new int[][][]{
                {{10, 40, 200, 1000, 60, 30}, {1, 2, 3, 4, 2, 1}},
                {{1000, 300, 200, 100, 10}, {1, 1, 1, 1, 1}},
                {{10, 100, 200, 300, 1000}, {1, 2, 3, 4, 5}},
                {{10, 100, 500, 100, 10}, {1, 2, 3, 2, 1}},
                {{10, 40, 200, 1000, 2000, 3000, 60, 30, 20}, {1, 2, 3, 4, 5, 6, 3, 2, 1}},
                {{10, 40, 200, 1000, 2000, 3000, 30, 60, 20}, {1, 2, 3, 4, 5, 6, 1, 2, 1}},
                {{10, 40, 200, 1000, 2000, 3000, 30, 20, 60}, {1, 2, 3, 4, 5, 6, 2, 1, 2}},
                {{10, 20, 30, 40, 50, 60, 70, 80, 30, 20, 60}, {1, 2, 3, 4, 5, 6, 7, 8, 2, 1, 2}},
                {{10, 20, 30, 40, 50, 60, 70, 80, 40, 30, 20, 60}, {1, 2, 3, 4, 5, 6, 7, 8, 3, 2, 1, 2}},
                {{10, 20, 30, 40, 50, 60, 70, 80, 40, 30, 20, 10}, {1, 2, 3, 4, 5, 6, 7, 8, 4, 3, 2, 1}},
                {{10, 20, 30, 40, 50, 60, 70, 80, 10, 20, 30, 40}, {1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4}},
        };
    }

    @Test(dataProvider = "bonuses-data-provider")
    public void testBonusesFor_willReturnCorrectBonuses_givenListOfEmployeeCodeOutputs(int[] input, int[] expected) {
        assertEquals(testSubject.bonusesFor(input), expected);
    }
}
