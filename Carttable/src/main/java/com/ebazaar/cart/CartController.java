package com.ebazaar.cart;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ebazaar.user.User;

@RestController
@RequestMapping("/api/cart")
public class CartController { 

    @Autowired
    private cartService CartService;

    @PostMapping("/addcart/{id}")
    public Cart addItem(@PathVariable Long id,@RequestBody Cart cart) {
    	 cart.setUserId(new User(id));
    	return CartService.addItem( cart);
    }


    @PutMapping("/update")
    public void updateQuantity(@PathVariable int userId, @RequestBody Cart cart) {
        CartService.updateQuantity(userId, cart);
    }

    @DeleteMapping("/remove")
    public void removeItem(@PathVariable int cartId ) {
    	CartService.removeItem(cartId);
    }

    @GetMapping("/item/{cartId}")
    public Optional<Cart> getCartItem(@PathVariable int cartId) {
        return CartService.getCartItem(cartId);
    }
    
    @GetMapping("/itemByUserId/{userId}")
    public Optional<Cart> getCartItemByUserId(@PathVariable int userId) {
        return CartService.getCartItemByUserId(userId);
    }

}
