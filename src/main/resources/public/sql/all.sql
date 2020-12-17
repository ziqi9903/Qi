# User
CREATE TABLE `qi_forum`.`User`  (
    `user_id` bigint NOT NULL AUTO_INCREMENT,
    `account_id` bigint NOT NULL,
    `user_name` varchar(255) NOT NULL,
    `user_password` varchar(255) NOT NULL,
    `token` varchar(255) NULL,
    `gmt_create` bigint(255) NULL,
    `gmt_modified` bigint(255) NULL,
    `avatar_url` varchar(255) NULL,
    PRIMARY KEY (`user_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


#role 角色表
CREATE TABLE `qi_forum`.`role`  (
    `role_id` bigint NOT NULL AUTO_INCREMENT,
    `role_name`  varchar(255) NOT NULL,
    PRIMARY KEY (`role_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 角色 和 用户 中间表
CREATE TABLE `qi_forum`.`t_user_role`  (
      `id` bigint NOT NULL AUTO_INCREMENT,
      `user_id` varchar(255) NOT NULL,
      `role_id` VARCHAR(255) NOT NULL,
      PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#pers 权限表
CREATE TABLE `qi_forum`.`perms`  (
        `perms_id` bigint NOT NULL AUTO_INCREMENT,
        `name` varchar(255) NOT NULL,
        `url` VARCHAR(255) NOT NULL,
        PRIMARY KEY (`perms_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 角色 和 权限 中间表
CREATE TABLE `qi_forum`.`t_role_perms`  (
          `id` bigint NOT NULL AUTO_INCREMENT,
          `role_id` varchar(255) NOT NULL,
          `pers_id` VARCHAR(255) NOT NULL,
          PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;