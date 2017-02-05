package com.nanda.model;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class Article {
private int id;
private User user_id;
private String title,content;
private LocalDateTime createdDate,modified_Date;
private Byte active;
private SeedCategory seedCategory;

}
