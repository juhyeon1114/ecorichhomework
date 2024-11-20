package demo.ecorichhomework.global.utils;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.data.web.PagedModel;

public class PageUtils {

    public static <RESPONSE> PagedModel<RESPONSE> pagination(List<RESPONSE> items, Long count, Pageable pageable) {
        return new PagedModel<>(PageableExecutionUtils.getPage(
                items,
                pageable,
                () -> count == null ? 0 : count
        ));
    }

}
