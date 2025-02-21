package com.orion.mdd.dto.response;

import com.orion.mdd.dto.request.ArticleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleResponse {
    private List<ArticleDto> articles;
}
