package org.example.dataManager.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static org.example.utils.configs.UrlConfig.BASE_URL;

@Getter
@AllArgsConstructor
public enum Pages {
    HOME_PAGE("HomePage", "/");

    private final String pageName;
    private final String pageUrl;

    public String getPageUrl(){
        return BASE_URL + pageUrl;

    };
}
