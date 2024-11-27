create database chatmate;
use chatmate;
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    profile_image VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO Users (username, email, password_hash, profile_image)
VALUES 
('john_doe', 'john.doe@example.com', 'hashed_password_1', 'profile1.jpg'),
('jane_smith', 'jane.smith@example.com', 'hashed_password_2', 'profile2.jpg'),
('alex_brown', 'alex.brown@example.com', 'hashed_password_3', NULL);
select*from Users;
CREATE TABLE ChatRooms (
    chat_id INT AUTO_INCREMENT PRIMARY KEY,
    chat_name VARCHAR(100),
    is_group BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE UserChats (
    user_chat_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    chat_id INT NOT NULL,
    joined_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (chat_id) REFERENCES ChatRooms(chat_id)
);
INSERT INTO ChatRooms (chat_name, is_group)
VALUES 
('General Chat', TRUE),
('Project Team', TRUE),
(NULL, FALSE); -- Direct chat

CREATE TABLE Messages (
    message_id INT AUTO_INCREMENT PRIMARY KEY,
    chat_id INT NOT NULL,
    sender_id INT NOT NULL,
    content TEXT NOT NULL,
    sent_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_deleted BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (chat_id) REFERENCES ChatRooms(chat_id),
    FOREIGN KEY (sender_id) REFERENCES Users(user_id)
);
INSERT INTO Messages (chat_id, sender_id, content)
VALUES 
(1, 1, 'Hello, everyone!'),
(1, 2, 'Hi, John!'),
(2, 1, 'Let’s start the project discussion.'),
(3, 1, 'Hey Alex, how’s it going?'),
(3, 3, 'Doing great, John. Thanks!');
select*from Messages;

CREATE TABLE Attachments (
    attachment_id INT AUTO_INCREMENT PRIMARY KEY,
    message_id INT NOT NULL,
    file_url VARCHAR(255) NOT NULL,
    file_type VARCHAR(50),
    FOREIGN KEY (message_id) REFERENCES Messages(message_id)
);
INSERT INTO Attachments (message_id, file_url, file_type)
VALUES 
(2, 'https://example.com/video1.mp4', 'video/mp4'),
(4, 'https://example.com/image2.jpg', 'image/jpeg'),
(5, 'https://example.com/audio1.mp3', 'audio/mpeg');
select*from Attachments;




CREATE TABLE Friendships (
    friendship_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    friend_id INT NOT NULL,
    status ENUM('pending', 'accepted', 'blocked') DEFAULT 'pending',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (friend_id) REFERENCES Users(user_id)
);
INSERT INTO Friendships (user_id, friend_id, status)
VALUES 
(1, 2, 'accepted'), -- John and Jane are friends
(1, 3, 'accepted'), -- John and Alex are friends
(2, 3, 'pending'); -- Jane sent a friend request to Alex
select*from Friendships;

