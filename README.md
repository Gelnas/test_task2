Для того чтобы запустить приложение необходимо развернуть базу данных Postgres под названием stat
Добавить таблицу в БД
>>
CREATE TABLE IF NOT EXISTS words
(
    id          bigserial          PRIMARY KEY,
    word        varchar(128)       NOT NULL,
    count       smallint           NOT NULL
);
>>
Далее открыть проект через IDE
И запустить программу

______________________________________________

Проект содержит 5 классов:
>> Main - основной класс))
Класс содержит следующие методы:
  >> download(String urlToSave, String directory) - метод для скачивания HTML страницы;

>> Const - класс констант;  

>> Conn - класс для подключения к базе данных
  Класс содержит следующие методы:
  >> dbconnect() - метод для подключения к БД;

>> HTMLParser - класс для парсинга HTML файла и разбиения его на слова;
  Класс содержит следующие методы:
  >> getContent() - метод, возвращающий массив слов из скачанной страницы;

>> WDB - класс для заполнения базы данными о количестве уникальных слов и их вывода на экран
 Класс содержит следующие методы:
  >> processing() - метод заполняющий БД данными о количестве уникальных слов

  >> printData() - метод, выводящий данные о количестве слов на экран
