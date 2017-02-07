package com.nanda.model;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class Article {
private int id;
private User userid;
private String title,content;
private LocalDateTime createdDate,modifiedDate;
private Byte active;
private SeedCategory seedCategory;

}
