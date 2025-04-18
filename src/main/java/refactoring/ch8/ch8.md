# Chapter 08. 기능 이동

## 8.1 함수 옮기기

## 8.2 필드 옮기기

## 8.3 문장을 함수로 옮기기

## 8.4 문장을 호출한 곳으로 옮기기

## 8.5 인라인 코드를 함수 호출로 바꾸기

## 8.6 문장 슬라이드하기

## 8.7 반복문 쪼개기

- 반복문을 합친다고 해서 정말 성능이 좋아지는지 의심해봐야 한다.
- 반복문을 쪼개서 데이터베이스 접근이 늘어난다거나 하는게 아니라면(이런게 있을지는 의문이지만), 반복문 쪼개기는 성능 상으로 문제가 되지 않을 것이다.
- 반복문 쪼개기는 Java 1.7 이하 버전의 레거시 코드를 Stream API로 리팩토링할 때 많은 도움이 될 것 같다.

## 8.8 반복문을 파이프라인으로 바꾸기

## 8.9 죽은 코드 제거하기

- 전 직장에서는 어떤 소스를 코딩한 사람이 아닌 다른 개발자가 수정하면 이전 소스는 주석으로 남겨두는 관례가 있었다.
  - 7~8년 전, 신입일 때 교육받았던 내용이고, 퇴사 전까지 점점 없어지는 추세였다.
- 고객의 요구사항이 자주 변경되어서 생겼던 관습으로 보였다.
  - 실제로 도움이 되는 경우가 많긴 했다.
  - 하나의 클래스만 봐도 커밋 히스토리가 수십 건이 쌓이는데, 매 번 뒤져서 원하는 변경내역을 찾기는 쉽지 않은데 그 부분을 쉽게 해결해준다.
- 하지만 버전관리시스템을 믿고 지우는게 좋을 것 같다.
  - 변경내역이 쌓일수록 코드가 지저분해지는 것을 막을 수가 없다.
  - 결국 가독성이 저하되는 문제가 발생한다.
