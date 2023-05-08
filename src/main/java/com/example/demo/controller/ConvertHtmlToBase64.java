package com.example.demo.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Objects;

import com.example.demo.entity.Html;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.util.UUID;
import javax.imageio.ImageIO;
import javax.swing.JEditorPane;
@RestController
public class ConvertHtmlToBase64 {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "test")
    public String get() {
        return "success";
    }

    @PostMapping(value = "test")
    public ResponseEntity<String> getProductList(@RequestBody Html html) throws Exception{
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

        if(html.getHtml() == null){
            return new ResponseEntity<String>("Not null html", HttpStatus.BAD_REQUEST);
        }
        if(html.getHeight() == null){
            return new ResponseEntity<String>("Not null height", HttpStatus.BAD_REQUEST);
        }
        if(html.getWidth() == null){
            return new ResponseEntity<String>("Not null width", HttpStatus.BAD_REQUEST);
        }

        int width = html.getWidth(), height = html.getHeight();

        BufferedImage image = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice().getDefaultConfiguration()
                .createCompatibleImage(width, height);

        Graphics graphics = image.createGraphics();
        JEditorPane jep = new JEditorPane("text/html", html.getHtml());
        jep.setSize(width, height);
        jep.print(graphics);

        var file = new File(UUID.randomUUID() + "-image.png");
        var outputStream = new FileOutputStream(file);
        ImageIO.write(image, "png", file);
        outputStream.close();
        FileInputStream fin = new FileInputStream(file);
        byte[] bytesData = new byte[(int) file.length()];
        fin.read(bytesData, 0, bytesData.length);
        fin.close();
        file.delete();
        return new ResponseEntity<String>("Base64.getEncoder().encodeToString(bytesData).trim()", HttpStatus.OK);
    }

}