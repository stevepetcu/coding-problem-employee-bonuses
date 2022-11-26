package com.stefanpetcu.api.employeebonuses.application;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class EmployeeBonusesCalculatorServiceImpl implements EmployeeBonusesCalculatorService {
    @Override
    public int[] bonusesFor(int[] employeesCodeOutputs) {
        int[] result = new int[employeesCodeOutputs.length];
        Arrays.fill(result, 1);

        for (int i = 0; i < employeesCodeOutputs.length; i++) {
            if (i == 0) {
                result[i] = 1;
            } else if (employeesCodeOutputs[i] > employeesCodeOutputs[i - 1]) {
                result[i] = result[i - 1] + 1;
            } else if (employeesCodeOutputs[i] < employeesCodeOutputs[i - 1]) {
                if (result[i - 1] == 1) {
                    result[i] = 1;
                } else if (i < employeesCodeOutputs.length - 1) {
                    if (employeesCodeOutputs[i] >= employeesCodeOutputs[i + 1]) {
                        if (employeesCodeOutputs[i] < Arrays.stream(Arrays.copyOfRange(employeesCodeOutputs, i + 1, employeesCodeOutputs.length)).max().getAsInt()) {
                            result[i] = employeesCodeOutputs.length - i - 1;
                        } else {
                            result[i] = employeesCodeOutputs.length - i;
                        }
                    } else if (employeesCodeOutputs[i] < employeesCodeOutputs[i + 1]) {
                        result[i] = 1;
                    }
                }
            } else {
                result[i] = result[i - 1];
            }
        }

        return result;
    }
}
