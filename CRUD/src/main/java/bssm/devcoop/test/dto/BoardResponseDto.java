package bssm.devcoop.test.dto;

import bssm.devcoop.test.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardResponseDto {
    private String name;
    private String title;
    private String content;

    public BoardResponseDto(Board board) {
        this.name = board.getName();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
