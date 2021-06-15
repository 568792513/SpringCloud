package org.hui.stream.controller;

import org.hui.entity.Result;
import org.hui.stream.service.IMessageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author zh
 * @Date 2021/6/11 10:44
 * description :
 */
@RestController
@RequestMapping("/api/stream")
public class IMessageController {

    @Resource
    private IMessageService iMessageService;

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public Result sendMessage(@RequestParam String message) {
        return new Result(200, iMessageService.send(message));
    }

}
