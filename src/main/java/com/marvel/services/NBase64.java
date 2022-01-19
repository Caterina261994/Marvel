package com.marvel.services;

import org.apache.commons.codec.binary.Base64;

import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;

public class NBase64 {
    public String makeBase64(InputStream inputStream) throws IOException {

        byte[] bytes = IOUtils.toByteArray(inputStream);
        String base64 = Base64.encodeBase64String(bytes);
        return base64;
    }
}
