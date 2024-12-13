-- Datos de Usuarios
INSERT INTO user (id, name, lastname, email, password, phone_number, balance) VALUES (1, 'John', 'Doe', 'john.doe@example.com', 'password123', '+1234567890', 100);
INSERT INTO user (id, name, lastname, email, password, phone_number, balance) VALUES (2, 'Jane', 'Smith', 'jane.smith@example.com', 'password456', '+0987654321', 200);
INSERT INTO user (id, name, lastname, email, password, phone_number, balance) VALUES (3, 'Alice', 'Brown', 'alice.brown@example.com', 'password789', '+1122334455', 150);

-- Datos de Anuncios
INSERT INTO advertisement (id, title, description, publication_date, task_date, publicated_by_id, assigned_to_id, state) 
VALUES (1, 'Fix the Sink', 'The kitchen sink is leaking and needs to be fixed', '2024-12-01', '2024-12-10', 1, NULL, 'PENDING');
INSERT INTO advertisement (id, title, description, publication_date, task_date, publicated_by_id, assigned_to_id, state) 
VALUES (2, 'Babysit', 'Need someone to babysit my kids for the evening', '2024-12-02', '2024-12-11', 2, NULL, 'PENDING');
INSERT INTO advertisement (id, title, description, publication_date, task_date, publicated_by_id, assigned_to_id, state) 
VALUES (3, 'Dog Walking', 'Looking for someone to walk my dog in the afternoon', '2024-12-03', '2024-12-12', 3, NULL, 'PENDING');

-- Asignar Anuncios
-- Ejemplo de asignación de un anuncio (cambiando el estado y asignando al usuario 2)
UPDATE advertisement SET assigned_to_id = 2, state = 'ASSIGNED' WHERE id = 1;
-- Ejemplo de completar un anuncio (cambiando el estado a COMPLETED y ajustando los balances de los usuarios)
UPDATE advertisement SET state = 'COMPLETED' WHERE id = 2;
UPDATE user SET balance = balance + 50 WHERE id = 2;  -- Usuario que completó la tarea
UPDATE user SET balance = balance - 50 WHERE id = 1;  -- Usuario que publicó el anuncio

