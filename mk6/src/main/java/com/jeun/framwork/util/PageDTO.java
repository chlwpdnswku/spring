package com.jeun.framwork.util;

import lombok.Getter;

/*
 * 페이징 처리 용도 
 * 
 */

//이것을 이용해서 읽어가는 역할임 
@Getter
public class PageDTO {
	
	private static final int PAGING_TOT=10;		//페이지 버튼 출력개수 
	private int startPage;						//시작페이지
	private int endPage;						//끝페이지 
	private boolean prev,next;					// 앞,뒤로가기 
	private int totalData;						//전체 데이터 건수 
	private Criteria criPageInfo;				//현 페이지 정보
	
	public PageDTO(int totalData, Criteria criPageInfo) {
		super();
		this.totalData = totalData;
		this.criPageInfo = criPageInfo;
		
		//생성자를 이용해 계산값 받아오기  + 가변형으로넣기 
		endPage = this.criPageInfo.calcEndPageNo(PAGING_TOT);
		// endpage가 30 이면 30 -10+1 즉 21부터 30까지임 
		startPage = this.endPage - PAGING_TOT+1;
		
		int realEnd=this.criPageInfo.calcRealEndPageNo(totalData);
		
		//최종 쪽 번호 기분으로 마지막 번호 조정 
		// 100 > 99 
		if(endPage>realEnd) {
			endPage = realEnd;
		}
		//11 , 21 이면 앞으로 
		prev = startPage >1;
		//뒤로가기 
		next = realEnd > endPage;

		
		
	}
	
}
