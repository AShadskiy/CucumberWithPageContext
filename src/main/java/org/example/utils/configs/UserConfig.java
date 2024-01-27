package org.example.utils.configs;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.dataManager.User;
import org.example.dataManager.UserModel;
import org.example.exceptions.ConfigManagerException;

import java.io.File;
import java.io.IOException;

/**
 * User config class
 */
@Slf4j
public class UserConfig {

    private final String login;
    private final String password;

    UserConfig(User user) {
        this.login = getUser(user).getEmail();
        this.password = getUser(user).getPassword();
    }

    public static UserModel getUser(User user) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(new File(ConfigManager.CURRENT_USER_CONFIG));
            return objectMapper.treeToValue(jsonNode.get(user.getRoleName()), UserModel.class);
        } catch (IOException e) {
            throw new ConfigManagerException(e);
        }
    }

}
