package demo.ecorichhomework.domain.common.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import demo.ecorichhomework.domain.common.data.dto.BeachTemperatureApiResponse;
import demo.ecorichhomework.domain.common.service.CommonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Common API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/common")
public class CommonController {

    private final CommonService commonService;

    @Operation(summary = "현재 해수욕장의 수온 조회 API")
    @GetMapping("/beach/{beachNum}/temperature")
    public Double getWeather(@Parameter(description = "해변 코드 (ex. 1, 2, 10, 20)") @PathVariable("beachNum") String beachNum) throws JsonProcessingException {
        BeachTemperatureApiResponse response = commonService.getBeachTemperature(beachNum);
        return response.getTemperature();
    }

}
