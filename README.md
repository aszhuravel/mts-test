# mts-test

Простой REST сервис имитирующий очередь заданий.

# Использование

Создание задание
```sh
curl -XPOST https://nameless-fortress-97641.herokuapp.com/task/

{"value":"7bd5e54e-0bc2-4d1d-ab5f-b48e00af5c20"}
```

Получение статуса 
```sh
curl -XGET https://nameless-fortress-97641.herokuapp.com/task/7bd5e54e-0bc2-4d1d-ab5f-b48e00af5c20

{"state":"RUNNING","updated":"2018-10-15T17:52:38.972Z"}
```
