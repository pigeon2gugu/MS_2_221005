### 221030
전반적인 refactoring과 로그인 닉네임 바꾸기 기능 추가

1. domain - UserMainInfo  
  회원 정보를 담는 dto  
2. Service - UserAdminService  
  회원가입, 회원탈퇴, 로그인, 닉네임변경  
3. dao - UserDao  
  db에 유저정보를 add하고 delete하는 method, 원하는 field의 정보를 바꾸는 modify method, 중복 값을 찾는 check method, id로 select하는 method  
4. test - UserDaoTest  
  add, delete, 중복 check 테스트  
5. test - UserAdminServiceTest
  회원가입 Test : id, 이메일, 닉네임 중복, 비밀번호 오류 테스트  
  로그인 : 로그인 성공, 실패 테스트  
  닉네임 변경 : 닉네임 변경, 닉네임 현재와 같을 때 테스트

[문제]  
1. 로그인 시 UserMainInfo에 null이 담기는 상황 -> 닉네임 변경이나 추후 게시물 작성 시 null일때 실행되지 않게 하면 해결 (?)  

[궁금점]  
1. aws와 연결 시, jdbcTemplate 사용과, 그 안에서 new Datasource()를 해주는 방법과, yml세팅과 환경변수 세팅의 차이점을 아직 잘 모르겠음.  
2. 중복 check method는 UserDao? UserAdminService?  
3. 로그인 시 UserMainInfo는 어디에 저장되는가?  
4. 로그인 시 저장하는 유저정보는 UserMainInfo object로 들고있는 것이 나을지 아니면 id만 들고다니고 필요시 db에서 호출해서 쓰는 방법이 나을지  
5. 로그인 시 UserMainInfo return방식이 맞을까... null일때의 상황
6. 닉네임 변경 시, 로그인한 유저 정보갱신을 UserMainInfo object를 새롭게 설정하는게 나을지... 혹은 sql등록 후 다시 db에서 불러오는게 나을지  

[느낀점]    
1. string 같음을 비교할 때 == vs .equals() 잘 써야 할 것 같다...  
2. 웹에 올릴 때 어떻게 적용 될지 아직 상상이 잘 안된다...  
3. pom.xml을 잘 확인하자... (중복 되는 것이 들어가잇는지...)  
  
### 221030

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

[궁금점]
1. method를 알맞게 짰는지..  
  더 세부적으로 짜야 하는지... (ex 회원가입 시 사용한 조건문들을 method로 분리)  
  혹은 너무 많이 만들었는지 (다른 method에서 호출 형식이 아니라, method내에서 코드 작성 후 실행)  

2. class분류가 알맞는지...  
  UserAdmin에 users table에 접근하는 모든 method를 포함해도 되는 것인지...  
  controller는 기능 별로 모두 분류하는게 맞는지... 회원가입, 회원탈퇴, 로그인, 게시글작성... 이것들이 controller에 들어가는게 맞는지...  

[느낀점]  
1. method을 한꺼번에 짜놓지 말고, 테스트 하면서 짜놓자... 지금 에러나서 하나도 완성 된게 없다...  
2. test는 차근차근 하자... 회원가입 test부터 만들지 말고, 먼저 database에 add되는지 부터 체크하는게 맞다...  
