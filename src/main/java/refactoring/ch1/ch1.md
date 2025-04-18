# Chapter 01. 리팩터링: 첫 번째 예시

### 요약

- 리팩터링
  - 소프트웨어의 외부 동작(기능)은 유지하면서, 내부 구조를 개선하는 작업.
  - 코드를 더 읽기 쉽고, 변경과 확장에 용이하도록 만든다.
  - 잘못 설계된 구조는 변경이나 새로운 기능 추가가 어렵고, 이런 경우 리팩터링을 통해 구조를 개선한 뒤 기능 변경/추가를 하는 것이 효율적이다.
- 리팩터링 과정
  - 테스트 코드 작성: 리팩터링 전에 테스트 코드를 작성하여 리팩터링 과정에서 수시로 코드를 검증할 수 있도록 한다.
  - 작은 단계로 나누기: 리팩터링을 여러 작은 단계를 거쳐 진행한다.
  - 버전 관리: 각 단계가 끝날 때마다 **컴파일 -> 테스트 -> 커밋**을 실행하며 코드를 검증한다.
- 1장 예제에서 사용하는 리팩터링 기법들
  - 2장 이후 소개될 여러 리팩터링 기법들을 1장 예제에서 먼저 사용해보기 위한 예제이다.
  - 함수 추출하기, 변수 인라인하기, 함수 옮기기, 조건부 로직을 다형성으로 바꾸기, 단계 쪼개기, 반복문 쪼개기, 임시 변수를 질의 함수로 바꾸기 등등

### 왜 enrichPerformance()로 얕은 복사할 필요가 있는가? with ChatGPT (p.55)

- `enrichPerformance()`에서는 얕은 복사(Shallow Copy)를 수행하여 Performance 객체의 필드 값만 복사한다.
- 원본 데이터를 보호:
  - `invoice.performances`는 원본 데이터이므로, 직접 수정하면 원치 않는 부작용(side effect)이 발생할 수 있습니다.
  - `enrichPerformance()`를 통해 복사본을 사용하면, 원본 데이터는 변경되지 않습니다.
- 확장성 제공:
  - 복사된 Performance 객체에 새로운 속성을 추가하거나, 특정 로직을 적용할 수 있습니다.
  - 예를 들어, Performance 객체에 계산된 값을 추가하거나, 포맷팅된 데이터를 포함할 수 있습니다.
- 객체 지향 원칙 준수:
  - 데이터와 로직을 분리하여, Performance 객체가 명확한 책임을 가지도록 합니다.
