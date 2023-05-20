package com.jeun.domain;

import java.util.Date;



import lombok.Data;
@Data

public class BoardVO {
	
	private int id;
	
	private String title;
	
	private String content;

	private String author;
	//등록 
	private Date created_at;
	//업데이트 
	private Date updated_at;

	
}
