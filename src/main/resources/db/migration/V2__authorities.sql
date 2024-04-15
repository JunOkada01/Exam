CREATE TABLE `authorities` (
`id` SERIAL NOT NULL COMMENT 'ID',
`firstname` VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
`lastname` VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
`email` VARCHAR(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
`number` VARCHAR(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
`balance` VARCHAR(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
`username` varchar(255) NOT NULL,
`authority` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;