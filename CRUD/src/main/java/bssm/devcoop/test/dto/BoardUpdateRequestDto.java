package bssm.devcoop.test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardUpdateRequestDto {
    private String name;
    private String title;
    private String content;

    @Builder
    public BoardUpdateRequestDto(String name, String title, String content) {
        this.name = name;
        this.title = title;
        this.content = content;
    }
}
