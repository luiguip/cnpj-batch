create table cnpj_data_folder (
  id bigserial primary key,
  year_month varchar(7) not null,
  last_update timestamp not null
);