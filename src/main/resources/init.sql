DROP TABLE IF EXISTS categories;
create table categories
(
    id        serial primary key,
    name      varchar(50)  not null,
    image_name varchar(100) not null
);

alter table categories
    owner to postgres;

INSERT INTO categories (id, name, image_name)
VALUES (1, 'Mobile phones', 'mobile.jpeg');
INSERT INTO categories (id, name, image_name)
VALUES (2, 'Laptops', 'laptop.jpeg');
INSERT INTO categories (id, name, image_name)
VALUES (3, 'GPS Navigators', 'jps_nav.jpeg');
INSERT INTO categories (id, name, image_name)
VALUES (4, 'Fridges', 'fridge.jpeg');
INSERT INTO categories (id, name, image_name)
VALUES (5, 'Cars', 'car.jpeg');
INSERT INTO categories (id, name, image_name)
VALUES (6, 'Cameras', 'camera.jpeg');


drop table if exists users;
create table if not exists users
(
    id       serial primary key,
    name     varchar(45)    not null,
    surname  varchar(45)    not null,
    email    varchar(200)   not null,
    password varchar(50)    not null,
    birthday date           not null,
    balance  numeric(15, 2) not null

);

alter table users
    owner to postgres;

INSERT INTO users (name, surname, email, password, birthday, balance)
VALUES ('Ivan', 'Ivanov', 'admin@tms.by', 'admin123', '11.11.1998', 115500.50),
       ('Petr', 'Petrov', 'petia@tms.by', '1234567', '12.09.1990', 37509.80),
       ('Anna', 'Petrova','admin@mail.ru', 'admin1', '08.06.1990', 57509);


DROP TABLE IF EXISTS products;
create table products
(
    id          serial primary key,
    image_name  varchar(50)    not null,
    name        varchar(100)   not null,
    description varchar(300)   not null,
    price       numeric(10, 2) not null,
    category_id int            not null
);

alter table products
    owner to postgres;

INSERT INTO products (image_name, name, description, price, category_id)
VALUES ('apple.jpeg ', 'Смартфон Apple iPhone 13 128GB (темная ночь) ',
        'Apple iOS, экран 6.1, OLED (1170x2532), Apple A15 Bionic, ОЗУ 4 ГБ, флэш-память 128 ГБ, камера 12 Мп, аккумулятор 3227 мАч, 1 SIM ',
        2600.90, 1),
       ('samsung.jpeg ', 'Смартфон Samsung Galaxy A52 SM-A525F/DS 8GB/256GB (синий) ',
        'Android, экран 6.5, AMOLED (1080x2400), Qualcomm Snapdragon 720G, ОЗУ 8 ГБ, флэш-память 256 ГБ, карты памяти, камера 64 Мп, аккумулятор 4500 мАч, 2 SIM ',
        1200.15, 1),
       ('laptopLenovo.jpeg ', 'Игровой ноутбук Lenovo Legion 5 15ACH6H 82JU00A1PB ',
        '15.6, 1920 x 1080 IPS, 120 Гц, несенсорный, AMD Ryzen 7 5800H 3200 МГц, 16 ГБ DDR4, SSD 512 ГБ, видеокарта NVIDIA GeForce RTX 3060 6 ГБ, Windows 10, цвет крышки темно-синий ',
        5500.34, 2),
       ('laptopAcer.jpeg ', 'Игровой ноутбук Acer Nitro 5 AN515-45-R1A6 NH.QBREP.00B ',
        '15.6, 1920 x 1080 IPS, 144 Гц, несенсорный, AMD Ryzen 5 5600H 3300 МГц, 16 ГБ DDR4, SSD 1024 ГБ, видеокарта NVIDIA GeForce RTX 3070 8 ГБ, Linux, цвет крышки черный ',
        5000.00, 2),
       ('navigatorGeofox.jpeg ', 'GPS навигатор GEOFOX MID502GPS ',
        'экран 5, TFT (800 x 480), ОЗУ 128 Мб, флэш-память 8 Гб, Windows CE 6.0 ', 222.50, 3),
       ('navigatorNavitel.jpeg ', 'GPS навигатор NAVITEL E707 Magnetic ',
        'экран 7, TFT (800 x 480), процессор MStar MSB2531 800 МГц, флэш-память 8 Гб, Linux ', 342, 3),
       ('fridgeBosch.jpeg ', 'Холодильник Bosch Serie 6 VitaFresh Plus KGN39AI32R ',
        'отдельностоящий, полный No Frost, электронное управление, класс A++, полезный объём: 388 л (280 + 108 л), инверторный компрессор, зона свежести, перенавешиваемые двери, складная полка, полка для вина, лоток для яиц, отделка: защита от отпечатков, 60x66x203 см, нержавеющая сталь ',
        2950, 4),
       ('fridgeSamsung.jpeg ', 'Холодильник Samsung RB37A52N0B1/WT ',
        'отдельностоящий, полный No Frost, электронное управление, класс A+, полезный объём: 367 л (269 + 98 л), инверторный компрессор, перенавешиваемые двери, лоток для яиц, 59.5x64.7x201 см, черный ',
        2248, 4),
       ('carVolvo.jpeg ', 'Volvo XC40 ', '1.6 T3 MT Turbo Momentum ', 87832.45, 5),
       ('carTesla.jpeg ', 'Tesla Model X ', 'электрический двигатель, P100D Long Range ', 272107, 5),
       ('cameraCanon.jpeg ', 'Зеркальный фотоаппарат Canon EOS 4000D Kit 18-55mm III ',
        'зеркальная камера, байонет Canon EF-S, матрица APS-C (1.6 crop) 18 Мп, с объективом F3.5-5.6 18-55 мм, Wi-Fi ',
        1449, 6),
       ('cameraNikon.jpeg ', 'Зеркальный фотоаппарат Nikon D5600 Kit 18-55mm AF-P DX VR ',
        'Зеркальный фотоаппарат Nikon D5600 Kit 18-55mm AF-P DX VR ', 2550, 6);

drop table if exists orders;
create table if not exists orders
(
    id        serial primary key,
    date      date   not null,
    price     numeric(10, 2) not null,
    user_id   int            not null
);

alter table orders
    owner to postgres;


drop table if exists orders_products;
create table if not exists orders_products
(
    order_id int not null,
    product_id int not null,
    primary key
(
    order_id,
    product_id
)
    );

alter table orders_products
    add constraint fk_orders_products_order_id_orders_id
        foreign key (order_id)
            references orders (id);
alter table orders_products
    add constraint fk_orders_products_product_id_products_id
        foreign key (product_id)
            references products (id)
            on delete cascade
            on update cascade;


create table roles
(
    id   bigserial
            primary key,
    role varchar(20) not null
);

insert into roles (role)
values ('ROLE_ADMIN'),
       ('ROLE_USER');

alter table users
    add role_id bigint ;

alter table users
    add constraint users_roles_id_fk
        foreign key (role_id) references roles
            on update cascade on delete cascade;