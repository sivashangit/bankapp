package dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountDto {

    private int id;
    private String name;
    private double balance;

}
