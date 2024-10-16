CREATE TABLE users (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NULL,
    first_name VARCHAR(255) NULL,
    last_name VARCHAR(255) NULL,
    flag VARCHAR(255) NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,  -- Foreign key linking to users table
    class_name VARCHAR(255),
    grade CHAR(2),
    student_schedule VARCHAR(255),
    CONSTRAINT fk_user
        FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE
);

CREATE TABLE athletes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,  -- Foreign key linking to users table
    speed INT,                
    height INT,               
    weight INT,               
    star_rating INT,          
    athlete_schedule VARCHAR(255),
    CONSTRAINT fk_user_id
        FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE
);


-- Grabbing Student
select u.email, u.first_name, u.last_name, u.flag, s.user_id, s.class_name, s.grade, s.student_schedule
from users u, students s
where u.id = s.user_id;

-- Grabbing Athlete
select u.email, u.first_name, u.last_name, u.flag, a.user_id a.speed, a.height, a.weight, a.star_rating, a.athlete_schedule
from users u, athletes a 
where u.id = a.user_id;

-- Grabbing StudentAthletes
select u.email, u.first_name, u.last_name, u.flag, s.class_name, s.grade, s.student_schedule, a.user_id, a.speed, a.height, a.weight, a.star_rating, a.athlete_schedule
from users u, students s, athletes a
where u.id = s.user_id = a.user_id;


CREATE TABLE teams (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    team_name VARCHAR(255) NOT NULL,
    num_users INT
);

CREATE TABLE teamMembers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,  
    team_id BIGINT NOT NULL,
    CONSTRAINT fk_teamMembers_user_id
        FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_teamMembers_team_id
        FOREIGN KEY (team_id) REFERENCES teams(id)
        ON DELETE CASCADE
);

