<<<<<<< HEAD
# 동의대학교 컴퓨터소프트웨어공학 이종민 교수님의 객체지향프로그래밍II 팀 프로젝트 HMS(Hotel Management System)

문자열 처리: 가능하면 문자열을 무작정 붙이지 말고 String.format을 사용할 것.

단일 책임 원리 (SRP): 클래스나 메소드는 단일 책임 원리를 준수하여 하나의 기능만을 담당할 것.

주석 작성: 주석은 자바독 (javadoc) 스타일로 가능한 자주 작성할 것.

개행 문자: 개행 문자로는 \n 보다는 %n을 사용할 것.

랜덤 수 생성: 랜덤 수 생성에는 java.util.Random().nextInt()를 사용할 것.

입력 처리: 입력 처리에는 Scanner 대신 Buffered Reader를 사용할 것.

변수 초기화: 변수를 정의할 때 동시에 값을 대입해 초기화하는 것이 좋음.

타입 캐스팅: 타입 캐스팅은 되도록 하지 말 것.

명명 규칙: 클래스, 변수, 메소드 명은 Camel Case를 사용할 것.

접근 제어자: 접근 제어자를 암시적으로 하지 말고 명시적으로 설정할 것.

boolean 데이터: boolean 데이터의 getter 메소드 명은 get 대신 is를 사용할 것.

언더바 (_): 가능하면 변수 명에 언더바 (_)를 사용하지 않도록 할 것.

인스턴스 변수: 인스턴스 변수는 private로 선언하고, public의 getter와 setter 메소드를 통해 접근할 것.

클래스: 인스턴스 변수, 생성자, get/set, 메서드 순으로 작성할 것.

상수보단 변수를 사용할 것. (유지보수에 유리)

ArrayList<T> myList = new ArrayList<>(): 타입을 앞 부분에 명시한 경우 뒷 부분에 추가적인 명시를 하지 말 것.
=======
<h1>동의대학교 컴퓨터소프트웨어공학 이종민 교수님의 객체지향프로그래밍II 팀 프로젝트 HMS(Hotel Management System)</h1>

<b>Useful Links: </br>

- Netbean IDE 와 MySql 연동하는법(Add Dependencies)<br>
https://www.youtube.com/watch?v=7LkB5p-HzTo<br>
- Mysql DB export/import 하는법 (with Cli)
  - Export DB
    ```sql
      mysqldump -u(MySqlID) -p(MySqlPw) (export할 DB 선택) > (export될 sql파일 이름).sql
    ```
  - Import DB

    1. Sql 로그인
    ```terminal
      mysql -u(MySqlID) -p(MySqlPw)
    ```

    2. 새 DB생성
    ```sql
      create database [데이터베이스 이름]
      Use [데이터베이스 이름]
    ```
    3. Sql 파일 import
    ```sql
      source (sql파일경로)/(sql파일이름).sql
    ``` 
  


>>>>>>> 3bc22f229f37a8d4ee6d32b11a653dce1ab6f06b
