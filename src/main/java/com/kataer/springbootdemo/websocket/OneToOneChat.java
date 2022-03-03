//package com.kataer.springbootdemo.websocket;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import javax.websocket.*;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * @ClassName OneToOneChat
// * @Description: TODO
// * @Author kataer
// * @Date 2020/12/22 20:35
// * @Version V1.0
// **/
//@Slf4j
//@ServerEndpoint(value = "/test/one")
//@Component
//public class OneToOneChat {
//
//    private static final AtomicInteger onlineCount = new AtomicInteger(0);
//    private static final ConcurrentHashMap<String, Session> onlineSessionMap = new ConcurrentHashMap<>();
//
//    @OnOpen
//    public void onOpen(Session session) {
//        log.info("{} 上线了 >>>>>>>>", session.getId());
//        onlineSessionMap.put(session.getId(), session);
//        onlineCount.incrementAndGet();
//    }
//
//    @OnClose
//    public void onClose(Session session) {
//        log.info("{} 下线了 >>>>>>>>", session.getId());
//        onlineSessionMap.remove(session.getId());
//        onlineCount.decrementAndGet();
//    }
//
//    @OnMessage
//    public void onMessage(String message, Session session) {
//        log.info("{} 发送 : {}", session.getId(), message);
////        sendMessage("welcome:" + session.getId(), session);
//        sendMessageToOthers(message, session);
//    }
//
//    @OnError
//    public void onError(Session session, Throwable throwable) {
//        log.error("error >>>>>>>>");
//        throwable.printStackTrace();
//    }
//
//    private void sendMessage(String message, Session toSession) {
//        try {
//            toSession.getBasicRemote().sendText(message);
//        } catch (IOException e) {
//            log.error("服务端发送消息给客户端失败：{}", e);
//        }
//    }
//
//    private void sendMessageToOthers(String message, Session self) {
//        try {
//            for (Map.Entry<String, Session> entry : onlineSessionMap.entrySet()) {
//                if (!entry.getKey().equals(self.getId())) {
//                    entry.getValue().getBasicRemote().sendText(message);
//                }
//            }
//        } catch (IOException e) {
//            log.error("服务端发送消息给客户端失败：{}", e);
//        }
//    }
//}
