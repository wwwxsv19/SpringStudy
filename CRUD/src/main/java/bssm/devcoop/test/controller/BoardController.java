package bssm.devcoop.test.controller;

import bssm.devcoop.test.dto.BoardRequestDto;
import bssm.devcoop.test.dto.BoardResponseDto;
import bssm.devcoop.test.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/create")
    public void insert(@RequestBody BoardRequestDto boardRequestDto) {
        boardService.create(boardRequestDto);
    }

    @PostMapping("/read")
    public List<BoardResponseDto> select() {
        return boardService.read();
    }
}
