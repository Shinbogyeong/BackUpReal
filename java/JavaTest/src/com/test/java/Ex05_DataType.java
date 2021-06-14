package com.test.java;

public class Ex05_DataType {
	
	public static void main(String[] args) {
		//1. 9개 자료형
		//2. 주변의 데이터 선택
		//3. 자료형 선택 + 변수 생성 + 데이터 대입 + 화면 출력
		//4. 각 자료형 * 10개
		
		//byte
		System.out.println("byte 자료형입니다.");
		System.out.println();
		
		byte mathScore;
		mathScore = 100;
		System.out.println("수학점수는 " + mathScore +"점 입니다.");
		
		byte computerNum;
		computerNum = 2;
		System.out.println("컴퓨터의 갯수는 " + computerNum +"개 입니다.");
		
		byte roomNum;
		roomNum = 14;
		System.out.println("우리 숙소의 호수는 " + roomNum + "호 입니다.");
		
		byte familyNum;
		familyNum = 4;
		System.out.println("우리 가족 수는 " + familyNum +"명 입니다.");
		
		byte nameStroke;
		nameStroke = 17;
		System.out.println("내 이름의 획수는 " + nameStroke +"번 입니다.");
		
		byte SeoulDistrict;
		SeoulDistrict = 25;
		System.out.println("서울시내의 구 갯수는 " + SeoulDistrict + "개 입니다.");
		
		byte myAge;
		myAge = 25;
		System.out.println("내 나이는 " + myAge + "살 입니다.");
		
		byte month;
		month = 3;
		System.out.println("이번달은 " + month + "월 입니다.");
				
		byte date;
		date = 31;
		System.out.println("오늘은 " + date + "일 입니다.");
		
		byte waistSize;
		waistSize = 21;
		System.out.println("내 허리사이즈는 " + waistSize + "인치 입니다.");
		
		System.out.println();
		
		
		//short
		System.out.println("short 자료형입니다.");
		System.out.println();
				
		System.out.println(Short.MAX_VALUE);//32767
		
		short nationNum;
		nationNum = 259;
		System.out.println("전 세계 국가의 수는 " + nationNum + "개 입니다.");
		
		short studentNum;
		studentNum = 300;
		System.out.println("우리 학교의 학생 수는 " + studentNum + "명 입니다.");
		
		short shoesSize;
		shoesSize = 280;
		System.out.println("나의 신발 크기는 " + shoesSize + "입니다.");
		
		short maleCalorie;
		maleCalorie = 2700;
		System.out.println("남성 하루 권장 칼로리는 " + maleCalorie +"칼로리 입니다.");
		
		short femaleCalorie;
		femaleCalorie = 2000;
		System.out.println("여성 하루 권장 칼로리는 " + femaleCalorie + "칼로리 입니다.");
		
		short year;
		year = 2021;
		System.out.println("올해는 " + year + "년 입니다.");
		
		short highSchool;
		highSchool = 1341;
		System.out.println("서울시 내의 고등학교 수는 " + highSchool + "개 입니다.");
		
		short bookNum;
		bookNum = 232;
		System.out.println("책 번호는 " + bookNum + "번 입니다.");
		
		short carCode;
		carCode = 302;
		System.out.println("나의 차 코드는 " + carCode + "번 입니다.");
		
		short middleSchool;
		middleSchool = 3212;
		System.out.println("서울시 내의 중학교 수는 " + middleSchool + "개 입니다.");
	
		
		System.out.println();
		
		
		//int
		System.out.println("int 자료형입니다.");
		System.out.println();
		
		
		System.out.println("int의 갯수는" + Integer.MAX_VALUE +"개입니다.");//2147483647
		
		int populationKor;
		populationKor = 51821966;
		System.out.println("우리나라 인구 수는 " + populationKor + "명 입니다.");
	
		int populationUSA;
		populationUSA = 300000000;
		System.out.println("미국 인구 수는 " + populationUSA + "명 입니다.");
		
		int populationUK;
		populationUK = 68207114;
		System.out.println("영국 인구 수는 " + populationUK + "명 입니다.");
		
		
		int populationChi;
		populationChi = 1444216102;
		System.out.println("중국 인구 수는 " + populationChi + "명 입니다.");
		
		
		int populationCan;
		populationCan = 38067913;
		System.out.println("캐나다 인구 수는 " + populationCan + "명 입니다.");
		
		
		int populationJap;
		populationJap = 12605796;
		System.out.println("일본 인구 수는 " + populationJap + "명 입니다.");
		
		
		int populationRus;
		populationRus = 145912022;
		System.out.println("러시아 인구 수는 " + populationRus + "명 입니다.");
		
		
		int covidPatientNum;
		covidPatientNum = 127587603;
		System.out.println("전세계 코로나 확진자 수는 " + covidPatientNum + "명 입니다.");
		
		int covidDeathNum;
		covidDeathNum = 341731;
		System.out.println("전세계 코로나 사망자 수는 " + covidDeathNum + "명 입니다.");
		
		int isolatedNum;
		isolatedNum = 454634603;
		System.out.println("전세계 코로나 격리자 수는 " + isolatedNum + "명 입니다.");
		
		System.out.println();
		
		
		
		//long
		System.out.println("long 자료형입니다.");
		System.out.println();
		
		long cellNum;
		cellNum = 3000000000000L;
		System.out.println("체 내 세포 수는 " + cellNum + "개 입니다.");
		
		long bacteriaNum;
		bacteriaNum = 3900000000000L;
		System.out.println("체 내 박테리아의 수는 " + bacteriaNum + "개 입니다.");
			
		long investmentAmount;
		investmentAmount = 1000000000000000000L;
		System.out.println("이 회사의 투자 금액은 " + investmentAmount + "원 입니다.");
		
		long streamingNum;
		streamingNum = 90000008795600L;
		System.out.println("이 곡의 스트리밍 횟수는 " + streamingNum + "번 입니다.");
		
		long elementaryStudent;
		elementaryStudent = 3330003L;
		System.out.println("초등학생 수는 " + elementaryStudent + "명 입니다.");
		
		long middleStudent;
		middleStudent = 945643543L;
		System.out.println("중학생 수는 " + middleStudent + "명 입니다.");
		
		long highStudent;
		highStudent= 50434530L;
		System.out.println("고등학생 수는 " + highStudent + "명 입니다.");
		
		long universityStudent;
		universityStudent = 9456452340L;
		System.out.println("대학생 수는 " + universityStudent + "명 입니다.");
		
		long collegeStudent;
		collegeStudent= 1435658795600L;
		System.out.println("전문대학교 수는 " + collegeStudent + "명 입니다.");
		
		long foreingerNum;
		foreingerNum= 6534325456454345L;
		System.out.println("국내 외국인 거주자는 " + foreingerNum + "명 입니다.");
		
		System.out.println();
		
		
		
		//float
		System.out.println("float 자료형입니다.");
		System.out.println();
		
		
		float sight;
		sight = 3.2F;
		System.out.println("나의 시력은 " + sight + "입니다.");
		
		float antSize;
		antSize = 1.255F;
		System.out.println("개미의 크기는 " + antSize + "cm입니다.");
		
		float crackSize;
		crackSize = 12.245F;
		System.out.println("벌어진 틈의 크기는 " + crackSize + "cm입니다.");
		
		float height;
		height = 150.2F;
		System.out.println("내 키는 " + height + "cm입니다.");
		
		float pi;
		pi = 3.141592F;
		System.out.println("원주율의 크기는 " + pi +"입니다.");
		
		float jumpScore;
		jumpScore = 220.3322F;
		System.out.println("높이뛰기 세계 최고기록은 " + jumpScore +"m입니다.");
		
		float jetSpeed;
		jetSpeed = 3.274F;
		System.out.println("제트기의 속도는 " + jetSpeed +"마하입니다.");
		
		float airplaneSpeed;
		airplaneSpeed = 1.23F;
		System.out.println("비행기의 속도는 " + airplaneSpeed +"마하입니다.");
		
		float missileSpeed;
		missileSpeed = 8.2354F;
		System.out.println("미사일의 속도는 " + missileSpeed +"마하입니다.");
		
		float UsainSpeed;
		UsainSpeed = 37.5F;
		System.out.println("우시안볼트의 기록은 시속 " + UsainSpeed +"km입니다.");
		
		System.out.println();
		
		
				
		
		//double
		System.out.println("doduble 자료형입니다.");
		System.out.println();
		
		
		double in;
		in = 0.393701;
		System.out.println("1cm는 "+ in + "인치 입니다.");
		
		double m;
		m = 0.01;
		System.out.println("1cm는 "+ m + "m 입니다.");
		
		double km;
		km = 0.00001;
		System.out.println("1cm는 "+ km + "km 입니다.");
		
		double ft;
		ft = 0.032808;
		System.out.println("1cm는 "+ ft + "피트 입니다.");
		
		double yd;
		yd = 0.010936;
		System.out.println("1cm는 "+ yd + "야드 입니다.");
		
		double ja;
		ja = 0.033;
		System.out.println("1cm는 "+ ja + "자 입니다.");
		
		double gan;
		gan = 0.0055;
		System.out.println("1cm는 "+ gan + "간 입니다.");
		
		double jung;
		jung = 0.000092;
		System.out.println("1cm는 "+ jung + "정 입니다.");

		double ree;
		ree = 0.000025;
		System.out.println("1cm는 "+ ree + "리 입니다.");
		
		double mm;
		mm = 10;
		System.out.println("1cm는 "+ mm + "mm 입니다.");
		
		System.out.println();
		
		
		
		
		//char
		System.out.println("char 자료형입니다.");
		System.out.println();
		
		
		char grade;
		grade = 'A';
		System.out.println("나의 학점은" + grade + "학점 입니다.");
		
		char classNum;
		classNum = 'C';
		System.out.println("수업하는 강의실은" + classNum + "반 입니다.");
		
		char mathGrade;
		mathGrade = '2';
		System.out.println("수학등급은 " + mathGrade + "등급 입니다.");
		
		char engGrade;
		engGrade = '1';
		System.out.println("영어등급은 " + engGrade + "등급 입니다.");
		
		char korGrade;
		korGrade = '3';
		System.out.println("국어등급은 " + korGrade + "등급 입니다.");
		
		char hisGrade;
		hisGrade = '1';
		System.out.println("한국사등급은 " + hisGrade + "등급 입니다.");
		
		char scienceGrade;
		scienceGrade = '2';
		System.out.println("과학등급은 " + scienceGrade + "등급 입니다.");
		
		char societyGrade;
		societyGrade = '1';
		System.out.println("사회등급은 " + societyGrade + "등급 입니다.");
		
		char freshness;
		freshness = 'A';
		System.out.println("신선도는 " + freshness + "급 입니다.");
		
		char dressQuality;
		dressQuality = 'B';
		System.out.println("드레스의 퀄리티는 " + dressQuality + "급 입니다.");
		
		System.out.println();
		
		
		
		
		//boolean
		System.out.println("boolean 자료형입니다.");
		System.out.println();
		
		
		boolean answer1 = false;
		System.out.printf("1+1=0 라는 식은 %b이다.\n",answer1);
	
		boolean answer2 = true;
		System.out.printf("1+1=2 라는 식은 %b이다.\n",answer2);
		
		boolean answer3 = true;
		System.out.printf("10/1=10 라는 식은 %b이다.\n",answer3);
		
		boolean answer4 = true;
		System.out.printf("3+2=5 라는 식은 %b이다.\n",answer4);
		
		boolean answer5 = false;
		System.out.printf("1+1=8 라는 식은 %b이다.\n",answer5);
		
		boolean answer6 = false;
		System.out.printf("3+4=0 라는 식은 %b이다.\n",answer6);
		
		boolean answer7 = true;
		System.out.printf("1+1=2 라는 식은 %b이다.\n",answer7);
		
		boolean answer8 = true;
		System.out.printf("123-23=100 라는 식은 %b이다.\n",answer8);
		
		boolean answer9 = false;
		System.out.printf("123-23=1 라는 식은 %b이다.\n",answer9);
		
		boolean answer10 = true;
		System.out.printf("19-19=0 라는 식은 %b이다.\n",answer10);
		
		System.out.println();
		
		
		
		//String
		System.out.println("String 자료형입니다.");
		System.out.println();
		
		
		String academyName;
		academyName = "쌍용";
		System.out.println("교육원 이름은 " + academyName +"교육원입니다.");
		
		String hiKor;
		hiKor = "안녕하세요";
		System.out.println("한국의 인사말은 " + hiKor +"입니다.");
		
		String age;
		age = "스물 다섯살";
		System.out.println("제 나이는 " + age +"입니다.");
		
		String gender;
		gender = "여자";
		System.out.println("제 성별은 " + gender +"입니다.");
		
		String major;
		major = "정보통신공학과";
		System.out.println("제 전공은 " + major +"입니다.");
		
		String favoriteColor;
		favoriteColor = "보라색";
		System.out.println("제가 좋아하는 색깔은 " + favoriteColor +"입니다.");
		
		String bestcellerKyobo;
		bestcellerKyobo = "주택과 세금"; 
		System.out.println("교보문베스트셀러는 " + bestcellerKyobo +"입니다." );

		String bestcellerAladdin;
		bestcellerAladdin = "설레는 건 많을수록 좋아"; 
		System.out.println("알라딘 베스트셀러는 " + bestcellerAladdin +"입니다." );
		
		String bestcellerBandi;
		bestcellerBandi = "부자아빠"; 
		System.out.println("반디앤루니스 베스트셀러는 " + bestcellerBandi +"입니다." );
		
		String bestcellerinter;
		bestcellerinter = "달러구트 꿈 백화점"; 
		System.out.println("인터파크 베스트셀러는 " + bestcellerinter +"입니다." );
		
	}

}
