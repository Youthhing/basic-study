package youth.study.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberRequestDto {

    private String email;
    private String name;
    private String password;


}
