package com.example.demo.controller;

import com.example.demo.service.MessageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;


import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class MessageControllerTest {


    @Mock
    MessageService messageService;

    @InjectMocks
    MessageController messageController;


    @Test
    void methodShould() {
        // given

        String str = "rrruuuuusssssst";
        Map<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('r', 3);
        hashMap.put('u', 5);
        hashMap.put('s', 6);
        hashMap.put('t', 1);

        Mockito.when(this.messageService.method(str)).thenReturn(hashMap);

        //when

        var responseEntity = this.messageController.method(str);

        //then

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(hashMap, responseEntity.getBody());

    }
}

