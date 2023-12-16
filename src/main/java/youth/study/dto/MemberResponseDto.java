package youth.study.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
public class MemberResponseDto {

    private String email;
    private String name;
}