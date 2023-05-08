package com.example.demo.controller;

import java.io.*;
import java.util.Base64;

import com.example.demo.entity.Html;
import gui.ava.html.image.generator.HtmlImageGenerator;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
@RestController
public class ConvertHtmlToBase64 {

    @GetMapping(value = "execute")
    public String get() {
        return "success";
    }

    @PostMapping(value = "execute")
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

        HtmlImageGenerator hig = new HtmlImageGenerator();
        hig.loadHtml(html.getHtml());


        var file = new File(UUID.randomUUID() + "-image" + ".png");
        var outputStream = new FileOutputStream(file);
        hig.saveAsImage(file);
        outputStream.close();
        FileInputStream fin = new FileInputStream(file);
        byte[] bytesData = new byte[(int) file.length()];
        fin.read(bytesData, 0, bytesData.length);
        fin.close();
        file.delete();
        return new ResponseEntity<String>(Base64.getEncoder().encodeToString(bytesData).trim(), HttpStatus.OK);
    }

}