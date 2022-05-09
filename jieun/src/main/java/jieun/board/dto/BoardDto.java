package jieun.board.dto;

import lombok.*;
import jieun.domain.entity.Board;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String author;
    private String title;
    private String content;

    @Builder
    public BoardDto(Long id, String author, String title, String content) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;

    }

    public Board toEntity() {
        Board build = Board.builder()
                .id(id)
                .author(author)
                .title(title)
                .content(content)
                .build();
        return build;
    }
}