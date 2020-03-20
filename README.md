# JTRP
#крохотный REST сервис (Spring 2, Hibernate, PostrgreSQL)

#Не смог подключить flyway, так что таблицу можно создать таблицу БД через файл "db/migration/V1__Init_DB.sql"

#Заполнить 5 записями через "db/migration/V2__Add_newOrders.sql" в папке Resource

#Тестировалось через Postman

#Команды:

1) Для добавления на нового заказа в БД - отправить POST запрос по адресу http://localhost:8080/orders
2) Для вывода на экран списка всех заказов из БД - отправить GET запрос по адресу http://localhost:8080/orders
3) Для вывода на экран КОНКРЕТНОГО заказа из БД - отправить GET запрос по адресу http://localhost:8080/orders/ID (где ID - номер заказа)
4) Для выборки по датам из БД - отправить GET запрос по адресу http://localhost:8080/orders/dates?from=DATEFROM&to=DATETO (где DATEFROM и DATETO даты между которыми необходимо провести поиск, даты в формате "дд-мм-гггг" ЭТО ВАЖНО)
5) Аналогично с п.4 для выпорки по датам и опционально ИД заказа - отправить GET запрос по адресу http://localhost:8080/orders/dates?from=DATEFROM&to=DATETO&id=ID (где DATEFROM и DATETO аналогичны п.4 + ID - номер заказа)
6) Для изменения данных заказа 
