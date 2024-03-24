package bssm.devcoop.test.service;

import bssm.devcoop.test.dto.BoardRequestDto;
import bssm.devcoop.test.dto.BoardResponseDto;
import bssm.devcoop.test.dto.BoardUpdateRequestDto;
import bssm.devcoop.test.entity.Board;
import bssm.devcoop.test.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    public void create(BoardRequestDto boardRequestDto) {
        String name = boardRequestDto.getName();
        String title = boardRequestDto.getTitle();
        String content = boardRequestDto.getContent();

        if(name == null) {
            throw new RuntimeException("이름이 부정확합니다 >.<");
        }

        Board board = Board.builder()
                .name(name).title(title).content(content)
                .build();

        boardRepository.save(board);
    }

    public List<BoardResponseDto> read() {
        List<Board> boardList = boardRepository.findAll();
        List<BoardResponseDto> boardResponseList = new ArrayList<>();

        for (Board board : boardList) {
            boardResponseList.add(
                    new BoardResponseDto(board)
            );
        }

        return boardResponseList;
    }

    public void update(BoardUpdateRequestDto boardUpdateRequestDto, Long id) {
        Board board = BoardRepository.findById(id);
        board.update(boardUpdateRequestDto.getName(), boardUpdateRequestDto.getTitle(), boardUpdateRequestDto.getContent());
    }
}
