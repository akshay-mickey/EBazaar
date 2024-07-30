package com.ebazaar.cart;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.ebazaar.user.User;

@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToOne
    private User userId;

    @Column(name = "ProductID", nullable = false)
    private Long productId;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;
    
    @Column(name = "Price",nullable=false)
    private Long price;
    
    @Column(name = "AddedAt", nullable = false, updatable = false)
    private LocalDateTime addedAt;

    // Getters and Setters
    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

   

    public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDateTime localDateTime) {
        this.addedAt = localDateTime;
    }

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + ", productId=" + productId + ", quantity=" + quantity
				+ ", price=" + price + ", addedAt=" + addedAt + "]";
	}

	public Cart(Long cartId,Long id, Long productId, Integer quantity, Long price, LocalDateTime addedAt) {
		super();
		this.cartId = cartId;
		this.userId = new User(id);
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.addedAt = addedAt;
	}

	public Cart() {
		super();
	}
    
}
