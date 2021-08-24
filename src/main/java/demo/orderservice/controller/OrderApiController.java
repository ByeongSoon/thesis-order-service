package demo.orderservice.controller;

import demo.orderservice.model.entity.Order;
import demo.orderservice.model.network.request.OrderApiRequest;
import demo.orderservice.model.network.response.OrderApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderApiController extends CrudController<OrderApiResponse, OrderApiRequest, Order>{
}
