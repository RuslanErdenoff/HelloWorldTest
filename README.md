# HelloWorldTest
Getting value("Hello world") from DB and showing this one in Browser. Also you can change this value on yours.

# Тестовое задание Hello World
###План запуска программы:
1. Запустите сервер Derby DB. Добавьте БД "sample" в дерикторию "bin".
2. Запустите сервер Tomcat. Добавьте прилежение "WebApp" в дерикторию "webapps".
3. Перейдите на сайте "http://localhost:8080/WebApp/MyUrl".
4. Вы увидите в первой строке, что в данный момент находится в БД.В БД находится один столбец с одной строкой. Для изменения значения в БД введите в поле свое значение. После этого значение в БД изменится и на экран будет показан вывод из БД.

###Компиляция программы:
1. Через консоль войти в папку "Poject".
2. Запустите команду:
```
  mvn compile
```
###URL БД:
1.jdbc:derby://localhost:1527/sample;create=true
2.Пользователь:user
3.Пароль:111
