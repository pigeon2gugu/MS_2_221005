221030

게시판을 위한 회원가입과 회원탈퇴 기능

1. UserMainInfo
  MySQL db의 users table에 회원 정보를 등록하기 위한 Entity

2. UserAdmin
  MySQL db의 users table에 데이터 등록하거나 꺼내오는 method를 담고 있는 class
  
3. UserAdminController
  회원가입과 회원탈퇴 method를 담고 있는 class
  
[문제]
  testcode에서 NullPointerException 발생
1. MySQL과의 연결 문제 확인해보기
2. UserAdmin method내의 문제 확인해보기

[리뷰 받고 싶은 부분]
1. method를 알맞게 짰는지.. 
  더 세부적으로 짜야 하는지... (ex 회원가입 시 사용한 조건문들을 method로 분리)
  혹은 너무 많이 만들었는지 (다른 method에서 호출 형식이 아니라, method내에서 코드 작성 후 실행)

2. class분류가 알맞는지... 
  UserAdmin에 users table에 접근하는 모든 method를 포함해도 되는 것인지...
  controller는 기능 별로 모두 분류하는게 맞는지... 회원가입, 회원탈퇴, 로그인, 게시글작성... 이것들이 controller에 들어가는게 맞는지...

[느낀점]
1. method을 한꺼번에 짜놓지 말고, 테스트 하면서 짜놓자... 지금 에러나서 하나도 완성 된게 없다...
2. test는 차근차근 하자... 회원가입 test부터 만들지 말고, 먼저 database에 add되는지 부터 체크하는게 맞다...
