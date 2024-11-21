## 🧙‍♂️ 로컬에서 실행하기

1. 아래 명령어를 통해서 MySQL을 실행합니다. (Docker 필요)

```shell
docker compose up -d
```

2. DDL, DML 실행

Flyway를 사용하여, 스키마와 초기 데이터는 자동으로 생성됩니다.

3. 서버 실행

IntelliJ를 통해서 실행하거나 gradlew 명령어를 통해서 실행합니다.<br>
`5000`포트에서 서버는 실행됩니다.

```shell
gradlew bootRun
```

<br>

## 🖥️ API 명세

`/swagger-ui/index.html`에서 확인할 수 있습니다.