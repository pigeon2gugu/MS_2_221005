<멋사 2기 221005 배운 내용 간단 요약>

*Git
형상 관리 도구. 소스 코드의 수정과정을 관리 할 수 있음.
SVN : 중앙 집중식. Git : 분산형.

*git bash(Windows 기준)
리눅스 환경 구현한 것.

git clone
remote repository -> local repository 로 가져옴.
local repository : 내 pc. 혹은 서버. clone 명령어를 실행하는 쪽.
remote repository : 인터넷 상의 repository ex) Github, Bitbucked, AWS ~~~

git hub에서 원하는 파일 클릭 후 주소 복사 후 git bash에 git clone 주소 치면 됨.
ex) git clone https://github.com/Kyeongrok/like-lion-java

git push
remote repository -> local repository 로 업로드.
remote repository 생성 : 
github에서 오른쪽상단 your repository -> new 로 생성
그 후 sourcetree에서 상단 저장소->원격 저장소 추가->추가에 github에 등록한 repository의 주소를 붙여넣음
sourcetree 에서 위에 등록한 remote repository로 push누르기. 리모트브렌치를 main으로 설정해야 복잡하지 않음.

git bash에서도 push 가능


*sourcetree
git 명령어들을 gui로 구현해주는 것. (push, pull, clone ...)
local repository생성 후 터미널 -> git status 할 때 on branch master 나오면 잘 생성 된 것
터미널에서 ls -a 에서 .git 이어야지 local repository이다.
스테이지에 올라가지 않은 파일에 + 누르면 스테이지로 올라감. => git add
그 후 하단에 내용 메세지 남긴 후 커밋 누르면 커밋됨.
(gitignore와 .java파일만 올리면 됨. 이외의 것들은 오른쪽 클릭후 무시에서 같은 확장자 무시(.iml)나 이하 모든걸 무시(.idea) 를 하면 됨)
gitignore에는 *.iml .idea/ out/ 만 포함되면 됨


*알고리즘
화폐금액을 입력했을 때 화폐 권수 구하기
짝수홀수 구분

메소드 추상화 : 중복되는것을 메소드로

**Git bash 명령어
dir, ls
현재 디렉토리 내 파일 혹은 폴더 확인. 

mkdir xxx : xxx directory 생성

cd xxx
xxx directory로 이동

shift+insert
붙여넣기

**intellij 단축키
alt + 1 : project exploror 열고 닫기
alt + shift +f10 : 코드 실행
alt + j : 블럭 드래그 한 후 누르면 동일 내용을 수정 가능
