package com.example.demo.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JEditorPane;
@RestController
public class ConvertHtmlToBase64 {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "test")
    public String getProductList() throws Exception{
//        String url = "https://apis.ezpics.vn/apis/getListLayer";
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
//        map.add("token", "PZ6Bf1bwikKs3mUSvn84FQHrxEyogc1681308540");
//        map.add("action", "edit");
//        map.add("id", "445");
//        map.add("width", "538");
//        map.add("height", "358");
//
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
//
//        ResponseEntity<Product> response = restTemplate.postForEntity( url, request , Product.class );
//        ArrayList<ProductDetail> productDetail = Objects.requireNonNull(response.getBody()).data.productDetail;

        String html = "<h1>Hello, world.</h1>";
        int width = 200, height = 100;

        BufferedImage image = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice().getDefaultConfiguration()
                .createCompatibleImage(width, height);

        Graphics graphics = image.createGraphics();

        JEditorPane jep = new JEditorPane("text/html", html);
        jep.setSize(width, height);
        jep.print(graphics);

        ImageIO.write(image, "png", new File("Image.png"));
        return encodeFileToBase64Binary(new File("Image.png"));

    }
    private static String encodeFileToBase64Binary(File file){
        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = new String(Base64.encodeBase64(bytes,true), "UTF-8");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return encodedfile;
    }

}