package org.example.coffeeshopposspringbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.coffeeshopposspringbackend.customeobj.ProductResponse;
import org.example.coffeeshopposspringbackend.exception.DataPersistFailedException;
import org.example.coffeeshopposspringbackend.exception.ProductNotFound;
import org.example.coffeeshopposspringbackend.dto.ProductDTO;
import org.example.coffeeshopposspringbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private final ProductService productService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createProduct(@RequestBody ProductDTO product) {
        if (product == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            try {
                productService.saveProduct(product);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }catch (DataPersistFailedException e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{pro_id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateProduct(@PathVariable ("pro_id") String pro_id, @RequestBody ProductDTO product) {
        try {
            if (product == null || pro_id == null || pro_id.isEmpty()){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            productService.updateProduct(pro_id, product);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (ProductNotFound e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{pro_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse getSelectedProduct(@PathVariable ("pro_id") String pro_id){
        return productService.getSelectedProduct(pro_id);
    }

    @DeleteMapping(value = "/{pro_id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable ("pro_id") String pro_id) {
        try {
            productService.deleteProduct(pro_id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (ProductNotFound e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
