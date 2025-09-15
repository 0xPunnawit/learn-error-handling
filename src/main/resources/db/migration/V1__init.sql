create table if not exists app_user (
  id bigserial primary key,
  email varchar(100) not null unique,
  password_hash varchar(255) not null,
  created_at timestamptz not null default now()
);
