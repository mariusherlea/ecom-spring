package ro.mariusherlea.ecom.model;

import javax.persistence.*;
@Entity
@Table(name = "Order_Details")
public class OrderDetail extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID", nullable = false, //
            foreignKey = @ForeignKey(name = "ORDER_DETAIL_ORD_FK"))
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID", nullable = false, //
            foreignKey = @ForeignKey(name = "ORDER_DETAIL_ITEM_FK"))
    private Item item;

    @Column(name = "ItemQuantity", nullable = false)
    private double ItemQuantity;

    @Column(name = "ItemQuantityPrice", nullable = false)
    private double ItemQuantityPrice;

     public OrderDetail() {
    }

    public OrderDetail(Order order, Item item, double ItemQuantity, double ItemQuantityPrice) {

        this.order = order;
        this.item = item;
        this.ItemQuantity = ItemQuantity;
        this.ItemQuantityPrice = ItemQuantityPrice;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getItemQuantity() {
        return ItemQuantity;
    }

    public void setItemQuantity(double quantity) {
        this.ItemQuantity = quantity;
    }

    public double getItemQuantityPrice() {
        return ItemQuantityPrice;
    }

    public void setItemQuantityPrice(double price) {
        this.ItemQuantityPrice = price;
    }


}
