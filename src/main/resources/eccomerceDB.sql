 create table customer (
       id bigint not null,
        customer_address varchar(255),
        customer_city varchar(255),
        customer_email varchar(255),
        customer_mobile varchar(255),
        date datetime2,
        first_name varchar(255),
        img varchar(255),
        last_name varchar(255),
        primary key (id)
    )

    create table invoice (
       id bigint not null,
        customer_id bigint,
        date datetime2,
        payment_status varchar(255),
        payment_way varchar(255),
        total double precision,
        primary key (id)
    )

      create table invoice_orders (
       invoice_id bigint not null,
        orders_id bigint not null
    )

     create table order (
       id bigint not null,
        customer_id bigint,
        date datetime2,
        value_from varchar(255),
        order_status varchar(255),
        product_id varchar(255),
        product_name varchar(255),
        qnt int not null,
        seller_id bigint,
        value_to varchar(255),
        primary key (id)
    )

create table product (
       id bigint not null,
        date datetime2,
        descr varchar(255),
        img varchar(255),
        price double precision,
        product_name varchar(255),
        product_qnt int not null,
        seller_id bigint,
        type varchar(255),
        primary key (id)
    )

    create table seller (
       id bigint not null,
        seller_address varchar(255),
        seller_city varchar(255),
        date datetime2,
        first_name varchar(255),
        last_name varchar(255),
        seller_email varchar(255) unique,
        seller_mobile varchar(255),
        primary key (id)
    )

--     Bring seller data
    SELECT [id]
    ,[first_name]
    ,[last_name]
    ,[seller_email]
    ,[seller_mobile]
    ,[seller_city]
    ,[seller_address]
    ,[password]
    ,[date]

FROM [ecommerceDB].[dbo].[seller]

--     Bring coustmers data

SELECT  [id]
      ,[first_name]
      ,[last_name]
      ,[customer_email]
      ,[customer_mobile]
      ,[customer_city]
      ,[customer_address]
      ,[img]
      ,[password]
      ,[date]
  FROM [ecommerceDB].[dbo].[customer]


--     Bring product data

SELECT  [id]
    ,[product_name]
    ,[descr]
    ,[type]
    ,[price]
    ,[product_qnt]
    ,[seller_id]
    ,[img]
    ,[date]
  FROM [ecommerceDB].[dbo].[product]