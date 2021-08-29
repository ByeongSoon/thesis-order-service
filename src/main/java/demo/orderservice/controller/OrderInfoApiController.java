package demo.orderservice.controller;

import demo.orderservice.model.entity.OrderInfo;
import demo.orderservice.model.network.request.OrderInfoApiRequest;
import demo.orderservice.model.network.response.OrderInfoApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderInfoApiController extends CrudController<OrderInfoApiResponse, OrderInfoApiRequest, OrderInfo>{
}
