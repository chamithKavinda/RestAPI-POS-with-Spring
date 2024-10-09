package org.example.coffeeshopposspringbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.coffeeshopposspringbackend.customeobj.ProductResponse;
import org.example.coffeeshopposspringbackend.exception.DataPersistFailedException;
import org.example.coffeeshopposspringbackend.impl.ProductDTO;
import org.example.coffeeshopposspringbackend.service.ProductService;
import org.example.coffeeshopposspringbackend.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveProduct(
            @RequestPart("pro_id") String pro_id,
            @RequestPart ("category") String category,
            @RequestPart ("price") String price,
            @RequestPart ("pro_img") MultipartFile pro_img,
            @RequestPart ("pro_name") String pro_name,
            @RequestPart ("quantity") String quantity) {
        // Handle product img
        try {
            String base64ProductImg = AppUtil.toBase64ProductImg(pro_img);
            ProductDTO buildProductDTO = new ProductDTO();
            buildProductDTO.setPro_id(pro_id);
            buildProductDTO.setCategory(category);
            buildProductDTO.setPrice(price);
            buildProductDTO.setPro_img(base64ProductImg);
            buildProductDTO.setPro_name(pro_name);
            buildProductDTO.setQuantity(quantity);

            productService.saveProduct(buildProductDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistFailedException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }
}
