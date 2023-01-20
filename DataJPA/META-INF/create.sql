
    create table aeroporti (
       id bigint not null auto_increment,
        citta varchar(255),
        city varchar(255),
        classe varchar(255),
        country_code varchar(3),
        elevation integer,
        iata varchar(3) not null,
        icao varchar(255),
        latitude varchar(255),
        longitude varchar(255),
        name varchar(255),
        paese varchar(255),
        state varchar(255),
        tipo varchar(255),
        zone_name varchar(255),
        a2 varchar(3) not null,
        primary key (id)
    ) engine=InnoDB;

    create table paesi (
       a2 varchar(3) not null,
        chiave varchar(255),
        en varchar(255),
        it varchar(255),
        tipo varchar(255),
        primary key (a2)
    ) engine=InnoDB;

    alter table aeroporti 
       add constraint UK_3s7lpny328wc9bjri487t84s2 unique (iata);

    alter table aeroporti 
       add constraint FKdbx8oivspk2nsv6f89qi3nycs 
       foreign key (a2) 
       references paesi (a2);
