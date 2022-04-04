**_Задача:_**
--


**Часть первая**
--

Написать сервер с двумя сервлетами:
SignUpServlet для обработки запросов на signup и
SignInServlet для обработки запросов на signin.

Сервлеты должны слушать POST запросы с параметрами:

login

password


При получении POST запроса на signup сервлет SignUpServlet должн запомнить логин и пароль в AccountService.
После этого польователь с таким логином считается зарегистрированным.

При получении POST запроса на signin, после регистрации, SignInServlet проверяет,
логин/пароль пользователя.

Если пользователь уже зарегистрирован, север отвечает:

Status code (200)
и текст страницы: "Authorized: login"

если нет:
Status code (401)
текст страницы: "Unauthorized"

**Часть вторая (работа с базой)**
--

Для запоминания пользователя AccountService должен использовать базу данных.
Для теста используйте базу H2 над файлом в той же директории, что и src
  
            String url = "jdbc:h2:./h2db";
            String name = "test";
            String pass = "test";

            JdbcDataSource ds = new JdbcDataSource();
            ds.setURL(url);
            ds.setUser(name);
            ds.setPassword(pass);


Для хранения данных пользователя используйте таблицу users:
create table if not exists users (id bigint auto_increment, login varchar(256), password varchar(256), primary key (id));
Сервер должен создавать таблицу при старте если она не существует.

При получении запроса на signup сервлет должен обратиться к DBService и записать логин и пароль в таблицу.


**_Тестирующая система_**
--
1. Запускает сервер;

2. Присылает на сервер запрос на регистрацию (signup);

3. Перезапускает сервер;

4. Присылает запрос на авторизацию (signin);
