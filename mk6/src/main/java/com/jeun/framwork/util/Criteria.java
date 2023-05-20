package com.jeun.framwork.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Criteria {
	
	
	//list?pageNum=1&amount=3이런식으로 api를 날려줌 
	private int pageNum=1;
	private int amount=3;
	
	//일단 이것을 기본 생성자로 해줌 pagenum은 1 이고 ,amount=3이다 
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	//0~9 . 2페이지 10 부터시작 3페이지 20부터시작 이거자체가 그냥 생성자임 !! 
	public int getOffset() {
		return (pageNum-1) * amount;
	}
	
	 /* 현 페이지를 기준으로 10개씩 나타낼때 마지막 쪽번호 산출하기 
	 * @param 
	 * @return 
	 * */
	//2페이지는 20 3페이지는 30? 
	public int calcEndPageNo(int pagingTotBtn) {
		// 생성자를 내려줘서 가변형으로 페이징토탈을 만들어줌  p304
		return (int) (Math.ceil((float)pageNum/pagingTotBtn)*pagingTotBtn);
	}
	
	//전체데이터 건수 기반 최종 쪽 번호 
	public int calcRealEndPageNo(int totalDataCnt)
	{
		//전체 데이터 갯수가 100개면 10으로 나누어서 최종 쪽 번호를 얻음 p305
		return (int) Math.ceil((float)totalDataCnt/amount);
	}
	
	

}
