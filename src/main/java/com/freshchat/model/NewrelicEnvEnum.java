package com.freshchat.model;

import java.util.HashMap;
import java.util.Map;

public enum NewrelicEnvEnum {

    BROWN(53465151),
    Freshchat_AUI_WS14(113559942),
    Freshchat_EU_WS1(72584013),
    Freshchat_US_AU1(90975762),
    Freshchat_US_WS1(54118502),
    Freshchat_US_WS6(63651764),
    Freshchat_WS30(134142440),
    Hotline_Web_3(21920664),
    Orange(98301470),
    WEB_3_PR(11885981);

    int id;
    NewrelicEnvEnum(int id)
    {
        this.id=id;
    }

    public int getId() { return id; }

    private static Map<Integer, NewrelicEnvEnum> reverseLookup = new HashMap() {{
        for(NewrelicEnvEnum env:NewrelicEnvEnum.values()) {
            put(env.getId(), env);
        }
    }};

    public static NewrelicEnvEnum getEnvName(int id) {
        return reverseLookup.get(id);
    }
}
