package com.flincore.jawrs.jawrs_demo.utils;

import com.flincore.jawrs.jawrs_demo.models.User;

import java.util.Objects;

public class EntityAppender {

    public static void append(User toReplace, User dataUser){
        if (Objects.nonNull(dataUser.getFirstName())){
            toReplace.setFirstName(dataUser.getFirstName());
        }

        if (Objects.nonNull(dataUser.getSecondName())){
            toReplace.setSecondName(dataUser.getSecondName());
        }

        if (Objects.nonNull(dataUser.getPaternalLastName())){
            toReplace.setPaternalLastName(dataUser.getPaternalLastName());
        }

        if (Objects.nonNull(dataUser.getMaternalLastName())){
            toReplace.setMaternalLastName(dataUser.getMaternalLastName());
        }

        toReplace.setRelated(dataUser.getRelated());
    }
}
