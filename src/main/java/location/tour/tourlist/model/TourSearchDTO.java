package location.tour.tourlist.model;

import lombok.Data;

@Data
public class TourSearchDTO {
private Long totalCount;
private Long pageNo;
private String addr1;//	addr1	주소
//	addr2	상세주소
//	areacode	지역코드
//	booktour	교과서 속 여행지
//	여부
//	cat1	대분류
//	cat2	중분류
//	cat3	소분류
private Long contentid;//	contentid	콘텐츠ID
private Long contenttypeid;//	contenttypeid	콘텐츠타입ID
//	createdtime	등록일
private String firstimage;//	firstimage	대표이미지(원본)
private String firstimage2;//	firstimage2	대표이미지(썸네일)
//	mapx	GPS X좌표
//	mapy	GPS Y좌표
//	mlevel	Map Level
//	modifiedtime	수정일
private Long readcount;//	readcount	조회수
//	sigungucode	시군구코드
//	tel	전화번호
private String title;//	title	제목

}
