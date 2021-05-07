# Clone_Instagram

## 소프트스퀘어드 인스타그램 모의외주
- 2주간 서버와의 협업을 통해 개발
- MVP 디자인 패턴 적용
- Retrofit2, OkHttp, Glide, Firebase 등 라이브러리 사용


### Splash
- Splash Activity를 Thread를 통해서 1.5초간 화면에 보여지게 한다.
- SharedPreference에 JWT 값이 저장되어있으면 바로 메인화면으로 넘어가고 그렇지 않으면 로그인 화면으로 넘어감

--------------------------------------

### 로그인
![insta1](https://user-images.githubusercontent.com/67727981/113394842-ea1bb900-93d3-11eb-8d68-c98d247822f7.png)

- 전화번호, 이메일 주소 또는 사용자 이름을 로그인할 때 사용가능
- 비밀번호는 Password Eye를 통해서 문자가 보여지게 할 수 도있고 가릴 수도 있음
- 모든 입력창을 다 입력해야지 로그인 버튼이 활성화됨
- 로그인을 하면 JWT값과 UserId를 SharedPreference에 저장
- Facebook Login (서버에서 API 개발 미완료)

--------------------------------------

### 회원가입
![insta2](https://user-images.githubusercontent.com/67727981/113395217-79c16780-93d4-11eb-8f8e-1e3cea160a9c.png)

- 전화번호 또는 이메일 주소를 사용해서 회원가입 가능
- 사용자 이름, 전화번호, 이메일 주소는 중복 불가능
- 모든 입력창을 입력해야 다음 버튼 활성화

![insta3](https://user-images.githubusercontent.com/67727981/113395876-85f9f480-93d5-11eb-87be-e511ce9df887.png)

- DatePicker를 통해 생년월일 입력

![insta4](https://user-images.githubusercontent.com/67727981/113395891-90b48980-93d5-11eb-87de-dd0a0a4cd197.png)

- 모든 항목이 체크되면 모두 동의란 활성화
- 모든 필수항목을 다 체크해야 버튼 활성화

-----------------------------------------

### 메인화면

![insta7](https://user-images.githubusercontent.com/67727981/113396048-cf4a4400-93d5-11eb-8ec3-45924a8dc4e2.png)

- 홈 탭에서는 팔로우 하고있는 사람들과 본인의 피드들을 모두 조회

![insta12](https://user-images.githubusercontent.com/67727981/113396146-fd2f8880-93d5-11eb-98a5-d43d659fb6f4.png)
![insta28](https://user-images.githubusercontent.com/67727981/113396194-13d5df80-93d6-11eb-93a9-60dbfe397b19.png)

- 해시태그는 파란색으로 표현
- 사진이 여러장일 경우 Indicator로 표시
- 좋아요 및 취소 가능
- 좋아요가 1개 이상일시 몇개의 좋아요를 받았는지 표시
- 좋아요를 누른 사람들의 목록 확인 가능
- 댓글 1개 이상일시 몇개의 댓글이 달렸는지 표시
- 가장 처음에 달린 댓글 표시

![insta13](https://user-images.githubusercontent.com/67727981/113396310-497ac880-93d6-11eb-880b-cda09fa06e86.png)
![insta14](https://user-images.githubusercontent.com/67727981/113396315-4b448c00-93d6-11eb-9399-bf1f5a4f6d3f.png)

- 댓글 모두보기로 진입 시 모든 댓글 
- 댓글 작성 가능
- 길게 누르기를 통해서 해당 댓글 삭제 가능

![insta15](https://user-images.githubusercontent.com/67727981/113396363-631c1000-93d6-11eb-9bf2-62b2a04b3d51.png)
![insta16](https://user-images.githubusercontent.com/67727981/113396369-66af9700-93d6-11eb-8480-36754a77af4d.png)

- 본인이 작성한 피드의 경우 수정 및 삭제 가능한 더보기 창
- 다른 사람이 작성한 피드의 경우 다른 더보기 창, 수정 및 삭제 불가능

![insta18](https://user-images.githubusercontent.com/67727981/113396632-cad25b00-93d6-11eb-897e-ad36dfe53fc3.png)
![insta19](https://user-images.githubusercontent.com/67727981/113396741-fd7c5380-93d6-11eb-8bc8-ab1eb512792f.png)

- 파일과 카메라에 액세스 가능한 권한 허용 시 업로드 화면 진입 가능
- 기기의 갤러리 내에 있는 모든 사진들을 가져와 RecyclerView로 나타냄
- 여러 사진을 선택 가능 및 카메라로 새로운 사진을 찍어서 사용 가능

![insta20](https://user-images.githubusercontent.com/67727981/113396766-0705bb80-93d7-11eb-86f8-669ed3846496.png)

- 선택한 사진들을 보정하는 화면으로 넘어감

![insta22](https://user-images.githubusercontent.com/67727981/113396821-1a188b80-93d7-11eb-864a-3f5c601fefce.png)

- 업로드화면으로 넘어오면 Firebase Storage로 이미지를 업로드
- 게시글을 작성한 후 확인 버튼을 누르면 Firebase Storage에서 해당 이미지들의 Url을 받아와서 서버로 전송

![insta8](https://user-images.githubusercontent.com/67727981/113397047-695ebc00-93d7-11eb-95c3-679787166b79.png)

- Search 화면
- Horizontal ScrollView로 카테고리를 나타냄
- RecyclerView와 라이브러리를 사용하여 각 칸마다 다른 크기를 나타내고 Glide를 통해 비디오(gif) 삽입

![insta9](https://user-images.githubusercontent.com/67727981/113397239-b2167500-93d7-11eb-9a7d-0a4400accd62.png)

- Reels 화면
- Glide를 사용해 Gif파일로 비디오처럼 보이게함
- 원본 오디오라는 텍스트를 marquee를 사용해서 흐르게 표현
- 상태바와 네비게이션 바의 색상을 어둡게해서 화면에 몰입하게함
- Viewpager2를 사용해서 수직으로 스크롤 가능

![insta10](https://user-images.githubusercontent.com/67727981/113397370-dc683280-93d7-11eb-8b18-69c3ba20a538.png)

- Shop 화면
- Horizontal ScrollView를 사용해서 카테고리 표현
- RecyclerView로 더미 데이터 표현

![insta11](https://user-images.githubusercontent.com/67727981/113397424-f99d0100-93d7-11eb-886a-458e0fd3b7f6.png)
![insta24](https://user-images.githubusercontent.com/67727981/113397543-2d782680-93d8-11eb-9792-3ebc441c70b5.png)
![insta25](https://user-images.githubusercontent.com/67727981/113397563-31a44400-93d8-11eb-836a-993a13fc5af5.png)
![insta26](https://user-images.githubusercontent.com/67727981/113397573-34069e00-93d8-11eb-9c53-1b4820bfcb97.png)
![insta32](https://user-images.githubusercontent.com/67727981/113397768-8cd63680-93d8-11eb-832b-8aff37c53c71.png)
![insta27](https://user-images.githubusercontent.com/67727981/113397580-35d06180-93d8-11eb-84ec-2cadec9a7e56.png)
![insta30](https://user-images.githubusercontent.com/67727981/113397587-3963e880-93d8-11eb-9e88-c3f1af83e2b0.png)
![insta31](https://user-images.githubusercontent.com/67727981/113397593-3bc64280-93d8-11eb-89d3-ca164d9c10b5.png)


- Profile 화면
- 마이 페이지 조회 및 프로필 편집란에서 프로필 조회
- 게시글, 팔로워, 팔로우 수 확인 가능
- 다른 사람 프로필 조회 가능 및 팔로우/
- 본인이 작성한 피드들 확인 및 클릭시 피드 상세보기로 진입
- DrawerLayout으로 사이드 메뉴 보이기 가능
- 설정창으로 진입 가능
- 설정창에서 로그아웃 시 SharedPreference에 저장되어있는 JWT와 userId값을 지우고 로그인 창으로 돌아감



