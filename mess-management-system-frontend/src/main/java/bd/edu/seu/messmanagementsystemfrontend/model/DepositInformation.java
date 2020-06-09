package bd.edu.seu.messmanagementsystemfrontend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositInformation{
    private long depositNo;
    private double amount;
    private LocalDate localDate;
    private String username;
}