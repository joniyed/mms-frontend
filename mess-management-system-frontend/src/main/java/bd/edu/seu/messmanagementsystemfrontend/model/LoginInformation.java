package bd.edu.seu.messmanagementsystemfrontend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInformation {
    private String username;
    private String password;
    private Role role;
}
