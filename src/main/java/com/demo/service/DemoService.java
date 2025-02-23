package com.demo.service;

import com.demo.model.TestEntity;
import com.demo.repo.DemoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.PSSParameterSpec;
import java.util.Base64;
import java.util.List;

@Service
public class DemoService {

    @Autowired
    private DemoRepo repo;

    public List<TestEntity> getAll() {
        return repo.findAll();
    }






}
