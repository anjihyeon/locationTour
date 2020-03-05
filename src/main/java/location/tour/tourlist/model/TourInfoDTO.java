package location.tour.tourlist.model;

import lombok.Data;

@Data
public class TourInfoDTO {
private Long contentid;//	contentid	콘텐츠ID
private Long contenttypeid;//	contenttypeid	콘텐츠타입ID
//	booktour	교과서 여행지 여부
private Long createdtime;//	createdtime	등록일
private String homepage;//	homepage	홈페이지 주소
private Long modifiedtime;//	modifiedtime	수정일
private String tel;//	tel	전화번호
//	telname	전화번호명
private String title;//	title	콘텐츠명(제목)
private String firstimage;//	firstimage	대표이미지(원본)
private String firstimage2;//	firstimage2	대표이미지(썸네일)
//	areacode	지역코드
//	sigungucode	시군구코드
//	cat1	대분류
//	cat2	중분류
//	cat3	소분류
private String addr1;//	addr1	주소
private String addr2;//	addr2	상세주소
//	zipcode	우편번호
private double mapx;//	mapx	GPS X좌표
private double mapy;//	mapy	GPS Y좌표

private Long mlevel;//	mlevel	Map Level
private String overview;//	overview	개요

}	
