package location.tour.tourlist.model;

import lombok.Data;

@Data
public class TourDTO {
private Long contentid;//	contentid	콘텐츠ID
private Long contenttypeid;//	contenttypeid	콘텐츠타입ID
//관광지 12
//	accomcount	수용인원
//	chkbabycarriage	유모차대여 정보
//	chkcreditcard	신용카드가능 정보
//	chkpet	애완동물동반가능 정보
//	expagerange	체험가능 연령
private String expguide;//	expguide	체험안내
//	heritage1	세계 문화유산 유무
//	heritage2	세계 자연유산 유무
//	heritage3	세계 기록유산 유무
private String infocenter;//	infocenter	문의 및 안내
private String opendate;//	opendate	개장일
private String parking;//	parking	주차시설
private String restdate;//	restdate	쉬는날
private String useseason;//	useseason	이용시기
private String usetime;//	usetime	이용시간
//문화시설 14
//	accomcountculture	수용인원
//	chkbabycarriage
//	culture	유모차대여 정보
//	chkcreditcardculture	신용카드가능 정보
//	chkpetculture	애완동물동반가능 정보
//	discountinfo	할인정보
private String infocenterculture;//	infocenterculture	문의 및 안내
private String parkingculture;//	parkingculture	주차시설
//	parkingfee	주차요금
private String restdateculture;//	restdateculture	쉬는날
private String userfee;//	usefee	이용요금
private String usetimeculture;//	usetimeculture	이용시간
//	scale	규모
private String spendtime;//	spendtime	관람 소요시간
//행사/공연/축제 15
private String agelimit;//	agelimit	관람 가능연령
private String bookingplace;//	bookingplace	예매처
//	discountinfofestival	할인정보
private Long eventenddate;//	eventenddate	행사 종료일
private String eventhomepage;//	eventhomepage	행사 홈페이지
private String eventplace;//	eventplace	행사 장소
private Long eventstartdate;//	eventstartdate	행사 시작일
//	festivalgrade	축제등급
private String placeinfo;//	placeinfo	행사장 위치안내
private String playtime;//	playtime	공연시간
private String program;//	program	행사 프로그램
private String spendtimefestival;//	spendtimefestival	관람 소요시간

//	sponsor1	주최자 정보
//	sponsor1tel	주최자 연락처
//	sponsor2	주관사 정보
//	sponsor2tel	주관사 연락처
//	subevent	부대행사
private String usetimefestival;//	usetimefestival	이용요금
//여행코스 25
private String distance;//	distance	코스 총거리
private String infocentertourcourse;//	infocentertourcourse	문의 및 안내
private String schedule;//	schedule	코스 일정
private String taketime;//	taketime	코스 총 소요시간
private String theme;//	theme	코스 테마
//레포츠 28
//	accomcountleports	수용인원
//	chkbabycarriageleports	유모차대여 정보
//	chkcreditcardleports	신용카드가능 정보
//	chkpetleports	애완동물동반가능 정보
private String expagerangeleports;//	expagerangeleports	체험 가능연령
private String infocenterleports;//	infocenterleports	문의 및 안내
private String openperiod;//	openperiod	개장기간
//	parkingfeeleports	주차요금
private String parkingleports;//	parkingleports	주차시설
private String reservation;//	reservation	예약안내
private String restdateleports;//	restdateleports	쉬는날
//	scaleleports	규모
private String usefeeleports;//	usefeeleports	입장료
private String usetimeleports;//	usetimeleports	이용시간
//숙박 32
private String accomcountlodging;//	accomcountlodging	수용 가능인원
//	benikia	베니키아 여부
private String checkintime;//	checkintime	입실 시간
private String checkouttime;//	checkouttime	퇴실 시간
private String chkcooking;//	chkcooking	객실내 취사 여부
//	foodplace	식음료장
//	goodstay	굿스테이 여부
//	hanok	한옥 여부
private String infocenterlodging;//	infocenterlodging	문의 및 안내
private String parkinglodging;//	parkinglodging	주차시설
private String pickup;//	pickup	픽업 서비스
private String roomcount;//	roomcount	객실수
private String reservationlodging;//	reservationlodging	예약안내
private String reservationurl;//	reservationurl	예약안내 홈페이지
private String roomtype;//	roomtype	객실유형
private String scalelodging;//	scalelodging	규모
//	subfacility	부대시설 (기타)
//	barbecue	바비큐장 여부
//	beauty	뷰티시설 정보
//	beverage	식음료장 여부
//	bicycle	자전거 대여 여부
//	campfire	캠프파이어 여부
//	fitness	휘트니스 센터 여부
//	karaoke	노래방 여부
//	publicbath	공용 샤워실 여부
//	publicpc	공용 PC실 여부
//	sauna	사우나실 여부
//	seminar	세미나실 여부
//	sports	스포츠 시설 여부
private String refundregulation;//	refundregulation	환불규정
//쇼핑 38
//	chkbabycarriageshopping	유모차대여 정보
//	chkcreditcard
//	shopping	신용카드가능 정보
//	chkpetshopping	애완동물동반가능 정보
//	culturecenter	문화센터 바로가기
private String fairday;//	fairday	장서는 날
private String infocentershopping;//	infocentershopping	문의 및 안내
private String opendateshopping;//	opendateshopping	개장일
private String opentime;//	opentime	영업시간
private String parkingshopping;//	parkingshopping	주차시설
private String restdateshopping;//	restdateshopping	쉬는날
//	restroom	화장실 설명
private String saleitem;//	saleitem	판매 품목
//	saleitemcost	판매 품목별 가격
//	scaleshopping	규모
private String shopguide;//	shopguide	매장안내
//음식점 39
//	chkcreditcardfood	신용카드가능 정보
//	discountinfofood	할인정보
private String firstmenu;//	firstmenu	대표 메뉴
private String infocenterfood;//	infocenterfood	문의 및 안내
//	kidsfacility	어린이 놀이방 여부
private String opendatefood;//	opendatefood	개업일
private String opentimefood;//	opentimefood	영업시간
//	packing	포장 가능
//	parkingfood	주차시설
//	reservationfood	예약안내
private String restdatefood;//	restdatefood	쉬는날
//	scalefood	규모
//	seat	좌석수
//	smoking	금연/흡연 여부
private String treatmenu;//	treatmenu	취급 메뉴

}
