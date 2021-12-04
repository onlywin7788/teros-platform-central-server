package com.teros.central_server.controller.api.v1.database.apim.product;

import com.teros.central_server.entity.apim.product.ProductEntity;
import com.teros.central_server.model.apim.product.ModelParamProduct;
import com.teros.central_server.model.response.CommonResult;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.model.response.SingleResult;
import com.teros.central_server.service.database.apim.product.ProductService;
import com.teros.central_server.service.database.apim.response.ResponseService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"apim : product"})
@RestController
@RequestMapping(value = "/v1")
public class ProductRestController {

    private final ProductService productService;
    private final ResponseService responseService;

    public ProductRestController(ProductService productService, ResponseService responseService) {
        this.productService = productService;
        this.responseService = responseService;
    }

    @GetMapping(value = "/product/{id}")
    public SingleResult<ProductEntity> getProduct(@PathVariable long id) {
        return responseService.getSingleResult(productService.getProduct(id));
    }

    @GetMapping(value = "/product")
    public ListResult<ProductEntity> getProductList() {
        return responseService.getListResult(productService.getProductList());
    }

    @PostMapping(value = "/product")
    public void insertProduct(@RequestBody ModelParamProduct modelParamProduct) {
        productService.saveProduct(modelParamProduct);
    }

    @PutMapping(value = "/product/{id}")
    public Long updateProduct(@PathVariable long id, @RequestBody ModelParamProduct modelParamProduct) {

        return productService.updateProduct(id, modelParamProduct);
    }

    @DeleteMapping(value = "/product/{id}")
    public CommonResult deleteProduct(@PathVariable long id) {
        boolean ret = productService.deleteProduct(id);
        return responseService.getResult(ret);
    }
}