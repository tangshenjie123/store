package com.tangshenjie.store.service;

import com.tangshenjie.store.mapper.user.meta.StoreUser;
import org.apache.commons.codec.binary.Base64;

import javax.annotation.Resource;
import java.security.SecureRandom;

public class SecurityService {
    @Resource
    private StoreUser storeUser;

    public void generateRandomSalt() {
        SecureRandom secureRandom = new SecureRandom();
        byte bytes[] = new byte[16];
        secureRandom.nextBytes(bytes);
        String passwordSalt = Base64.encodeBase64String(bytes);
        storeUser.setPasswordSalt(passwordSalt);
    }
}
