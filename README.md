# fte-javaTPU2
 Итоговая работа по результатам 7-го семестра (Java Spring) ТПУ
# Краткое описание проекта
 Проект представляет из себя базу компьютерных игр, и имеет следующие сущности:
 1. **Game** - содержит в себе основную информацию об игре;
 2. **Developer** - вспомогательный класс для Game с информацией о разработчике;
 3. **Publisher** - вспомогательный класс для Game с информацией об издателе;
 4. **Country** - вспомогательный класс для Developer / Publisher с информацией о стране;
 5. **Genre** - вспомогательный класс для Game с информацией о жанре;
 6. **User** - класс пользователей для реализации регистрации;
 7. **Roles** - класс с ролями пользователей.
 
 Все представленные сущности доступны в Swagger UI проекта, для них реализованы CRUD операции и имеются поясняющие комментарии. Для обеспечения безопасности используется spring-security с методом базовой аутенфиакции (предоставление логина и пароля при отправке запроса).
 
 Обычный пользователь с ролью ROLE_USER имеет права только на GET запросы, пользователь с правами администратора ROLE_ADMIN имеет доступ к полному CRUD функционалу.
 
# Для запуска необходимо
 1. Java Development Kit (JDK) 19;
 2. PostgreSQL 15;
 3. Поменять настройки СУБД в файле application.properties на свои (пример данных оставлен в файле).
# Инструкция по использованию
 1. Запустите проект (например в среде IntelliJ IDEA);
 2. Выполните предзаданный для примера SQL код из файла dbData.sql или задайте свои данные;
 3. Через post запрос по адресу /protected/register зарегистрируйте пользователей;
 
   Пример регистрации пользователя:
   
     POST http://localhost:8080/protected/register
     Content-Type: application/json

     {
       "username": "foo",
       "password": "bar"
     }
 4. При желании, вручную выдайте пользователю права администратора по аналогии с последней строкой файла dbData.sql;
 5. Перейдите в Swagger UI проекта по адресу http://localhost:8080/swagger-ui.html;
 6. Авторизуйте своего пользователя и совершайте необходимые запросы.
 
 Пример запроса без Swagger UI (добавление нового жанра игры):
 
    POST http://localhost:8080/api/genre
    Authorization: Basic foo bar
    Content-Type: application/json

    {
      "id": 100,
      "name": "foo",
      "description": "bar"
    }
    
# Контакты разработчика
  - Фадеев Тимофей tg: @f4vir0
 
