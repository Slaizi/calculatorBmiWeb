package ru.Bogachev.calculate.service;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
@Service
public class CalculateService {
    public String [] calculationBmi (String height, String weight) {
        double w = Double.parseDouble(weight);
        StringBuilder stringBuilder = new StringBuilder();
        char [] x = height.toCharArray();
        for (int i = 0; i < x.length; i++) {
            if(i == 1) {
                stringBuilder.append(x[i]).append(".");
            }
            stringBuilder.append(x[i]);
        }
        double h = Double.parseDouble(stringBuilder.toString());
        if (h == 0 && w == 0) return new String[] {
                "Некорректные данные"
        };
        double bmi = (w / (h * h) * 100);

        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        String bmiRes = decimalFormat.format(bmi);

        String [] res;


        if (bmi <= 16.5)
            res = new String[] {
                    "Ваш ИМТ равен: " + bmiRes, "Дефицит массы тела"
            };
        else if (bmi <= 18.5)
            res = new String[] {
                    "Ваш ИМТ равен: " + bmiRes, "Норма"
            };
        else if (bmi <= 25)
            res = new String[] {
                    "Ваш ИМТ равен: " + bmiRes, "Избыточная масса тела"
            };
        else if (bmi <= 30)
            res = new String[] {
                    "Ваш ИМТ равен: " + bmiRes, "Ожирение 1 степени"
            };
        else if (bmi <= 35)
            res = new String[] {
                    "Ваш ИМТ равен: " + bmiRes, "Ожирение 2 степени"
            };
        else if (bmi <= 40)
            res = new String[] {
                    "Ваш ИМТ равен: " + bmiRes, "Ожирение 3 степени"
            };
        else
            res = new String[] {
                    "Ваш ИМТ равен: " + bmiRes, "Ожирение 4 степени"
            };
        return res;
    }
}
