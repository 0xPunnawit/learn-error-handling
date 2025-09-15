ALTER TABLE app_user
ADD COLUMN first_name VARCHAR(100),
ADD COLUMN last_name VARCHAR(100),
ADD CONSTRAINT chk_phone_number_length CHECK (char_length(phone_number) = 10);
