package location.tour.tourlist.model;

import lombok.Data;

@Data
public class TourlistDTO {
private String addr1;//	addr1	주소
//	addr2	상세주소
private Long arecode;//	areacode	지역코드
private String cat1;//	cat1	대분류
private String cat2;//	cat2	중분류
private String cat3;//	cat3	소분류
private Long contentid;//	contentid	콘텐츠ID
private Long contenttypeid;//contenttypeid	콘텐츠타입ID
private Long creaetedtime;//	createdtime	등록일
private String firstimage;//	firstimage	대표이미지(원본)
private String firstimage2;//	firstimage2	대표이미지(썸네일)
private String mapx;//	mapx	GPS X좌표
private String mapy;//	mapy	GPS Y좌표
private Long mlevel;//	mlevel	Map Level
private String tel;//	tel	전화번호
private String title;//	title	제목
private Long modifiedtime;//modifiedtime	수정일
private Long readcount;//readcount	조회수
private Long pageNo;//pageNo 페이지 번호
//	zipcode	우편번호


}
