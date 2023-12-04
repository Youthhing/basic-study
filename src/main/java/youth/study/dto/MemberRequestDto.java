package youth.study.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberRequestDto {

    private String email;
    private String name;
    private String password;
}
