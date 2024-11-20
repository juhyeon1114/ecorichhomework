package demo.ecorichhomework.global.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Schema(title = "페이지네이팅 요청 객체")
public record PaginationRequestParam(
        @Schema(description = "페이지") Integer page,
        @Schema(description = "한 페이지당 크기") Integer size
) {

    public PaginationRequestParam(Integer page, Integer size) {
        this.page = Objects.isNull(page) ? 0 : page;
        this.size = Objects.isNull(size) ? 10 : size;
    }

    @JsonIgnore
    public Pageable pageable() {
        return PageRequest.of(page, size);
    }

}
