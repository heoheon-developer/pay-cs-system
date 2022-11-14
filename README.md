# pay-cs-system

고객 문의 접수 및 답변 기능 개발

## 프로젝트 구성

- Spring boot V2.7.0
- Gradle
- Spring Data JPA
- Spring Web MVC

## Vue

- Vue
- Vuex
- Vue-Router
- Axios
- vuetify

# 프로젝트 실행 방법

-Spring boot : /src/main/CsSystemApplication.java 실행

- vue : /src/frontend 이동후 아래 명령 실행

  - npm install
  - npm run dev

- mysql : docker/ 폴더로 이동 아래 명령 실행
  - sudo docker-compose up -d

# 문제 해결 전략

- github issue로 요구사항 정리 및 프로젝트 일정 관리
- usecase 다이어그램을 만들어 요구사항 간략화
- ERD을 만들어 도메인 추출

# 완성 부분

- 글작성, 글목록, 인증, 글상세보기

# 미완성

- 상담사 답변, 상담사 지정
