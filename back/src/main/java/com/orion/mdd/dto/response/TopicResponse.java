package com.orion.mdd.dto.response;

import com.orion.mdd.dto.request.TopicDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TopicResponse {
   private List<TopicDto> topics;
}
