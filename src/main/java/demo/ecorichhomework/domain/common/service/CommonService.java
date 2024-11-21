package demo.ecorichhomework.domain.common.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.ecorichhomework.domain.common.data.dto.BeachTemperatureApiResponse;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class CommonService {

    private final RestTemplate restTemplate;
    private final String serviceKey = "yaR8Vg2NpB6ZdoyX%2BZTiFHRm%2B5sBTwpD5CGZzJ%2Fzdel4L1kXHPu7JzaRNFLXcqzSKRsRylKROfUAZ6xSeR%2Fwbw%3D%3D";
    private final String dataUrl = "https://apis.data.go.kr/1360000/BeachInfoservice/getTwBuoyBeach";
    final ObjectMapper objectMapper = new ObjectMapper();

    public BeachTemperatureApiResponse getBeachTemperature(String beachNum) throws JsonProcessingException {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        String searchTime = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));

        String uri = UriComponentsBuilder.fromHttpUrl(dataUrl)
                .queryParam("serviceKey", serviceKey)
                .queryParam("beach_num", beachNum)
                .queryParam("searchTime", searchTime)
                .queryParam("dataType", "json")
                .build(false)
                .toUriString();

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URI.create(uri), String.class);
        if (!HttpStatus.OK.equals(responseEntity.getStatusCode())) {
            throw new IllegalArgumentException("공공 API 호출 실패");
        }

        return objectMapper.readValue(responseEntity.getBody(), BeachTemperatureApiResponse.class);
    }

}
