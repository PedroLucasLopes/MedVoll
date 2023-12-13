create table schedules(
    id bigint not null auto_increment,
    professional_id bigint not null,
    patient_id bigint not null,
    data datetime not null,

    primary key(id),
    constraint fk_schedules_professional_id foreign key(professional_id) references professionals(id),
    constraint fk_schedules_patient_id foreign key(patient_id) references patients(id)
);