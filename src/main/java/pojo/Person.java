package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    private String p_name;
    private String p_phone;
    private String p_address;
    private String p_sex;
    private Integer p_g_id;
}
