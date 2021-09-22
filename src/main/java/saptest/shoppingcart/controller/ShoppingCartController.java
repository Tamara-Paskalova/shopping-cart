package saptest.shoppingcart.controller;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import saptest.shoppingcart.dto.response.ShoppingCartResponseDto;
import saptest.shoppingcart.model.Product;
import saptest.shoppingcart.model.ShoppingCart;
import saptest.shoppingcart.service.ProductService;
import saptest.shoppingcart.service.ShoppingCartService;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ProductService productService;
    private final ShoppingCartService cartService;
    private final ModelMapper mapper;

    public ShoppingCartController(ProductService productService,
                                  ShoppingCartService cartService, ModelMapper mapper) {
        this.productService = productService;
        this.cartService = cartService;
        this.mapper = mapper;
    }

    @PostMapping
    public ShoppingCartResponseDto register() {
        ShoppingCart cart = cartService.registerNewShoppingCart();
        return mapper.map(cart, ShoppingCartResponseDto.class);
    }

    @PutMapping("/add/{id}")
    public ShoppingCartResponseDto addProduct(@PathVariable Long id, @RequestParam Long cartId) {
        ShoppingCart cart = cartService.getById(cartId);
        Product product = productService.getById(id);
        cartService.addProduct(product, cart);
        cartService.calculate(cart);
        cartService.add(cart);
        return mapper.map(cart, ShoppingCartResponseDto.class);
    }

    @PutMapping("/{id}")
    public ShoppingCartResponseDto removeProduct(@PathVariable Long id, @RequestParam Long cartId) {
        ShoppingCart cart = cartService.getById(cartId);
        Product product = productService.getById(id);
        cartService.removeProduct(product, cart);
        cartService.calculate(cart);
        cartService.add(cart);
        return mapper.map(cart, ShoppingCartResponseDto.class);
    }
}
