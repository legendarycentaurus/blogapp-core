package com.nanda.model;

import lombok.Data;

@Data
public class ArticleCategory {
private int id;
private Article articleId;
private SeedCategory categoryId;
}
