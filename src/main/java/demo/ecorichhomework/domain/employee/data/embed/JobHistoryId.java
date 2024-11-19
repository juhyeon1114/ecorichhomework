package demo.ecorichhomework.domain.employee.data.embed;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class JobHistoryId implements Serializable {

    @Column(nullable = false)
    private Integer employeeId;
    @Column(nullable = false)
    private LocalDate startDate;

}
