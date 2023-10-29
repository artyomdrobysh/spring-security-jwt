INSERT INTO public.user
(id, username, password_hash)
VALUES
    (1, 'admin', '1234'),
    (2, 'john', '1111');

INSERT INTO public.user_role
(id, role, user_id)
VALUES
    (1, 'USER', 1),
    (2, 'ADMIN', 1),
    (3, 'USER', 2);