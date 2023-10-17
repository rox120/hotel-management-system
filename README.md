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
  


