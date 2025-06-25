-- Insert some sample data
INSERT INTO authors (name, biography) VALUES
('Stephen King', 'Master of horror and suspense.'),
('J.K. Rowling', 'British author, creator of Harry Potter.'),
('George Orwell', 'English novelist, essayist, journalist, and critic.');

INSERT INTO publishers (name, location) VALUES
('Scribner', 'New York'),
('Bloomsbury Publishing', 'London'),
('Secker & Warburg', 'London');

INSERT INTO genres (name) VALUES
('Horror'),
('Fantasy'),
('Dystopian');

INSERT INTO books (title, publication_year, author_id, publisher_id, genre_id) VALUES
('It', 1986, 1, 1, 1),
('Harry Potter and the Sorcerer''s Stone', 1997, 2, 2, 2),
('1984', 1949, 3, 3, 3),
('The Shining', 1977, 1, 1, 1),
('Harry Potter and the Chamber of Secrets', 1998, 2, 2, 2);

INSERT INTO users (username, email) VALUES
('reader1', 'reader1@example.com'),
('bookworm', 'bookworm@example.com'),
('litlover', 'litlover@example.com');

INSERT INTO reviews (rating, comment, book_id, user_id) VALUES
(5, 'A terrifying masterpiece!', 1, 1),
(4, 'Magical and enchanting.', 2, 2),
(5, 'A chilling classic, highly relevant today.', 3, 3),
(3, 'Good, but not as scary as It.', 4, 1),
(5, 'Another great installment!', 5, 2);