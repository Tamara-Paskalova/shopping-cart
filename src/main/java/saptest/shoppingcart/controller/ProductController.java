package saptest.shoppingcart.controller;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import saptest.shoppingcart.dto.request.ProductRequestDto;
import saptest.shoppingcart.dto.response.ProductResponseDto;
import saptest.shoppingcart.model.Product;
import saptest.shoppingcart.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;
    private final ModelMapper mapper;

    public ProductController(ProductService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    ProductResponseDto add(@RequestBody ProductRequestDto dto) {
        Product product = mapper.map(dto, Product.class);
        service.add(product);
        return mapper.map(product, ProductResponseDto.class);
    }
}
