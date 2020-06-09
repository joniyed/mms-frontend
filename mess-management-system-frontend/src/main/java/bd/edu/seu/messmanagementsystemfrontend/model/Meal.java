package bd.edu.seu.messmanagementsystemfrontend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meal{
    private long mealNo;
    private double breakfast;
    private double dinner;
    private double lunch;
    private String username;
    private LocalDate date;
}