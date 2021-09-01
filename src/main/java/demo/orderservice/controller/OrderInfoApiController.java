package demo.orderservice.controller;

import demo.orderservice.model.entity.OrderInfo;
import demo.orderservice.model.network.Header;
import demo.orderservice.model.network.request.OrderInfoApiRequest;
import demo.orderservice.model.network.response.OrderInfoApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import demo.orderservice.service.OrderApiLogicService;

@RestController
@RequestMapping("/api/order")
public class OrderInfoApiController extends CrudController<OrderInfoApiResponse, OrderInfoApiRequest, OrderInfo>{

    @Autowired
    private OrderApiLogicService orderApiLogicService;

    @PostMapping("/byConsumer")
    public Header<OrderInfoApiResponse> orderByConsumer(@RequestBody Header<OrderInfoApiRequest> request) {
        return orderApiLogicService.orderByConsumer(request);
    }

}
