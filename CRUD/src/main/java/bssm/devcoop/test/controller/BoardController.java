package bssm.devcoop.test.controller;

import bssm.devcoop.test.dto.BoardRequestDto;
import bssm.devcoop.test.dto.BoardResponseDto;
import bssm.devcoop.test.dto.BoardUpdateRequestDto;
import bssm.devcoop.test.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/read")
    public List<BoardResponseDto> select() {
        return boardService.read();
    }

    @PostMapping("/update")
    public void update(@RequestBody BoardUpdateRequestDto boardUpdateRequestDto, Long id) {
        boardService.update(boardUpdateRequestDto, id);
    }
}